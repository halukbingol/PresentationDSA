javac -d mods --module-source-path src -m com.greet,com.app
javac -d mods --module-source-path src -m com.greet,com.app --add-exports com.greet/com.greet.internal=com.app
java -p mods -m com.app/com.app.Main
java -p mods --add-exports com.greet/com.greet.internal=com.app -m com.app/com.app.Main
