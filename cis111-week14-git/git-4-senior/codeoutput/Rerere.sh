#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git config --global rerere.enabled true
#@ git init -q r
#@ cd r
#@ echo "price 10" > p.txt && git add . && git commit -q -m "base" && tick
#@ git switch -q -c topic && echo "price 12" > p.txt && git commit -q -am "topic: 12" && tick
#@ git switch -q main && echo "price 11" > p.txt && git commit -q -am "main: 11" && tick
git merge topic
echo "price 12" > p.txt
git add p.txt
git commit -q --no-edit
git reset -q --hard HEAD~1
git merge topic
cat p.txt
