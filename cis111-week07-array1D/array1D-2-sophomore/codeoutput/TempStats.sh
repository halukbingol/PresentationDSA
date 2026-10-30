#@ J="${JUNIT_LIB:-$HOME/.p2/pool/plugins}"; S=":"; case "$(uname -s)" in MINGW*|MSYS*|CYGWIN*) S=";";; esac; CP="out"; for j in junit-jupiter-api junit-jupiter-engine junit-platform-commons junit-platform-engine junit-platform-launcher org.opentest4j org.apiguardian.api; do f=$(ls "$J"/${j}_*.jar | tail -n 1); command -v cygpath > /dev/null && f=$(cygpath -w "$f"); CP="$CP$S$f"; done; export CLASSPATH="$CP"
#@ rm -rf out
javac -d out TempStats.java TempStatsTest.java RunTests.java
java RunTests TempStatsTest
#@ rm -rf out
