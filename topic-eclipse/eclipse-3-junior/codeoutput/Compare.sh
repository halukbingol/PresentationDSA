#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
javac -Xlint:all -d out1 Legacy.java 2>&1 | grep -v -e "where E" -e "E extends" -e "missing type"
ecj -17 -d out2 Legacy.java
