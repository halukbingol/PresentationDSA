#@ javac -d out App.java
jar --create --file a.jar -C out .
sleep 2
jar --create --file b.jar -C out .
sha256sum a.jar b.jar | cut -c1-16,65-
jar --create --date 2026-01-01T00:00:00Z --file a.jar -C out .
sleep 2
jar --create --date 2026-01-01T00:00:00Z --file b.jar -C out .
sha256sum a.jar b.jar | cut -c1-16,65-
