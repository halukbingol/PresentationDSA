# JarTool
. codeoutput/session.inc
fresh JarTool
run 'javac -d out --source-path src src/edu/yeditepe/bank/Main.java'
run 'jar cfe bank.jar edu.yeditepe.bank.Main -C out .'
run 'jar --update --file bank.jar -C extra README.txt'
run 'jar tf bank.jar'
run 'jar xf bank.jar README.txt'
run 'cat README.txt'
run 'java -jar bank.jar'
