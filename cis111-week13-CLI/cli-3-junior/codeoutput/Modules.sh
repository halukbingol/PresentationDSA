find src -name "*.java" | sort
javac -d mods --module-source-path src -m com.greet,com.app
find mods -type f | sort
java --module-path mods --module com.app/com.app.Main
java -p mods -m com.app/com.app.Main
java -p mods --describe-module com.greet
