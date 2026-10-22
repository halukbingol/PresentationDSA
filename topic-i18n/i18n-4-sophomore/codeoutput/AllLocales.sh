#@ javac -d out src/edu/yeditepe/shop/Main.java
#@ mkdir -p out/edu/yeditepe/shop/i18n
#@ cp src/edu/yeditepe/shop/i18n/*.properties out/edu/yeditepe/shop/i18n/

for tag in en-US en-GB tr-TR de-DE de-CH fr-FR pt-BR; do echo "== $tag"; java -cp out edu.yeditepe.shop.Main $tag | tail -2; done
