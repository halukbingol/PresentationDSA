# Sign
. codeoutput/session.inc
fresh Sign
run 'javac -d out src/app/Main.java'
run 'jar --create --file app.jar --main-class app.Main -C out .'
run 'keytool -genkeypair -keystore ks.p12 -storepass changeit -alias cse -keyalg RSA -dname "CN=CSE Course, O=Yeditepe University" -validity 365'
run 'jarsigner -keystore ks.p12 -storepass changeit app.jar cse'
run 'jar tf app.jar | grep META-INF/'
run 'jarsigner -verify app.jar | grep verified'
#  tamper with the signed jar
run 'mkdir -p hack/app; cp out/app/Main.class hack/app/; printf x >> hack/app/Main.class'
run 'jar --update --file app.jar -C hack app/Main.class'
run 'jarsigner -verify app.jar'
