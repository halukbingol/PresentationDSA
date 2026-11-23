#@ rm -rf out
javac -d out TryCatch.java
javap -c out/TryCatch.class | sed -n '/parse/,/^$/{s| *//.*||;p}'
#@ rm -rf out
