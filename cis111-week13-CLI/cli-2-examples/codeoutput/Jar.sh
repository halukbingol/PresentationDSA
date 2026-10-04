# Jar
. codeoutput/session.inc
fresh Jar
run 'javac -d out src/edu/yeditepe/hello/*.java'
run 'jar --create --file hello.jar --main-class edu.yeditepe.hello.Main -C out .'
run 'jar --list --file hello.jar'
run 'java -jar hello.jar'
run 'unzip -p hello.jar META-INF/MANIFEST.MF'
