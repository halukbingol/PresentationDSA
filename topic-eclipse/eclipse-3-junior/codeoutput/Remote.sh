#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ ecj -17 -g -d bin src/Average.java
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 -cp bin Average > server.log 2>&1 &
sleep 1
cat attach.txt
slowly attach.txt | jdb -attach 5005 -sourcepath src
#@ sleep 1
cat server.log
