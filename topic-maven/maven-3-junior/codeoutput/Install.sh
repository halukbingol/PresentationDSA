#@ unset JAVA_TOOL_OPTIONS MAVEN_OPTS
#@ mvn() { if [ -f "$here/../offline-settings.xml" ]; then set -- -s "$here/../offline-settings.xml" "$@"; fi; command mvn -B -ntp "$@" 2>&1 | sed "s#$HOME#~#g"; return ${PIPESTATUS[0]}; }
#@ tree() { find "${1:-.}" -mindepth 1 -not -path '*/.*' -printf '%P\t%y\n' | sort | awk -F'\t' '{n=split($1,p,"/"); s=""; for(i=1;i<n;i++) s=s"    "; print s p[n] ($2=="d"?"/":"")}'; }
#@ rm -rf ~/.m2/repository/edu

mvn -q install
ls ~/.m2/repository/edu/yeditepe/grades-core/1.0-SNAPSHOT
cd grades-app
mvn -q package
ls target/*.jar
