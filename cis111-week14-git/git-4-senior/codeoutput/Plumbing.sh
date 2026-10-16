#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
git init -q raw
cd raw
blob=$(echo "Merhaba" | git hash-object -w --stdin)
echo $blob
git update-index --add --cacheinfo 100644,$blob,hello.txt
tree=$(git write-tree)
echo $tree
commit=$(echo "First commit, by hand" | git commit-tree $tree)
echo $commit
git update-ref refs/heads/main $commit
git log --stat
git status --short
git restore hello.txt
cat hello.txt
