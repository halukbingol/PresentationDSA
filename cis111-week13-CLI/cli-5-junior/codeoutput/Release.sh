# Release
. codeoutput/session.inc
fresh Release
run 'javac --release 8 -Xlint:-options -d out8 Repeat.java'
run 'javac --release 11 -d out11 Repeat.java'
run 'javap -v -cp out11 Repeat | grep major'
run 'javac -d out21 Repeat.java'
run 'javap -v -cp out21 Repeat | grep major'
run 'java -cp out11 Repeat'
