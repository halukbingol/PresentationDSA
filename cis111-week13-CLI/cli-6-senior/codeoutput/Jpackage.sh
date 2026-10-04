# Jpackage
. codeoutput/session.inc
fresh Jpackage
run 'javac -d out src/app/Main.java'
run 'mkdir input'
run 'jar --create --file input/app.jar --main-class app.Main -C out .'
run 'jpackage --type app-image --name Hello --input input --main-jar app.jar --dest big'
run 'du -sh big/Hello'
run 'jlink --add-modules java.base --output rt --strip-debug --no-header-files --no-man-pages --compress=zip-9'
run 'jpackage --type app-image --name Hello --input input --main-jar app.jar --runtime-image rt --dest small'
run 'du -sh small/Hello'
run 'find small/Hello -maxdepth 2'
run 'small/Hello/bin/Hello'
