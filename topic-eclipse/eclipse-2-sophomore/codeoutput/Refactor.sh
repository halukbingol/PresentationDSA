#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
ecj -17 -d before before/Report.java
ecj -17 -d after after/Report.java
java -cp before Report
java -cp after Report
