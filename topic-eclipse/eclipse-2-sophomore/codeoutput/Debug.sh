#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ ecj -17 -g -d bin src
cat debug.txt
slowly debug.txt | jdb -classpath bin -sourcepath src tr.edu.yeditepe.grades.Main
