#@ javac -d out src/edu/yeditepe/shop/Main.java
#@ mkdir -p out/edu/yeditepe/shop/i18n
#@ cp src/edu/yeditepe/shop/i18n/*.properties out/edu/yeditepe/shop/i18n/

java Pseudo.java out/edu/yeditepe/shop/i18n
grep -v "^#" out/edu/yeditepe/shop/i18n/Messages_en_XA.properties
java -cp out edu.yeditepe.shop.Main en-XA
