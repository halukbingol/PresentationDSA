#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q demo
#@ cd demo
#@ mkdir -p bin build/logs src docs
#@ touch bin/App.class src/App.java build/logs/run.log debug.log keep.log docs/notes.md .DS_Store
cat .gitignore
git status --short --untracked-files=all
git check-ignore -v keep.log debug.log src/App.java
