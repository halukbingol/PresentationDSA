# Config
. codeoutput/session.inc
fresh Config
run 'javac Config.java'
run 'java Config'
run 'PORT=9000 java Config'
run 'PORT=9000 java -Dport=7000 Config'
run 'PORT=9000 java -Dport=7000 Config 6000'
