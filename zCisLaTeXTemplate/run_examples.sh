#!/bin/sh
# Run every program in code/ and save what it prints to output/<name>.txt.
# Both stdout and stderr are captured, so error messages appear in the slides too.
# Usage:  sh run_examples.sh            (run all)
#         sh run_examples.sh primes.py  (run one)

cd "$(dirname "$0")" || exit 1
mkdir -p output build
here=$(pwd)

if [ $# -gt 0 ]; then files=$(for f in "$@"; do echo "code/$f"; done); else files=$(ls code/*); fi

for f in $files; do
    name=$(basename "$f")
    base=${name%.*}
    out="output/$base.txt"
    case "$name" in
        *.py)   python3 "$f" 2>&1 | sed "s|$here/||g" > "$out" ;;   # shorten paths in tracebacks
        *.c)    gcc -O2 -Wall -o "build/$base" "$f" > "$out" 2>&1 \
                    && "./build/$base" > "$out" 2>&1 ;;
        *.java) env -u JAVA_TOOL_OPTIONS javac -d build "$f" > "$out" 2>&1 \
                    && env -u JAVA_TOOL_OPTIONS java -cp build "$base" > "$out" 2>&1 ;;
        *.sh)   sh "$f" > "$out" 2>&1 ;;
        *)      echo "skip  $f (unknown type)"; continue ;;
    esac
    echo "ran   $f -> $out"
done
