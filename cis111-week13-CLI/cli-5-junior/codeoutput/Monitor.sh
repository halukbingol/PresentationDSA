#@ javac Server.java
java -Xmx64m Server &
sleep 1
jps
jcmd Server VM.version
jcmd Server VM.flags | tr " " "\n" | grep MaxHeap
jcmd Server Thread.print | grep -c "java.lang.Thread.State"
jcmd Server GC.heap_info | head -3 | cut -c1-70
#@ kill $(jps | awk '/ Server$/{print $1}')
