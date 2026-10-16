# git-Junior+Senior level

Once students know the freshman basics, it helps to split the next material into two layers. Juniors need what makes them effective on a team, and seniors need what makes them the person who fixes the repository when something goes wrong.

## Junior level: collaboration and clean history

**1. Remote workflows and pull requests.** Cover forks vs. clones, `upstream` vs. `origin`, keeping a fork in sync, opening and reviewing PRs, and responding to review comments.

**2. Branching strategies.** Compare feature branching, trunk-based development and GitFlow, and discuss when each fits. Short-lived branches are the lesson that matters most.

**3. Rebase vs. merge.** Explain linear vs. merge-commit history, `git pull --rebase`, and the golden rule: never rebase commits others have already pulled.

**4. Interactive rebase.** Use `git rebase -i` to squash, reorder, reword and split commits, and teach `--fixup` with `--autosquash`. This is how students turn messy work into a clean PR.

**5. Stashing and partial staging.** Cover `git stash` (push, pop, list, apply) and `git add -p` for committing only some of the changes in a file.

**6. Understanding undo.** Teach `reset --soft`, `--mixed` and `--hard` side by side, plus `revert`, `restore`, and when each one is safe to use.

**7. The reflog.** `git reflog` recovers "lost" commits after a bad reset or rebase, and it builds confidence more than any other command.

**8. Inspecting history.** Cover `git log --graph --oneline --all`, `git blame`, `git show`, `git diff` between branches, and `git log -S` (the "pickaxe") for finding when a line appeared.

**9. Tags and releases.** Explain annotated vs. lightweight tags, semantic versioning, and GitHub Releases.

**10. Commit conventions.** Teach good messages, Conventional Commits, and atomic commits.

## Senior level: internals, automation and scale

**1. Git internals.** Cover the object model (blobs, trees, commits, tags), content-addressed SHA hashes, the `.git` directory, refs and `HEAD`, and plumbing commands like `cat-file`, `hash-object` and `ls-tree`. This is where Git stops being magic.

**2. Advanced merging.** Explain three-way merge and the merge base, merge strategies (`ort`, `ours`), `git rerere`, and tools for resolving hard conflicts.

**3. Debugging with bisect.** Use `git bisect` to find the commit that introduced a bug, including automated bisect with `git bisect run` and a test script. This is a great live demo.

**4. Cherry-pick and backporting.** Cover applying fixes across release branches and handling the conflicts that come with it.

**5. Hooks and automation.** Teach client-side hooks (pre-commit, commit-msg), the `pre-commit` framework, and server-side hooks.

**6. CI/CD integration.** Show GitHub Actions or GitLab CI triggered by pushes and PRs, branch protection rules, required reviews, and status checks.

**7. Rewriting history at scale.** Use `git filter-repo` to remove a leaked secret or a large file from all of history, and discuss why deleting the file in a new commit isn't enough.

**8. Large repositories.** Cover Git LFS for binaries, shallow and partial clones, sparse checkout, and the monorepo vs. polyrepo trade-off.

**9. Multi-repo and parallel work.** Cover `git worktree` for several branches checked out at once, and submodules and subtrees with their pitfalls.

**10. Security and trust.** Teach signed commits and tags (GPG or SSH), verifying authorship, secret scanning, and `.gitignore` vs. `.git/info/exclude`.

**11. Open-source contribution workflow.** Have students contribute to a real project, working through CONTRIBUTING guides, DCO sign-off, and responding to maintainers.

## Teaching tips

- **Lab-driven:** give students repositories with a planted bug for `bisect`, a secret committed three weeks ago for `filter-repo`, and a history that needs cleaning with `rebase -i`.
- **Team project:** have juniors run a semester project with protected `main`, required PR reviews and CI. They learn more from that than from any lecture.
- **Internals first for seniors:** once students see that a branch is just a 41-byte file holding a hash, rebase, reset and reflog all make sense.

I can turn either level into a Beamer deck that follows your formatting rules. The two could also be one "Git II" and one "Git III" lecture.