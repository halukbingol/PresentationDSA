#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
git init -q demo
cd demo
echo "Merhaba" > hello.txt
git add hello.txt
find .git/objects -type f
echo "Merhaba" | git hash-object --stdin
git cat-file -t 41979c4
git cat-file -p 41979c4
git commit -q -m "Add hello"
git cat-file -p HEAD
git cat-file -p "HEAD^{tree}"
cp hello.txt copy.txt
git add copy.txt
git cat-file -p :copy.txt
find .git/objects -type f | wc -l
