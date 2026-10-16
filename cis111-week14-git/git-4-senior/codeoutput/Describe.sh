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
#@ echo "1" > v.txt && git add . && git commit -q -m "feat: first release" && tick
git tag -a v1.0.0 -m "Release 1.0.0"
#@ tick
echo "2" > v.txt
git commit -q -am "fix: rounding error"
#@ tick
echo "3" > v.txt
git commit -q -am "feat: discounts"
git describe
git log --oneline v1.0.0..HEAD
git tag -a v1.1.0 -m "Release 1.1.0"
git describe
