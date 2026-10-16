java -XshowSettings:vm -version 2>&1 | head -2
java -Xmx64m -XshowSettings:vm -version 2>&1 | head -2
export JDK_JAVA_OPTIONS=-Xmx32m
java -XshowSettings:vm -version 2>&1 | head -3
unset JDK_JAVA_OPTIONS
java -XX:+PrintFlagsFinal -version 2>/dev/null | grep -E " (MaxHeapSize|UseG1GC) " | awk '{print $2, $4}'
javac Hog.java
java -Xmx32m Hog
