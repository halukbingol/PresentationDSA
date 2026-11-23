#@ rm -rf out NAMES.txt
javac -d out CopyUpper.java
java -cp out CopyUpper
cat NAMES.txt
#@ rm -rf out NAMES.txt
