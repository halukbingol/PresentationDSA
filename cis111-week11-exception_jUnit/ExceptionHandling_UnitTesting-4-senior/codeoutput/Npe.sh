#@ rm -rf out g0
javac -g -d out Npe.java
java -cp out Npe 2>&1 | grep Exception
javac -g:none -d g0 Npe.java
java -cp g0 Npe 2>&1 | grep Exception
java -XX:-ShowCodeDetailsInExceptionMessages -cp out Npe 2>&1 | grep Exception
#@ rm -rf out g0
