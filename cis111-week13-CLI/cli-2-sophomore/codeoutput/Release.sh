javac --release 8 -Xlint:-options Modern.java 2>&1 | grep -E "error|symbol:"
javac --release 11 Modern.java
java Modern
javap -v Modern.class | grep major
javac --release 8 Hello.java 2>&1 | head -1
javap -v Hello.class | grep major
