find . -name "*.java" | sort
javac --release 8 -Xlint:-options -d classes src/Info.java
javac --release 17 -d classes-17 src-17/Info.java
jar --create --file info.jar --main-class Info -C classes . --release 17 -C classes-17 .
jar tf info.jar
unzip -p info.jar META-INF/MANIFEST.MF | grep Multi
java -jar info.jar
