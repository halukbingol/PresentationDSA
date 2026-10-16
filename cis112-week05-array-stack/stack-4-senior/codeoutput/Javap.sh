javac Calc.java
java Calc
javap -c Calc | sed -n '/static int f/,/ireturn/p'
javap -v Calc | grep "stack="
