# Build
. codeoutput/session.inc
fresh Build
run 'sh build.sh; echo "exit code: $?"'
run 'cp broken/Account.java src/edu/yeditepe/bank/'
run 'sh build.sh; echo "exit code: $?"'
