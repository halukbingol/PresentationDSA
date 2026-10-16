javac Typo.java
#@ sed -i 's/s.pop()$/s.pop();/' Typo.java
javac Typo.java
java trace
