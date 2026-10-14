cat src/com.app/module-info.java
javac -d mods --module-source-path src -m com.greet,com.app 2>&1 | head -4
