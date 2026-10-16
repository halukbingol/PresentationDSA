javac -d out src/Banner.java
jar --create --file banner.jar --main-class Banner -C out . -C res .
jar --list --file banner.jar
java -jar banner.jar
mkdir elsewhere
cd elsewhere
java -jar ../banner.jar
