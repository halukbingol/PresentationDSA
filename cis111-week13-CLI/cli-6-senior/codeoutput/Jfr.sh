#@ javac -d out Work.java
java -XX:StartFlightRecording=filename=rec.jfr -cp out Work
jfr summary rec.jfr | grep -E "Duration|jdk.(GarbageCollection|ExecutionSample|ObjectAllocationSample) "
jfr print --events jdk.ExecutionSample rec.jfr | grep -m 3 "line:"
