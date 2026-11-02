#@ rm -f D*.java *.class
java Gen.java 255 > D255.java
javac D255.java && echo "255 dimensions: compiled"
java Gen.java 256 > D256.java
javac D256.java 2>&1 | cut -c 1-70 | head -n 2
#@ rm -f D*.java *.class
