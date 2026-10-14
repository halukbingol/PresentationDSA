javac Sum.java
echo "3 4 5" | java Sum
cat numbers.txt
java Sum < numbers.txt
java Sum < numbers.txt > result.txt
cat result.txt
java Sum < bad.txt
java Sum < bad.txt 2> errors.txt
cat errors.txt
