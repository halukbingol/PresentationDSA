#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q shop
#@ cd shop
#@ echo "apples 3" > stock.txt && git add . && git commit -q -m "A: apples"
#@ tick
#@ echo "pears 5" >> stock.txt && git commit -q -am "B: pears"
#@ tick
#@ echo "figs 2" >> stock.txt && git commit -q -am "C: figs"
#@ tick

cat .git/HEAD
cat .git/refs/heads/main
git branch idea
ls .git/refs/heads
git rev-parse idea HEAD~1 "HEAD^{tree}"
git switch -q idea
cat .git/HEAD
git switch -q --detach HEAD~2
cat .git/HEAD
git status | head -1
