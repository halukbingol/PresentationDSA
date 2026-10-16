#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q calc
#@ cd calc
#@ for i in 1 2 3 4 5 6 7 8; do if [ $i -lt 6 ]; then r=4; else r=5; fi; printf 'class Calc { static int twoPlusTwo() { return %s; } } // v%s\n' $r $i > Calc.java; git add .; git commit -q -m "Version $i"; tick; done
#@ printf 'grep -q "return 4" Calc.java\n' > test.sh
git log --oneline
cat test.sh
git bisect start HEAD HEAD~7
git bisect run sh test.sh
git bisect reset
