# Git for Freshmen: A Beginner's Tutorial

## 1. What is Git, and why should you care?

Git is a **version control system**. It records snapshots of your project over time, so you can:

- Go back to any earlier version when something breaks ("it worked yesterday!")
- Try new ideas without risking your working code
- Collaborate with teammates without emailing `final_v3_REAL_final.zip` back and forth

**Git vs. GitHub:** Git is the tool on your computer. GitHub (or GitLab or Bitbucket) is a website that hosts Git projects online so you can back them up and share them.

## 2. Install and set up (one time only)

**Install:**
- **Windows:** download from git-scm.com (this includes "Git Bash")
- **macOS:** run `git --version` in Terminal; it will offer to install if Git is missing
- **Linux:** `sudo apt install git` (Ubuntu/Debian)

**Tell Git who you are.** Your name and email get attached to every snapshot you save:

```bash
git config --global user.name "Your Name"
git config --global user.email "you@university.edu"
git config --global init.defaultBranch main
```

Check that it worked with `git config --list`.

## 3. Three key ideas

Git works with three areas:

| Area | What it is |
|---|---|
| **Working directory** | Your files as you edit them |
| **Staging area** | The changes you've picked to go into the next snapshot |
| **Repository** | The saved history of snapshots, called *commits* |

The basic cycle is **edit → `git add` → `git commit`**. You can think of it like packing a box: `add` puts items in the box, and `commit` seals it and labels it.

## 4. Your first repository

```bash
mkdir hello-git
cd hello-git
git init                    # turns this folder into a Git repo
```

Create a file:

```bash
echo "Hello, Git!" > readme.txt
git status                  # shows readme.txt as "untracked"
```

Stage it and commit it:

```bash
git add readme.txt          # or: git add .   (stages everything)
git commit -m "Add readme"
```

🎉 That's your first commit. Now look at your history:

```bash
git log                     # full history
git log --oneline           # compact version
```

## 5. The daily loop

```bash
# 1. Edit your files
git status                  # what changed?
git diff                    # show the exact line changes
git add <file>              # stage what you want
git commit -m "Describe what and why"
```

**Tips for good commit messages:**
- ✅ `Fix off-by-one error in grade calculator`
- ❌ `stuff`, `asdf`, `changes`
- Commit small, logical chunks often, not one giant commit at 3 a.m. before the deadline.

## 6. Branches: experiment safely

A branch is a separate line of work. `main` holds your stable code, and you try new things on other branches.

```bash
git branch                  # list branches (* marks the current one)
git switch -c new-feature   # create a branch and move to it
# ...edit, add, commit...
git switch main             # go back to main
git merge new-feature       # bring the feature's changes into main
git branch -d new-feature   # delete the branch once it's merged
```

> Older tutorials use `git checkout -b`. It does the same thing as `git switch -c`.

## 7. Merge conflicts (don't panic)

A conflict happens when two branches change the same lines. Git marks the spot in the file like this:

```
<<<<<<< HEAD
print("Hello from main")
=======
print("Hello from feature")
>>>>>>> new-feature
```

To fix it:
1. Edit the file so it contains what you actually want, and delete the `<<<`, `===`, and `>>>` lines.
2. Run `git add <file>`.
3. Run `git commit` to finish the merge.

## 8. Working with GitHub

**Put an existing project online:**
1. Create an empty repository on GitHub. Don't add a README.
2. Connect your local repo to it and push:

```bash
git remote add origin https://github.com/yourname/hello-git.git
git push -u origin main     # the first push; after this, just use "git push"
```

**Download someone else's project:**

```bash
git clone https://github.com/someone/project.git
```

**Stay in sync:**

```bash
git pull                    # get the latest changes from GitHub
git push                    # send your commits to GitHub
```

> **Team rule:** always `git pull` before you start working. This saves a lot of conflicts.

GitHub no longer accepts your account password for pushing. Use a **personal access token** or **SSH key**, or use the GitHub Desktop app or VS Code's built-in sign-in.

## 9. Ignore files you don't want tracked

Create a file named `.gitignore` in your project folder:

```
# Compiled / generated files
*.class
*.o
__pycache__/
node_modules/

# System and editor junk
.DS_Store
.vscode/

# Secrets — NEVER commit these
.env
```

## 10. Undoing mistakes

| Situation | Command |
|---|---|
| Discard unsaved edits to a file | `git restore <file>` |
| Unstage a file (keep your edits) | `git restore --staged <file>` |
| Fix the last commit message | `git commit --amend -m "New message"` |
| Undo a commit safely (makes a new "reverse" commit) | `git revert <commit-id>` |
| See an old version | `git log --oneline`, then `git switch --detach <commit-id>` (use `git switch main` to return) |

⚠️ Avoid `git reset --hard` and `git push --force` until you understand what they do. Both can permanently erase work.

## 11. Cheat sheet

```bash
git init                # start a repo
git clone <url>         # copy a remote repo
git status              # what's going on?
git add <file> / .      # stage changes
git commit -m "msg"     # save a snapshot
git log --oneline       # view history
git diff                # see unstaged changes
git switch -c <name>    # new branch
git switch <name>       # change branch
git merge <name>        # merge a branch into the current one
git pull / git push     # sync with GitHub
```

## 12. Practice exercise

1. Create a repo called `my-notes` and add a file `todo.txt` with three tasks. Commit it.
2. Create a branch called `update`, add two more tasks, and commit.
3. Switch back to `main`, change the first task, and commit.
4. Merge `update` into `main`, and resolve a conflict if one comes up.
5. Push the repo to GitHub and check that your commits show up there.

**Next steps:** try the interactive game at *learngitbranching.js.org*, read the free *Pro Git* book at git-scm.com/book, and use your editor's Git panel (VS Code has a good one) once the commands make sense.

Would you like me to turn this into a shareable document or a slide deck for a class session?