#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git config --global pull.rebase false
#@ git init -q --bare server.git
#@ git clone -q server.git ayse 2>/dev/null
#@ cd ayse
#@ printf 'public class Shop {\n    static int price(int n) {\n        return 10 * n;\n    }\n}\n' > Shop.java
#@ printf '# Shop\n' > README.md
#@ git add . && git commit -q -m "Start the shop" && git push -q -u origin main
#@ cd ..
#@ git clone -q server.git ali
#@ git -C ali config user.name "Ali Kaya"
#@ git -C ali config user.email "ali@example.com"
#@ git -C ayse remote set-url origin ../server.git
#@ git -C ali remote set-url origin ../server.git
#@ tick

cd ayse
git switch -q -c report
echo "sales 120" > report.txt
git add report.txt
git commit -q -m "Add sales report"
#@ tick
echo "sales 135" > report.txt
git commit -q -am "Update sales"
git switch -q main
#@ tick
echo "Tel 0216" >> README.md
git commit -q -am "Add phone"
git log --oneline main..report
git log --oneline report..main
git diff --stat main...report
git merge-base main report
git log --oneline --all --graph
