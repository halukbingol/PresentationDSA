#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ ecj -17 -d b before/Circle.java
#@ ecj -17 -d a after/Circle.java
java -cp b Circle
java -cp a Circle
diff before/Circle.java after/Circle.java
