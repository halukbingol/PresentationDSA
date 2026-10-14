#@ javac -d out App.java
#@ jar --create --file app.jar -C out .
#@ sha256sum app.jar > app.jar.sha256
cat app.jar.sha256 | cut -c1-20,65-
sha256sum -c app.jar.sha256
#@ printf 'x' >> app.jar
sha256sum -c app.jar.sha256
