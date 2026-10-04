# CDS
[ -n "$BASH_VERSION" ] || exec bash "$0" "$@"
TIMEFORMAT="real %3Rs"
. codeoutput/session.inc
fresh CDS
run 'javac -d out src/app/Startup.java'
run 'jar --create --file app.jar --main-class app.Startup -C out .'
run 'java -Xlog:class+load -jar app.jar | grep -c "shared objects file"'
run 'java -Xshare:off -Xlog:class+load -jar app.jar | grep -c "source: jrt"'
run 'java -XX:ArchiveClassesAtExit=app.jsa -jar app.jar'
run 'time java -Xshare:off -jar app.jar > /dev/null'
run 'time java -jar app.jar > /dev/null'
run 'time java -XX:SharedArchiveFile=app.jsa -jar app.jar > /dev/null'
