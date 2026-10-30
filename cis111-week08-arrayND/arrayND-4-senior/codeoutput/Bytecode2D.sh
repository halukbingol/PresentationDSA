#@ rm -f *.class
javac Make.java
javap -c Make | grep -E "static|newarray"
#@ rm -f *.class
