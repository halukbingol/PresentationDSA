# git-notes

[toc]

I've made the six Git decks and sent the PDFs plus `git-course.zip`, which holds the sources, the terminal sessions and their outputs, `hblib/` and a README. All six compile with no errors and no overfull boxes over 3pt, and `checkrules.py` reports OK for every deck.

| Deck | Pages | What it covers |
|---|---|---|
| `git-1-concepts` | 31 | Why version control, install on Windows and macOS, the three areas, objects, branches, merges, remotes |
| `git-2-examples` | 26 | Real sessions: init, diff, ignore, branch, merge, conflict, undo, stash, tags, remote, rebase |
| `git-3-freshman` | 25 | A first repository step by step, a Java project with `.gitignore`, five common errors with their real messages |
| `git-4-sophomore` | 25 | Two people sharing one server: feature branches, rejected pushes, `pull --rebase`, a Java conflict, squash, releases |
| `git-5-junior` | 25 | How Git stores data, `reset`, `reflog`, detached HEAD, `fixup` with `--autosquash`, `cherry-pick`, `bisect run`, searching history, hooks |
| `git-6-senior` | 30 | Building a commit by hand, SHA-256 repositories, packfiles, partial clone and sparse checkout, worktrees, `rerere`, `range-diff`, secrets left in history, signed commits, config scopes, branching models, CI, `git describe` |

- **Terminal output is real.** Every session was run with Git 2.43. Each run uses a fresh empty home folder, a fixed author and fixed dates, so `bash run_examples.sh` gives the same commit hashes every time. I re-ran all sessions to confirm this.
- **Three things are marked "Not run here":** `git filter-repo` and `ssh-keygen` weren't installed here, and the GitHub Actions file only runs on GitHub's servers.
- **Library change:** I added commit-graph drawing styles (`hcommit`, `hbranch`, `hheadref`, `htag`, `hparent`) to the copy of `hblibDatastructures.sty` in this set. The version line is now `v20261015T2000`, and the new styles don't affect your older decks.