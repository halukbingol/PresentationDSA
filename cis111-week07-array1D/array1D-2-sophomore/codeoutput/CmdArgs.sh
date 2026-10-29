#@ rm -rf out
javac -d out Total.java
java -cp out Total 12 7 30
java -cp out Total
java -cp out Total 12 seven 2>&1 | grep -v java.base
#@ rm -rf out
