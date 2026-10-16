#@ export HOME=$(mktemp -d) GIT_CONFIG_NOSYSTEM=1 GIT_PAGER=cat; unset EMAIL GIT_AUTHOR_NAME GIT_COMMITTER_NAME GIT_AUTHOR_EMAIL GIT_COMMITTER_EMAIL
#@ git config --global init.defaultBranch main
git init -q odev1
cd odev1
echo "x" > a.txt
git add a.txt
git commit -m "First"
