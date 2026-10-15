#!/bin/bash
# Run the examples of one deck and save what they print to codeoutput/<Name>.txt
#
#   <Name>.java  compiled and run (stdout and stderr are both saved);
#                <Name>.in   = keyboard input,  <Name>.args = program arguments
#   <Name>.sh    a terminal session: each line is shown as "$ line" followed by
#                its output. Empty lines and "# comments" are skipped; a line
#                starting with "#@ " runs silently (setup). The session runs in a
#                fresh copy of the folder codeoutput/<Name>/ (if it exists), so it
#                never changes your files.
#
# Usage (macOS: Terminal; Windows: Git Bash), from the deck folder:
#   bash run_examples.sh              run all
#   bash run_examples.sh Hello.sh     run one

cd "$(dirname "$0")" || exit 1
unset JAVA_TOOL_OPTIONS          # some systems set it; it adds a line to every output
# Same starting point on every computer: an English (US) system in Istanbul.
# Examples that need another locale say so on the command line (-Duser.language=tr, LANG=tr_TR.UTF-8, ...).
export LANG=en_US.UTF-8 TZ=Europe/Istanbul
unset LC_ALL LC_CTYPE LC_MESSAGES LC_NUMERIC LC_TIME LC_COLLATE LC_MONETARY LANGUAGE
here=$(pwd)
mkdir -p build

session() {                      # session <file> <output> <folder to copy>
    work=$(mktemp -d "${TMPDIR:-/tmp}/session.XXXXXX")
    [ -d "$3" ] && cp -R "$3/." "$work/"
    (
        cd "$work" || exit 1
        rc=0
        while IFS= read -r line <&3 || [ -n "$line" ]; do
            case "$line" in
                '#@ '*) eval "${line#\#@ }" </dev/null >/dev/null 2>&1 ;;
                ''|'#'*) ;;
                *) printf '$ %s\n' "$line"; (exit $rc); eval "$line" </dev/null 2>&1; rc=$? ;;
            esac
        done 3< "$here/$1"
    ) > "$2.tmp" 2>&1
    sed -e "s#$work#~/project#g" -e "s#$(dirname "$work")/session\.[A-Za-z0-9]*#~/project#g" "$2.tmp" > "$2"
    rm -f "$2.tmp"; rm -rf "$work"
}

if [ $# -gt 0 ]; then
    files=$(for f in "$@"; do echo "codeoutput/$f"; done)
else
    files=$(ls codeoutput/*.java codeoutput/*.sh 2>/dev/null)
fi

for f in $files; do
    name=$(basename "$f"); base=${name%.*}; out="codeoutput/$base.txt"
    in="codeoutput/$base.in"; [ -f "$in" ] || in=/dev/null
    case "$name" in
        *.java) args=""; [ -f "codeoutput/$base.args" ] && args=$(cat "codeoutput/$base.args")
                if javac -encoding UTF-8 -d build "$f" > "$out" 2>&1; then
                    java -Duser.language=en -Duser.country=US -Dstdout.encoding=UTF-8 -cp build "$base" $args < "$in" > "$out" 2>&1
                fi ;;
        *.sh)   session "$f" "$out" "codeoutput/$base" ;;
        *)      continue ;;
    esac
    echo "ran   $f -> $out"
done
