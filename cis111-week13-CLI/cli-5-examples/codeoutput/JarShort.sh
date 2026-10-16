javac -d out src/edu/yeditepe/shop/*.java
jar cfe shop.jar edu.yeditepe.shop.Main -C out .
jar tf shop.jar
jar tvf shop.jar
java -jar shop.jar
