#@ javac -d mods --module-source-path src -m com.greet,com.app
#@ mkdir mlib
#@ jar --create --file mlib/greet.jar -C mods/com.greet .
#@ jar --create --file mlib/app.jar --main-class com.app.Main -C mods/com.app .

java --list-modules | wc -l
jdeps --module-path mlib --print-module-deps mlib/app.jar
jlink --module-path mlib --add-modules com.app --launcher hello=com.app --strip-debug --no-header-files --no-man-pages --output image
ls image/bin
image/bin/java --list-modules
image/bin/hello
du -sh image
jlink --add-modules java.se --output full
du -sh full
