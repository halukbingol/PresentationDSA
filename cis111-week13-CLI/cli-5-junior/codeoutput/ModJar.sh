#@ javac -d mods --module-source-path src -m com.greet,com.app

mkdir mlib
jar --create --file mlib/greet.jar -C mods/com.greet .
jar --create --file mlib/app.jar --main-class com.app.Main -C mods/com.app .
jar --describe-module --file mlib/app.jar
java -p mlib -m com.app
java -cp "mlib/*" com.app.Main
jdeps --module-path mlib -summary mlib/app.jar
