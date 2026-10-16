#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q big
#@ cd big
#@ git config pack.threads 1
#@ for i in $(seq 1 40); do seq 1 $((i*200)) > numbers.txt; git add numbers.txt; git commit -q -m "Version $i"; tick; done
git count-objects -vH
git gc -q
git count-objects -vH
git verify-pack -v .git/objects/pack/*.idx | grep -E "^(non delta|chain length)"
