cd "$(mktemp -d)"
git init -q -b main
git config user.name "Student"
git config user.email "student@example.edu"

echo "apples" > list.txt
git add list.txt
git commit -q -m "Add shopping list"

git switch -q -c feature
echo "bananas" >> list.txt
git commit -q -am "Add bananas"

git switch -q main
echo "# Shopping" > README.md
git add README.md && git commit -q -m "Add README"

git merge -q --no-edit feature
git log --oneline --graph --all
