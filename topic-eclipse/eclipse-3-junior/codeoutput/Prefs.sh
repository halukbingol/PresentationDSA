#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
cat .settings/org.eclipse.jdt.core.prefs
ecj -17 -properties .settings/org.eclipse.jdt.core.prefs -d bin src/Orders.java
