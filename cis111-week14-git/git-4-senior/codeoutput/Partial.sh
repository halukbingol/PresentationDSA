#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q mono
#@ cd mono
#@ for dir in backend frontend docs; do mkdir $dir; for i in 1 2 3; do (echo "$dir $i"; seq 1 3000) > $dir/part$i.txt; done; done
#@ echo "# Monorepo" > README.md
#@ git add . && git commit -q -m "Three teams, one repository"
#@ git config uploadpack.allowFilter true
#@ cd ..
git clone -q --filter=blob:none --sparse file://$PWD/mono work
cd work
ls
git rev-list --objects --all --missing=print | grep -c "^?"
git sparse-checkout set backend
ls
ls backend
git rev-list --objects --all --missing=print | grep -c "^?"
