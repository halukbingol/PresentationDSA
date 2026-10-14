#@ javac -d out Startup.java
#@ jar --create --file app.jar --main-class Startup -C out .
#@ TIMEFORMAT="%R s"
java -jar app.jar
time (for i in 1 2 3 4 5; do java -Xshare:off -jar app.jar > /dev/null; done)
time (for i in 1 2 3 4 5; do java -jar app.jar > /dev/null; done)
java -XX:ArchiveClassesAtExit=app.jsa -jar app.jar > /dev/null
ls -lh app.jsa | awk '{print $5, $9}'
time (for i in 1 2 3 4 5; do java -XX:SharedArchiveFile=app.jsa -jar app.jar > /dev/null; done)
