#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ export JDT=/usr/share/java/eclipse-jdt-core.jar
unzip -l $JDT | tail -1
unzip -p $JDT META-INF/MANIFEST.MF | tr -d '\015' | grep -E "^Bundle-(SymbolicName|Version|Activator)"
unzip -p $JDT META-INF/MANIFEST.MF | tr -d '\015' | grep -A4 "^Require-Bundle"
unzip -p $JDT plugin.xml | grep -A1 "<extension-point" | grep -o 'id="[^"]*"'
