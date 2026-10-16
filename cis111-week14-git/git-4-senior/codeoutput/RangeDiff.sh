#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q lib
#@ cd lib
#@ printf 'a\nb\nc\n' > f.txt && git add . && git commit -q -m "base" && tick
#@ git switch -q -c topic
#@ echo "x" > x.txt && git add x.txt && git commit -q -m "Add x" && tick
#@ seq 1 20 > y.txt && git add y.txt && git commit -q -m "Add y" && tick
#@ git switch -q main && sed -i 's/a/A/' f.txt && git commit -q -am "Capital A" && tick
#@ git switch -q topic
git branch topic-v1
git rebase -q main
sed -i "s/^5$/five/" y.txt
git commit -q -a --amend -m "Add y (reviewed)"
git range-diff main~1..topic-v1 main..topic
