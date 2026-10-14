javac -d out src/edu/yeditepe/shop/*.java
jar --create --file shop.jar --main-class edu.yeditepe.shop.Main -C out .
jdeps -summary shop.jar
jdeps --list-deps shop.jar
jdeps --print-module-deps shop.jar
javac -d rout Report.java
jar --create --file report.jar -C rout .
jdeps --print-module-deps report.jar
