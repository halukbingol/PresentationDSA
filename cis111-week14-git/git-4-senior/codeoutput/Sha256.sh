#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
git init -q --object-format=sha256 modern
cd modern
echo "Merhaba" > hello.txt
git add hello.txt
git commit -q -m "Add hello"
git rev-parse --show-object-format
git log --oneline
git rev-parse HEAD
git cat-file -p "HEAD^{tree}"
