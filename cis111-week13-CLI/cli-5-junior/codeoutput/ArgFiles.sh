# ArgFiles
. codeoutput/session.inc
fresh ArgFiles
run 'javac -d out Memory.java'
run 'cat jvm.options'
run 'java @jvm.options Memory'
run 'JDK_JAVA_OPTIONS="-Xmx32m" java -cp out Memory'
