#@ mkdir -p s1/edu s2/edu c1 c2 lib
#@ printf 'package edu;\npublic class Version { public static String get() { return "1.0"; } }\n' > s1/edu/Version.java
#@ printf 'package edu;\npublic class Version { public static String get() { return "2.0"; } }\n' > s2/edu/Version.java
#@ javac -d c1 s1/edu/Version.java && jar --create --file lib/version-1.0.jar -C c1 .
#@ javac -d c2 s2/edu/Version.java && jar --create --file lib/version-2.0.jar -C c2 .
#@ rm -rf s1 s2 c1 c2
ls lib
javac -cp lib/version-1.0.jar App.java
java -cp .:lib/version-1.0.jar:lib/version-2.0.jar App
java -cp .:lib/version-2.0.jar:lib/version-1.0.jar App
java -cp ".:lib/*" App
export CLASSPATH=lib/version-2.0.jar
java App
java -cp .:$CLASSPATH App
unset CLASSPATH
