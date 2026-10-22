#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ junit() { java -jar $JUNIT execute --disable-banner --disable-ansi-colors --details-theme=ascii --include-engine=junit-jupiter "$@" 2>&1 | sed '/^Test run finished after/d; /^WARNING: Delegated/,+2d'; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT4=/usr/share/java/junit4.jar:/usr/share/java/hamcrest-core.jar
javac -d bin -cp $JUNIT:$JUNIT4 LegacyAccountTest.java AccountDepositsTest.java
java -jar $JUNIT execute --disable-banner --disable-ansi-colors --details-theme=ascii -cp bin:$JUNIT4 --scan-classpath bin | head -10
