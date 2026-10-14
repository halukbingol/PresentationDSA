javac Check.java
java Check 5
echo $?
java Check -5
echo "exit code: $?"
java Check
echo "exit code: $?"
java Check 7 && echo "ok" || echo "failed"
java Check -7 && echo "ok" || echo "failed"
