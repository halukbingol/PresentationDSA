javac -d libout lib/edu/yeditepe/greet/Greeter.java
jar --create --file greet.jar -C libout .
javac -d out -cp greet.jar App.java
java -cp out:greet.jar App
java -cp out App 2>&1 | head -3
