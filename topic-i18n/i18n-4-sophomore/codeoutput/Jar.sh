#@ javac -d out src/edu/yeditepe/shop/Main.java
#@ mkdir -p out/edu/yeditepe/shop/i18n
#@ cp src/edu/yeditepe/shop/i18n/*.properties out/edu/yeditepe/shop/i18n/

jar --create --file shop.jar --main-class edu.yeditepe.shop.Main -C out .
jar tf shop.jar | grep properties
java -jar shop.jar
LANG=tr_TR.UTF-8 java -jar shop.jar
java -Duser.language=de -Duser.country=AT -jar shop.jar
