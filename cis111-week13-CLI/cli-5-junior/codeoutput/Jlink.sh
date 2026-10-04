# Jlink
. codeoutput/session.inc
fresh Jlink
export JAVA_HOME="$(dirname "$(dirname "$(readlink -f "$(command -v java)")")")"
run 'javac -d mods --module-source-path src -m edu.yeditepe.app'
run 'jlink --module-path mods --add-modules edu.yeditepe.app --output rt --strip-debug --no-header-files --no-man-pages --compress=zip-9 --launcher hello=edu.yeditepe.app/edu.yeditepe.app.Main'
run 'rt/bin/java --list-modules'
run 'ls rt/bin'
run 'rt/bin/hello'
run 'du -sh rt'
run 'du -sh "$JAVA_HOME"'
