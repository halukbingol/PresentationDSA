#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
git --version
git init -q notes
cd notes
echo "Ödev 1" > todo.txt
git add todo.txt
git commit -q -m "Add todo list"
#@ tick
echo "Ödev 2" >> todo.txt
git commit -q -a -m "Add second homework"
#@ tick
git switch -q -c idea
echo "Kitap oku" > idea.txt
git add idea.txt
git commit -q -m "Add an idea"
#@ tick
git switch -q main
git merge -q --no-ff -m "Merge idea" idea
git log --oneline --graph --all
