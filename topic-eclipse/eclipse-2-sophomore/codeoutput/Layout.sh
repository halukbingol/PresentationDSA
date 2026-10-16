#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
find src -name "*.java" | sort
ecj -17 -d bin src
find bin -name "*.class" | sort
java -cp bin tr.edu.yeditepe.grades.Main
