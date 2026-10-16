#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat PAGER=cat GIT_EDITOR=true
#@ git config --global user.name "Ayşe Yılmaz"
#@ git config --global user.email "ayse@example.com"
#@ git config --global init.defaultBranch main
#@ git config --global advice.detachedHead false
#@ git config --global log.decorate short
#@ t=0; tick() { t=$((t+60)); export GIT_AUTHOR_DATE="@$((1790000000+t)) +0300" GIT_COMMITTER_DATE="@$((1790000000+t)) +0300"; }
#@ tick
#@ git config --file ~/.gitconfig-work user.email "ayse.yilmaz@company.com"
git config --global includeIf.gitdir:~/work/.path "~/.gitconfig-work"
git init -q ~/hobby
git init -q ~/work/shop
git -C ~/hobby config user.email
git -C ~/work/shop config user.email
cd ~/work/shop
git config user.email "release-bot@company.com"
git config --show-scope --get-all user.email
git config user.email
