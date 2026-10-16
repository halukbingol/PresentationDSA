#@ javac -d out App.java
cat options.txt
java @options.txt App one two
export JAVA_TOOL_OPTIONS=-Dgreeting=Hi
java -cp out App
javac -version
unset JAVA_TOOL_OPTIONS
export JDK_JAVA_OPTIONS=-Dgreeting=Selam
java -cp out App
javac -version
