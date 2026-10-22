#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ junit() { java -jar $JUNIT execute --disable-banner --disable-ansi-colors --details-theme=ascii --include-engine=junit-jupiter "$@" 2>&1 | sed '/^Test run finished after/d; /^WARNING: Delegated/,+2d'; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export MOCKITO=/usr/share/java/mockito-core.jar:/usr/share/java/byte-buddy.jar:/usr/share/java/byte-buddy-agent.jar:/usr/share/java/objenesis.jar

javac -d bin -cp $JUNIT:$MOCKITO *.java
junit -cp bin:$MOCKITO --select-class ReminderTest | head -6
