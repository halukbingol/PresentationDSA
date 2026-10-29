#@ unset JAVA_TOOL_OPTIONS MAVEN_OPTS
#@ mvn() { if [ -f "$here/../offline-settings.xml" ]; then set -- -s "$here/../offline-settings.xml" "$@"; fi; command mvn -B -ntp "$@" 2>&1 | sed "s#$HOME#~#g"; return ${PIPESTATUS[0]}; }
#@ tree() { find "${1:-.}" -mindepth 1 -not -path '*/.*' -printf '%P\t%y\n' | sort | awk -F'\t' '{n=split($1,p,"/"); s=""; for(i=1;i<n;i++) s=s"    "; print s p[n] ($2=="d"?"/":"")}'; }
#@ MAVEN_HOME=/opt/maven
java -jar $MAVEN_HOME/lib/maven-artifact-3.9.11.jar 1.0-alpha 1.0-beta 1.0-rc1 1.0-SNAPSHOT 1.0 1.9 1.10
