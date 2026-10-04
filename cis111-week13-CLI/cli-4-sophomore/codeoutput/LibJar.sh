# LibJar
. codeoutput/session.inc
fresh LibJar
run 'javac -d lib-out lib-src/textutil/Text.java'
run 'mkdir lib'
run 'jar --create --file lib/textutil.jar -C lib-out .'
run 'javac -cp lib/textutil.jar -d out src/app/Main.java'
run 'java -cp out:lib/textutil.jar app.Main'
run 'java -cp "out:lib/*" app.Main'
run 'CLASSPATH=out:lib/textutil.jar java app.Main'
