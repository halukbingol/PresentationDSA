# Streams
. codeoutput/session.inc
fresh Streams
run 'javac Upper.java'
run 'java Upper < names.txt'
run 'java Upper < names.txt > out.txt'
run 'cat out.txt'
run 'java Upper < names.txt 2> err.txt'
run 'cat err.txt'
