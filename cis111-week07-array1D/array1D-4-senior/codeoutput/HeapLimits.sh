#@ rm -rf out
javac -d out Huge.java
java -Xmx64m -cp out Huge 10000000
java -Xmx64m -cp out Huge 20000000
java -cp out Huge 2147483647
#@ rm -rf out
