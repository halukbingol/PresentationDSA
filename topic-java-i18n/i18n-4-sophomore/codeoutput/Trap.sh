#@ javac -d out src/edu/yeditepe/shop/Main.java
#@ mkdir -p out/edu/yeditepe/shop/i18n
#@ cp src/edu/yeditepe/shop/i18n/*.properties out/edu/yeditepe/shop/i18n/

java -cp out edu.yeditepe.shop.Main fr-FR
java -Duser.language=tr -Duser.country=TR -cp out edu.yeditepe.shop.Main fr-FR
