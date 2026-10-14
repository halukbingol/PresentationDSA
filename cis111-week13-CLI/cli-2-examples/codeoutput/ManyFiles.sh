find src -name "*.java" > sources.txt
cat sources.txt
javac -d out @sources.txt
rm -r out
javac -d out -sourcepath src src/edu/yeditepe/shop/Main.java
find out -type f | sort
