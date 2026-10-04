# Container
. codeoutput/session.inc
fresh Container
run 'java -XshowSettings:vm -version 2>&1 | grep Heap'
run 'java -XX:MaxRAMPercentage=75 -XshowSettings:vm -version 2>&1 | grep Heap'
run 'java -XX:+PrintFlagsFinal -version 2>/dev/null | grep -E " (UseContainerSupport|ActiveProcessorCount|InitialRAMPercentage|MaxRAMPercentage) "'
