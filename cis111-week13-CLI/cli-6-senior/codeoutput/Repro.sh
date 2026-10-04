# Repro
. codeoutput/session.inc
fresh Repro
run 'javac -d out src/app/Main.java'
run 'jar --create --file a.jar -C out .'
run 'sleep 2; jar --create --file b.jar -C out .'
run 'jar --create --date=2026-01-01T00:00:00Z --file c.jar -C out .'
run 'sleep 2; jar --create --date=2026-01-01T00:00:00Z --file d.jar -C out .'
run 'sha256sum a.jar b.jar c.jar d.jar | cut -c1-20,65-'
