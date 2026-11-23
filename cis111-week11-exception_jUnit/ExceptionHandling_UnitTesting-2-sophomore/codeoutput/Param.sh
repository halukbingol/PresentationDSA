#@ J="${JUNIT_LIB:-$HOME/.p2/pool/plugins}"; S=":"; case "$(uname -s)" in MINGW*|MSYS*|CYGWIN*) S=";";; esac; CP="out"; for j in junit-jupiter-api junit-jupiter-engine junit-jupiter-params junit-platform-commons junit-platform-engine junit-platform-launcher org.opentest4j org.apiguardian.api; do f=$(ls "$J"/${j}_*.jar | tail -n 1); command -v cygpath > /dev/null && f=$(cygpath -w "$f"); CP="$CP$S$f"; done; export CLASSPATH="$CP"
#@ cd JUnitMore
#@ rm -rf out
javac -d out Grades.java GradesParamTest.java RunTests.java
java RunTests GradesParamTest
#@ rm -rf out
