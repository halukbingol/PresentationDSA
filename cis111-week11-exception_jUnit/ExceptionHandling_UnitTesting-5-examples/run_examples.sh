#!/usr/bin/env bash
# run_examples.sh -- run every program in codeoutput/ and save what it prints
#
#   codeoutput/<Name>.java (+ <Name>.in, <Name>.args)    -> codeoutput/<Name>.txt
#       compiled with "javac -g" (as Eclipse does), then run; stdout and stderr are saved,
#       so compile errors and exceptions appear exactly as the student sees them
#   codeoutput/<Name>.sh (+ project folder codeoutput/<Name>/) -> codeoutput/<Name>.txt
#       a terminal session, run in codeoutput/<Name>/ (or codeoutput/ if there is no such folder):
#       every line is shown as "$ line" followed by its output;
#       lines starting with "#@ " run silently (setup); other "#" lines and empty lines are skipped
#
# usage
#   bash run_examples.sh                 run everything
#   bash run_examples.sh Name.java       run one program (or Name.sh)
#
# needs
#   bash        macOS: Terminal;  Windows: Git Bash
#   JDK 17+     javac and java on the PATH (check: javac -version)

cd "$(dirname "$0")/codeoutput" || exit 1

BUILD=".build"          # class files; removed at the end
ENC="-Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8"

# remove lines that the JVM adds when JAVA_TOOL_OPTIONS or _JAVA_OPTIONS is set
clean() { grep -v -e '^Picked up JAVA_TOOL_OPTIONS' -e '^Picked up _JAVA_OPTIONS'; }

run_java() {   # $1 = Name.java
	local name="${1%.java}" out="${1%.java}.txt"
	rm -rf "$BUILD" && mkdir -p "$BUILD"
	if javac -g -encoding UTF-8 -d "$BUILD" "$1" > "$out.tmp" 2>&1; then
		local args=()
		[ -f "$name.args" ] && eval "args=( $(cat "$name.args") )"
		if [ -f "$name.in" ]; then
			java $ENC -cp "$BUILD" "$name" "${args[@]}" < "$name.in" >> "$out.tmp" 2>&1
		else
			java $ENC -cp "$BUILD" "$name" "${args[@]}" < /dev/null >> "$out.tmp" 2>&1
		fi
	fi
	clean < "$out.tmp" > "$out"; rm -f "$out.tmp"
	echo "  $1 -> $out"
}

run_session() {   # $1 = Name.sh
	local name="${1%.sh}" out="${1%.sh}.txt" dir="."
	[ -d "$name" ] && dir="$name"
	(
		cd "$dir" || exit 1
		while IFS= read -r line || [ -n "$line" ]; do
			line="${line%$'\r'}"
			case "$line" in
				"#@ "*) eval "${line#\#@ }" < /dev/null > /dev/null 2>&1 ;;
				""|"#"*) ;;
				*) printf '$ %s\n' "$line"; eval "$line" < /dev/null 2>&1 ;;
			esac
		done
	) < "$1" 2>&1 | clean > "$out"
	echo "  $1 -> $out"
}

if [ $# -gt 0 ]; then
	files=("$@")
else
	files=(*.java *.sh)
fi
for f in "${files[@]}"; do
	[ -f "$f" ] || continue
	case "$f" in
		*.java) run_java "$f" ;;
		*.sh)   run_session "$f" ;;
	esac
done
rm -rf "$BUILD"
