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
git tag -a v1.0.0 -m "First release"
git push origin v1.0.0
echo "fix" >> README.md
#@ tick
git commit -q -am "Fix README"
#@ tick
git tag -a v1.0.1 -m "Bug fix release"
git push -q --tags
git ls-remote --tags origin
git describe
