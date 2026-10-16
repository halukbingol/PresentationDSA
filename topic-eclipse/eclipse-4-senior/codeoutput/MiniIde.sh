#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ export JDT=/usr/share/java/eclipse-jdt-core.jar
#@ javac -cp $JDT MiniIde.java
java -cp $JDT:. MiniIde Hello.java
java -cp $JDT:. MiniIde Broken.java
