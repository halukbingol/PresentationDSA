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
#@ printf 'Shop\n====\n' > README.md
#@ printf 'apples 3\npears 5\nfigs 2\n' > stock.txt
#@ git add . && git commit -q -m "Start the shop"
#@ tick

#@ sed -i 's/pears 5/pears 9/' stock.txt
#@ git commit -q -am "More pears"
#@ tick
#@ git config user.name "Ali Kaya"
#@ echo "kiwis 6" >> stock.txt
#@ git commit -q -am "Add kiwis"
#@ tick
git log --oneline -- stock.txt
git log -p -1 --format="%h %an %s"
git blame stock.txt
