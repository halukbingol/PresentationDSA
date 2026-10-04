# Layout
. codeoutput/session.inc
fresh Layout
run 'find src -name "*.java" > sources.txt'
run 'cat sources.txt'
run 'javac -d out @sources.txt'
run 'find out -name "*.class"'
run 'java -cp out edu.yeditepe.bank.Main'
