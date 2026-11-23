#@ rm -rf out
javac -d out FastThrow.java
java -cp out FastThrow
java -XX:-OmitStackTraceInFastThrow -cp out FastThrow
#@ rm -rf out
