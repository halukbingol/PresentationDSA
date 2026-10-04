# Hooks
. codeoutput/session.inc
fresh Hooks
run 'javac Server.java'
run 'java Server > server.log & sleep 1; kill -TERM $!; wait $!; echo "exit code: $?"'
run 'cat server.log'
