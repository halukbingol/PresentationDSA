#@ javac -d classes Today.java
jlink --add-modules java.base --strip-debug --no-man-pages --no-header-files --output rt-base
jlink --add-modules java.base,jdk.localedata --strip-debug --no-man-pages --no-header-files --output rt-all
jlink --add-modules java.base,jdk.localedata --include-locales=en,tr --strip-debug --no-man-pages --no-header-files --output rt-en-tr
du -sh rt-base rt-all rt-en-tr
rt-base/bin/java -cp classes Today
rt-all/bin/java -cp classes Today
rt-en-tr/bin/java -cp classes Today
