javac -d classes src/edu/yeditepe/hello/Hello.java
find classes -type f
jar --create --file hello.jar --main-class edu.yeditepe.hello.Hello -C classes .
jar --list --file hello.jar
java -jar hello.jar Ayşe
java -cp classes edu.yeditepe.hello.Hello Can
