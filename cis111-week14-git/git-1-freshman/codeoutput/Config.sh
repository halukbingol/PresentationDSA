#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat
git config --global user.name "Ayşe Yılmaz"
git config --global user.email "ayse@example.com"
git config --global init.defaultBranch main
git config --global --list
