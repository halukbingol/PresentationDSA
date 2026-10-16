#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
ecj -17 -g:none -d plain Point.java
ecj -17 -g -d debug Point.java
javap -l -cp plain Point | sed -n '/main/,$p'
javap -l -cp debug Point | sed -n '/main/,$p'
