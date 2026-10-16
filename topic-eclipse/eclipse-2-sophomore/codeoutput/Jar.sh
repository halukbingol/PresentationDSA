#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ ecj -17 -d bin src
jar --create --file grades.jar --main-class tr.edu.yeditepe.grades.Main -C bin .
jar --list --file grades.jar
java -jar grades.jar
