# Diagnose
. codeoutput/session.inc
fresh Diagnose
run 'javac Busy.java'
run 'java -XX:StartFlightRecording=filename=rec.jfr Busy > busy.log &'
run 'sleep 1.5; jps -l | grep Busy | sed "s/^[0-9]*/<pid>/"'
run 'jcmd Busy VM.version | tail -2'
run 'jcmd Busy Thread.print | grep -A3 '\''"main"'\'' | tail -3'
run 'wait; cat busy.log | tail -1'
run 'jfr summary rec.jfr | grep -E "Duration|jdk.ExecutionSample "'
run 'jfr view hot-methods rec.jfr | sed -n 2,6p'
