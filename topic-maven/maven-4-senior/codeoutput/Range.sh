#@ unset JAVA_TOOL_OPTIONS MAVEN_OPTS
#@ mvn() { if [ -f "$here/../offline-settings.xml" ]; then set -- -s "$here/../offline-settings.xml" "$@"; fi; command mvn -B -ntp "$@" 2>&1 | sed "s#$HOME#~#g"; return ${PIPESTATUS[0]}; }
#@ tree() { find "${1:-.}" -mindepth 1 -not -path '*/.*' -printf '%P\t%y\n' | sort | awk -F'\t' '{n=split($1,p,"/"); s=""; for(i=1;i<n;i++) s=s"    "; print s p[n] ($2=="d"?"/":"")}'; }
#@ rm -rf ~/.m2/repository/edu
#@ for p in textutil-1.0 textutil-2.0 lib-a-1.0 lib-b-1.0; do (cd libs/$p && mvn -q install); done
#@ rm -rf libs
mvn -q compile
mvn dependency:tree | grep edu.yeditepe
mvn -q dependency:build-classpath -Dmdep.outputFile=cp.txt
java -cp "target/classes:$(cat cp.txt)" app.Main
