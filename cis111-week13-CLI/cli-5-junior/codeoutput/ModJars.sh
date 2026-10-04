# ModJars
. codeoutput/session.inc
fresh ModJars
run 'javac -d mods --module-source-path src -m edu.yeditepe.app'
run 'mkdir mlib'
run 'jar --create --file mlib/greet.jar -C mods/edu.yeditepe.greet .'
run 'jar --create --file mlib/app.jar --main-class edu.yeditepe.app.Main -C mods/edu.yeditepe.app .'
run 'java -p mlib -m edu.yeditepe.app'
run 'jar --describe-module --file mlib/greet.jar | tail -n +2'
run 'java --list-modules | wc -l'
run 'java --list-modules | grep -E "java.(base|logging|sql)@"'
