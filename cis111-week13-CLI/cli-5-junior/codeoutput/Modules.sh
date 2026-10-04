# Modules
. codeoutput/session.inc
fresh Modules
run 'javac -d mods --module-source-path src -m edu.yeditepe.app'
run 'find mods -name "*.class"'
run 'java --module-path mods --module edu.yeditepe.app/edu.yeditepe.app.Main'
