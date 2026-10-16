javac -d out src/edu/yeditepe/shop/*.java
jar --create --file shop.jar -C out .
jar --list --file shop.jar
java -cp shop.jar edu.yeditepe.shop.Main
java -jar shop.jar
jar --create --file shop.jar --main-class edu.yeditepe.shop.Main -C out .
java -jar shop.jar
unzip -p shop.jar META-INF/MANIFEST.MF
