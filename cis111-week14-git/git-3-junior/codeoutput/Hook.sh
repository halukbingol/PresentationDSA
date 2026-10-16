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
#@ cp ../pre-commit .git/hooks/pre-commit
#@ chmod +x .git/hooks/pre-commit
cat .git/hooks/pre-commit
echo "class App { } // TODO: write it" > App.java
git add App.java
git commit -m "Add App"
echo "class App { }" > App.java
git add App.java
git commit -q -m "Add App"
git log --oneline
