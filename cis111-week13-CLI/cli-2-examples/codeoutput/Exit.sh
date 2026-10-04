# Exit
. codeoutput/session.inc
fresh Exit
run 'javac Check.java'
run 'java Check 5; echo "exit code: $?"'
run 'java Check -3; echo "exit code: $?"'
run 'java Check -3 && echo OK || echo FAILED'
run 'java Check'
