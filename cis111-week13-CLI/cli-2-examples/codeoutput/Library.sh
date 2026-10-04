# Library
. codeoutput/session.inc
fresh Library
run 'javac -d lib/out lib/src/textutil/Text.java'
run 'javac -d app/out app/src/app/Main.java'
run 'javac -cp lib/out -d app/out app/src/app/Main.java'
run 'java -cp app/out:lib/out app.Main'
run 'java -cp app/out app.Main'
