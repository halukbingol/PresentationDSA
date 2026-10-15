java Letters.java
java -Dstdout.encoding=US-ASCII Letters.java
java Letters.java | od -An -tx1 | head -1
java -Dstdout.encoding=ISO-8859-9 Letters.java | od -An -tx1 | head -1
