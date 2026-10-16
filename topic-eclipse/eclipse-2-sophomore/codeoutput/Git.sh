#@ ecj() { command ecj -proc:none "$@"; }
#@ slowly() { while IFS= read -r l; do echo "$l"; sleep 1.5; done < "$1"; }
#@ export JUNIT=/usr/share/java/junit-platform-console-standalone-1.9.1.jar
#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ export GIT_AUTHOR_DATE="@1790000000 +0300" GIT_COMMITTER_DATE="@1790000000 +0300"

#@ ecj -17 -d bin src
#@ mkdir -p .settings && echo "eclipse.preferences.version=1" > .settings/org.eclipse.jdt.core.prefs
git init -q
git status --short
printf 'bin/\n' > .gitignore
git add .
git status --short
git commit -q -m "Grades project"
git log --oneline
git ls-files
