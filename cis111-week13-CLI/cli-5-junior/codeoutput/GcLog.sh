# GcLog
. codeoutput/session.inc
fresh GcLog
run 'javac Garbage.java'
run 'java -Xmx64m -Xlog:gc Garbage | sed -n 1,6p'
