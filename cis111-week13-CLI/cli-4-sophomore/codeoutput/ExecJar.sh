# ExecJar
. codeoutput/session.inc
fresh ExecJar
run 'javac -d lib-out lib-src/textutil/Text.java'
run 'mkdir -p dist/lib'
run 'jar --create --file dist/lib/textutil.jar -C lib-out .'
run 'javac -cp dist/lib/textutil.jar -d out src/app/Main.java'
run 'jar --create --file dist/app.jar --manifest manifest.txt --main-class app.Main -C out .'
run 'unzip -p dist/app.jar META-INF/MANIFEST.MF'
run 'cd dist'
run 'find . -type f'
run 'java -jar app.jar'
