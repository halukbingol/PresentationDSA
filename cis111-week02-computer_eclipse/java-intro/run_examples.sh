#!/bin/sh
# Run every program in codeoutput/ and save what it prints to codeoutput/<name>.txt
# (stdout and stderr, so compiler and runtime errors appear on the slides too).
# If codeoutput/<name>.in exists, it is used as the program's keyboard input.
# Usage:  sh run_examples.sh                 (run all)
#         sh run_examples.sh Loops.java      (run one)

cd "$(dirname "$0")" || exit 1
mkdir -p build
here=$(pwd)

if [ $# -gt 0 ]; then
    files=$(for f in "$@"; do echo "codeoutput/$f"; done)
else
    files=$(ls codeoutput/*.java codeoutput/*.py codeoutput/*.c codeoutput/*.sh 2>/dev/null)
fi

for f in $files; do
    name=$(basename "$f")
    base=${name%.*}
    out="codeoutput/$base.txt"
    in="codeoutput/$base.in"
    [ -f "$in" ] || in=/dev/null
    case "$name" in
        *.java) if env -u JAVA_TOOL_OPTIONS javac -encoding UTF-8 -d build "$f" > "$out" 2>&1; then
                    env -u JAVA_TOOL_OPTIONS java -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 \
                        -cp build "$base" < "$in" > "$out" 2>&1
                fi ;;
        *.py)   python3 "$f" < "$in" 2>&1 | sed "s|$here/||g" > "$out" ;;
        *.c)    gcc -O2 -Wall -o "build/$base" "$f" > "$out" 2>&1 \
                    && "./build/$base" < "$in" > "$out" 2>&1 ;;
        *.sh)   sh "$f" < "$in" > "$out" 2>&1 ;;
        *)      echo "skip  $f"; continue ;;
    esac
    echo "ran   $f -> $out"
done
