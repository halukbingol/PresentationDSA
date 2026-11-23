#@ rm -rf out
javac -d out Deep.java Hog.java
java -Xss512k -cp out Deep
java -Xmx32m -cp out Hog
#@ rm -rf out
