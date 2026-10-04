# Options
. codeoutput/session.inc
fresh Options
run 'javac Memory.java'
run 'java Memory'
run 'java -Xmx64m Memory'
run 'java -XX:+PrintFlagsFinal -version 2>/dev/null | grep -E " (MaxHeapSize|MaxRAMPercentage|UseG1GC) "'
run 'java -verbose:class Memory | grep -c "class,load"'
