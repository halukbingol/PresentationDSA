#@ javac Depth.java
java -Xss256k Depth
java -Xss1m Depth
java -Xss8m Depth
java -XX:+PrintFlagsFinal -version 2>/dev/null | grep -E " ThreadStackSize "
