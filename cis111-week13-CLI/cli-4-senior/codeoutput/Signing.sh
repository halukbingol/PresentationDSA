#@ javac -d out App.java
#@ jar --create --file app.jar --main-class App -C out .
keytool -genkeypair -alias haluk -keyalg RSA -keysize 3072 -validity 365 -dname "CN=Haluk Bingol, O=Yeditepe, C=TR" -keystore ks.p12 -storepass secret123
jarsigner -keystore ks.p12 -storepass secret123 app.jar haluk 2>&1 | head -1
jar tf app.jar
jarsigner -verify app.jar 2>&1 | grep -v '^$' | head -1
#@ sed -i 's/args = /ARGS = /' App.java
#@ javac -d out App.java
cd out
jar uf ../app.jar App.class
cd ..
jarsigner -verify app.jar 2>&1 | grep -v '^$' | head -1
java -jar app.jar 2>&1 | grep -m1 SecurityException
