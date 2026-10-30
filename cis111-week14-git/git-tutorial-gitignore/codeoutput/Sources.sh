#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global core.ignorecase false
#@ export GIT_AUTHOR_DATE="@1793000000 +0300" GIT_COMMITTER_DATE="@1793000000 +0300"
#@ tree() { find "${1:-.}" -mindepth 1 -not -path '*/.git' -not -path '*/.git/*' -printf '%P\t%y\n' | sort | awk -F'\t' '{n=split($1,p,"/"); s=""; for(i=1;i<n;i++) s=s"    "; print s p[n] ($2=="d"?"/":"")}'; }
#@ git init -q .
#@ mkdir -p ~/.config/git && echo '*.swp' > ~/.config/git/ignore
#@ echo 'mine.txt' >> .git/info/exclude
#@ rm -f .keep
cat .gitignore src/.gitignore
cat .git/info/exclude | grep -v "^#"
cat ~/.config/git/ignore
git check-ignore -v src/Main.class src/Gen.java notes.swp mine.txt | sed "s#$HOME#~#"
