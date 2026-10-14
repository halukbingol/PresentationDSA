#@ javac -d out App.java
java -Xlog:class+load -cp out App | wc -l
java -Xlog:class+load -cp out App | grep -c "shared objects file"
java -Xlog:class+load -cp out App | grep " App "
java -Xshare:off -Xlog:class+load -cp out App | grep -c "shared objects file"
