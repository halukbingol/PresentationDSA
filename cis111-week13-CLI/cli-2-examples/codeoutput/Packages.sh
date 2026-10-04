# Packages
. codeoutput/session.inc
fresh Packages
run 'find src -name "*.java"'
run 'javac -d out src/edu/yeditepe/hello/*.java'
run 'find out -type f'
run 'java -cp out edu.yeditepe.hello.Main'
run 'java -cp out Main'
run 'java edu.yeditepe.hello.Main'
