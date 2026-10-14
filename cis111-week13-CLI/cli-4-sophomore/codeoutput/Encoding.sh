#@ printf 'public class Turkce {\n    public static void main(String[] args) {\n        System.out.println("\xe7i\xe7ek, \xfe\xfdk, da\xf0");\n    }\n}\n' > Turkce.java
file Turkce.java
javac Turkce.java 2>&1 | grep error
javac -encoding ISO-8859-9 Turkce.java
java Turkce
iconv -f ISO-8859-9 -t UTF-8 Turkce.java > tmp.java
mv tmp.java Turkce.java
file Turkce.java
javac Turkce.java
