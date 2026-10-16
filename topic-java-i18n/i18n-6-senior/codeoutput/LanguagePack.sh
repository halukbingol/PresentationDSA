find src -type f | sort
javac -d out --module-source-path src -m app,app.tr
#@ mkdir -p out/app/com/app/i18n
#@ cp src/app/com/app/i18n/*.properties out/app/com/app/i18n/
#@ cp src/app.tr/com/app/tr/*.properties out/app.tr/com/app/tr/
java -p out/app -m app/com.app.Main tr
java -p out/app:out/app.tr -m app/com.app.Main tr
