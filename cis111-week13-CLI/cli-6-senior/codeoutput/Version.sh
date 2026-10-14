javac Hello.java
od -A d -t x1 -N 8 Hello.class
javap -v Hello.class | grep major
printf '\x00\x46' | dd of=Hello.class bs=1 seek=6 conv=notrunc 2>/dev/null
od -A d -t x1 -N 8 Hello.class
java Hello
