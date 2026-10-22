#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ junit() { java -jar $JUNIT execute --disable-banner --disable-ansi-colors --details-theme=ascii --include-engine=junit-jupiter "$@" 2>&1 | sed '/^Test run finished after/d; /^WARNING: Delegated/,+2d'; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
javac -d bin -cp $JUNIT LeapTest.java 2>&1 | head -4
cp step1/Leap.java .
javac -d bin -cp $JUNIT Leap.java LeapTest.java
junit -cp bin --select-class LeapTest | head -8
cp step2/Leap.java .
javac -d bin -cp $JUNIT Leap.java LeapTest.java
junit -cp bin --select-class LeapTest | head -8
