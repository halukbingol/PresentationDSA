# git-2-sophomore

[toc]

For sophomores, I'd make Git the tool they use every week on a small team project in a shared repository, without forks yet. That fills the gap between the two decks. The freshman deck is one person on one machine, and the junior deck starts at forks, open-source-style pull requests and rewriting history. Sophomore year is where they learn to share one repository with a few classmates without breaking each other's work.

## 1. A better mental model
- Commits are snapshots linked to their parents, forming a graph, not a list of diffs
- `HEAD`, branches as movable labels, and what "detached HEAD" means and how to get out of it
- Fast-forward vs. a real merge commit, and why `git log --oneline --graph` looks the way it does

This is a light version of the senior internals section, enough to stop students guessing.

## 2. Remotes, properly
- `fetch` vs. `pull`, and why `pull` is really fetch plus merge
- Remote-tracking branches (`origin/main`) and upstream tracking (`git push -u`)
- Reading "your branch is ahead by 2, behind by 3" in `git status`
- A rejected push (non-fast-forward), and why the fix is to pull first, not to force

## 3. Team workflow in a shared repo
- Adding collaborators; a branch per feature in the same repo
- Simple pull requests and a first taste of code review: leaving and answering comments
- Pulling and merging `main` into your branch regularly
- Protecting `main` with a "PR required" rule

## 4. Conflicts with confidence
- Realistic conflicts across several files, and `git merge --abort`
- Resolving conflicts in VS Code's merge editor, and checking the result builds before committing
- Habits that prevent conflicts: small branches and pulling often

## 5. GitHub as a project tool
- Issues, labels and a simple project board
- Linking work with "Closes #12" in commit messages and PRs
- Writing a good `README.md` in Markdown, and what a LICENSE file is for
- Submitting assignments through GitHub Classroom, if your department uses it

## 6. Setup that saves pain later
- SSH keys, and working from two machines (a lab PC and a laptop)
- Setting the default editor (`core.editor`) so they don't get stuck in Vim during `rebase -i` next year
- Line endings with `.gitattributes` / `core.autocrlf`, the classic Windows vs. Mac team problem
- `.gitignore` templates, and removing an already-tracked file with `git rm --cached`
- Simple aliases, `git help <command>`

## 7. Git in the editor
- VS Code's Source Control panel: staging, the diff view, branches, the merge editor
- The rule: use the GUI for speed, but know which command each button runs

## 8. Basic stash
- `git stash` and `git stash pop` for "I need to switch branches right now"

## Suggested course project
Teams of 3–4 build one application in a shared repo over the semester. The data structures or OOP course is a natural fit. Grading can include the history itself: every member has meaningful commits, work goes through PRs with at least one review, issues track the tasks, and `main` always builds.

## Adjusting the other two decks
To keep the four years from repeating each other, I'd move the basic PR lifecycle and simple stash from the junior deck down to sophomore. The junior deck would then open with forks and upstream, and focus on rebase, interactive rebase, the reset modes, the reflog, and history inspection. The freshman deck stays as it is.

I can build a `git-sophomore` Beamer deck from this outline with your formatting rules, and trim the overlap from the junior deck in the same pass.