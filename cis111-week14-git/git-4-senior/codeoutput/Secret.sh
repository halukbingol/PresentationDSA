#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q app
#@ cd app
#@ echo "class Db { }" > Db.java && git add . && git commit -q -m "Add Db" && tick
echo "db.password=hunter2" > db.properties
git add db.properties
git commit -q -m "Add database config"
#@ tick
git rm -q db.properties
git commit -q -m "Remove password"
ls
git log --oneline
git log --oneline -S hunter2
git show HEAD~1:db.properties
