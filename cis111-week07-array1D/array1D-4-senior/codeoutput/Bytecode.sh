#@ rm -rf out
javac -d out Sum.java
javap -c -cp out Sum | grep -E 'newarray|iastore|iaload|arraylength'
#@ rm -rf out
