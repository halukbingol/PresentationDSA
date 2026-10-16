#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git init -q odev1
#@ cd odev1
#@ printf '%s\n' 'public class Hello {' '    public static void main(String[] args) {' '        System.out.println("Merhaba Git");' '    }' '}' > Hello.java
#@ git add Hello.java && git commit -q -m "Add Hello program"
#@ tick
sed -i 's/Merhaba Git/Merhaba Yeditepe/' Hello.java
git status --short
git diff
git commit -am "Greet Yeditepe"
git log --oneline
