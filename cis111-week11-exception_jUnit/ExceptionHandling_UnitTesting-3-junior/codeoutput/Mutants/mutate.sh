#!/usr/bin/env bash
# mutate.sh: make small changes (mutants) to Grades.java and run both test classes on each.
# A mutant is "killed" if at least one test fails, "survived" if all tests pass.
mutants=(
	's/score >= 90/score > 90/'
	's/score >= 80/score >= 81/'
	's/score >= 70/score >= 75/'
	's/score >= 60/score > 60/'
	's/score > 100/score >= 100/'
	's/score < 0 ||/score < -1 ||/'
	's/score > 100/score > 1000/'
	"s/return 'D';/return 'F';/"
)
result() {   # $1 = test class; prints killed or survived
	if java RunTests "$1" | grep -q 'Errors: 0   Failures: 0'; then echo survived; else echo killed; fi
}
printf '%-46s %-10s %s\n' "mutant (sed command)" "WeakTest" "StrongTest"
weak=0; strong=0
for m in "${mutants[@]}"; do
	rm -rf out && mkdir out
	sed "$m" Grades.java > out/Grades.java
	javac -d out out/Grades.java WeakTest.java StrongTest.java RunTests.java
	w=$(result WeakTest); s=$(result StrongTest)
	[ "$w" = killed ] && weak=$((weak + 1)); [ "$s" = killed ] && strong=$((strong + 1))
	printf '%-46s %-10s %s\n' "$m" "$w" "$s"
done
rm -rf out
echo "killed: WeakTest $weak of ${#mutants[@]}, StrongTest $strong of ${#mutants[@]}"
