echo "3.5 4.5" | java Average.java
echo "3.5 4.5" | LANG=tr_TR.UTF-8 java Average.java 2>&1 | head -3
echo "3,5 4,5" | LANG=tr_TR.UTF-8 java Average.java
