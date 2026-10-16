mkdir other
cd other
echo Ali | java ../Greeter.java 2>&1 | head -2
cd ..
#@ sed -i 's/hello=Merhaba/helo=Merhaba/' Texts_tr.properties
grep Merhaba Texts_tr.properties
echo Ali | java -Duser.language=tr Greeter.java
#@ sed -i 's/getString("hello")/getString("bye")/' Greeter.java
grep getString Greeter.java
echo Ali | java -Duser.language=tr Greeter.java 2>&1 | head -2
