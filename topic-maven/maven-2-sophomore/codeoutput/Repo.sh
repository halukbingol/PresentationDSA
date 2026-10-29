#@ unset JAVA_TOOL_OPTIONS MAVEN_OPTS
#@ mvn() { if [ -f "$here/../offline-settings.xml" ]; then set -- -s "$here/../offline-settings.xml" "$@"; fi; command mvn -B -ntp "$@" 2>&1 | sed "s#$HOME#~#g"; return ${PIPESTATUS[0]}; }
#@ tree() { find "${1:-.}" -mindepth 1 -not -path '*/.*' -printf '%P\t%y\n' | sort | awk -F'\t' '{n=split($1,p,"/"); s=""; for(i=1;i<n;i++) s=s"    "; print s p[n] ($2=="d"?"/":"")}'; }
#@ mvn -q dependency:resolve
ls ~/.m2/repository/org/apache/commons/commons-lang3/3.14.0
