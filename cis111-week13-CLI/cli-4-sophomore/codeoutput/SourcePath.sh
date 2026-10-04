# SourcePath
. codeoutput/session.inc
fresh SourcePath
run 'javac -d out --source-path src src/edu/yeditepe/bank/Main.java'
run 'find out -name "*.class"'
run 'java -cp out edu.yeditepe.bank.Main'
