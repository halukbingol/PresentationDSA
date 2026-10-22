#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ junit() { java -jar $JUNIT execute --disable-banner --disable-ansi-colors --details-theme=ascii --include-engine=junit-jupiter "$@" 2>&1 | sed '/^Test run finished after/d; /^WARNING: Delegated/,+2d'; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ J=/usr/share/java; export JACOCO=$J/org.jacoco.core.jar:$J/org.jacoco.report.jar:$J/asm.jar:$J/asm-commons.jar:$J/asm-tree.jar
#@ unzip -q -o $J/org.jacoco.agent.jar jacocoagent.jar
#@ javac -d tools -cp $JACOCO Coverage.java
javac -g -d bin -cp $JUNIT Grade.java GradeTest.java
java -javaagent:jacocoagent.jar=destfile=jacoco.exec -jar $JUNIT execute -cp bin --select-class GradeTest --details=none --disable-banner
java -cp tools:$JACOCO Coverage jacoco.exec bin/Grade.class
