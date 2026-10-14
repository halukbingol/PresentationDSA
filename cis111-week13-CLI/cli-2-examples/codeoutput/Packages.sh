find src -type f | sort
javac -d out src/edu/yeditepe/shop/*.java
find out -type f | sort
java -cp out edu.yeditepe.shop.Main
java -cp out Main
java -cp out/edu/yeditepe/shop Main
