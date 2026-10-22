#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ junit() { java -jar $JUNIT execute --disable-banner --disable-ansi-colors --details-theme=ascii --include-engine=junit-jupiter "$@" 2>&1 | sed '/^Test run finished after/d; /^WARNING: Delegated/,+2d'; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
javac -d bin -cp $JUNIT TimeoutsTest.java
junit -cp bin --select-class TimeoutsTest | head -8 | sed -E 's/by [0-9]+ ms/by ... ms/'
