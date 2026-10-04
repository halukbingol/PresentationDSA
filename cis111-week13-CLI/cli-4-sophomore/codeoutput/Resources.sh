# Resources
. codeoutput/session.inc
fresh Resources
run 'javac -d out src/app/Hello.java'
run 'cp -r res/. out/'
run 'jar --create --file hello.jar --main-class app.Hello -C out .'
run 'jar --list --file hello.jar'
run 'java -jar hello.jar'
