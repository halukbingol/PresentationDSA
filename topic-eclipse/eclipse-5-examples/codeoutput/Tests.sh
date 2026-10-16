#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ junit() { java -jar $JUNIT execute --disable-banner --disable-ansi-colors --details=tree --details-theme=ascii --include-engine=junit-jupiter "$@" 2>&1 | sed -n '1,/^$/p'; }
ecj -17 -cp $JUNIT -d bin Fact.java FactTest.java
junit -cp bin --select-class FactTest
