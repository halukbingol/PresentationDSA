#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ ecj -17 -d bin Check.java
java -cp bin Check 20
java -cp bin Check -5
java -ea -cp bin Check -5
