#@ javac -d mods --module-source-path src -m com.greet,com.app
#@ mkdir mlib
#@ jar --create --file mlib/greet.jar -C mods/com.greet .
#@ jar --create --file mlib/app.jar --main-class com.app.Main -C mods/com.app .

jpackage --type app-image --name Hello --module-path mlib --module com.app --dest out
find out -maxdepth 3 | sort
out/Hello/bin/Hello
du -sh out/Hello
