echo "3.5 4" | java Average.java
echo "3.5 4" | LANG=tr_TR.UTF-8 java Average.java 2>&1 | head -2
echo "3,5 4" | LANG=tr_TR.UTF-8 java Average.java
