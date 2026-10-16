find src -type f | sort
javac -d out src/edu/yeditepe/shop/Main.java
mkdir -p out/edu/yeditepe/shop/i18n
cp src/edu/yeditepe/shop/i18n/*.properties out/edu/yeditepe/shop/i18n/
find out -type f | sort
java -cp out edu.yeditepe.shop.Main en-US
java -cp out edu.yeditepe.shop.Main tr-TR
