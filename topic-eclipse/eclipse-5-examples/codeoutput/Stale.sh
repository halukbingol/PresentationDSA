#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
ecj -17 -d bin Shop.java Buy.java
java -cp bin Buy
cp Shop2.java Shop.java
ecj -17 -d bin Shop.java
java -cp bin Buy
ecj -17 -d bin Shop.java Buy.java
java -cp bin Buy
