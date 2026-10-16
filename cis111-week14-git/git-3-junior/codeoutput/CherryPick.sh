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

git switch -q -c release HEAD~1
git switch -q main
sed -i 's/apples 3/apples 30/' stock.txt
#@ tick
git commit -q -am "Fix: apples are 30, not 3"
git switch -q release
#@ tick
git cherry-pick main
git log --oneline --graph --all
