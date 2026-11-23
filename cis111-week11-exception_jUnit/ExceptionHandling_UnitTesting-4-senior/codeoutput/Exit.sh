#@ rm -rf out
javac -d out Crash.java
java -cp out Crash; echo "exit status $?"
java -cp out Crash x 2>/dev/null; echo "exit status $?"
#@ rm -rf out
