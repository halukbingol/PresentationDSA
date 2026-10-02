# git as `diff`s

[toc]

Git has a twist here. Git doesn't *store* diffs: every commit is a full snapshot of the project. But almost every Git command can be understood as *computing, moving, or re-applying diffs* between snapshots. With that one idea, most of Git fits together.

## 1. A diff is the change between two states

If $S_1$ and $S_2$ are two versions of the files, the diff is $\Delta = S_2 - S_1$. Applying it to $S_1$ gives $S_2$:

```diff
@@ -3,1 +3,1 @@
-    tokens = line.split(",")
+    tokens = line.strip().split(",")
```

Each block like this is a **hunk**: which lines to remove (`-`) and which to add (`+`), plus some context.

## 2. Three snapshots, three diffs

At any moment there are three versions of your project: the last commit (**HEAD**), the **staging area** (index) and the **working files**. `git diff` shows the change between any two of them:

| Command | Diff between |
|---|---|
| `git diff` | staging area → working files (not yet staged) |
| `git diff --staged` | HEAD → staging area (what will be committed) |
| `git diff HEAD` | HEAD → working files (everything) |

So the daily commands are diff-movers:
- `git add` moves a diff from "unstaged" to "staged"
- `git add -p` moves only *some hunks* of it
- `git commit` turns the staged diff into a new snapshot
- `git restore <file>` throws the unstaged diff away

## 3. History is a chain of diffs

Each commit has a parent, so each commit *implies* a diff: $\Delta_i = C_i - C_{i-1}$. That's what `git show` and `git log -p` display. Read this way, history is

$$C_n = C_0 + \Delta_1 + \Delta_2 + \dots + \Delta_n$$

and a **branch** is just another chain of diffs starting from some shared commit.

## 4. Every big operation is diff arithmetic

**Merge.** Find the common ancestor $B$ (the merge base). Compute both sides' changes and apply both:

$$\text{result} = B + (\text{ours} - B) + (\text{theirs} - B)$$

A **conflict** is when both diffs touch the same lines, so Git can't add them automatically.

**Rebase.** Take the diffs of your commits ($\Delta_D, \Delta_E$) and replay them on top of the new base. The diffs are the same, but the starting point differs, so the snapshots differ. That's why rebased commits get new hashes ($D', E'$).

**Cherry-pick.** Apply one commit's diff somewhere else: $\text{new} = \text{HEAD} + \Delta_F$.

**Revert.** Apply the *inverse* diff: $\text{new} = \text{HEAD} - \Delta_F$. The history stays intact; you just add the "undo" diff on top.

**Stash.** Save your uncommitted diffs, remove them from the files, and re-apply them later with `pop`.

**Patch by email.** `git format-patch` writes commits as diff files, and `git am` applies them. The Linux kernel is still developed this way.

**Searching.** `git log -S "text"` finds commits whose diff adds or removes that text. `git blame` says which commit's diff last touched each line. `git bisect` searches the chain of diffs for the one that broke things.

## 5. The honest part: snapshots, not diffs

Internally, a commit points to a **tree** that describes the whole project. Diffs are computed on demand, every time you ask. Git stores snapshots because:
- **Checkout is fast:** any version is read directly, with no chain of 500 diffs to replay.
- **Hashes are simple:** the same content always gives the same hash, which makes integrity checks and deduplication easy.
- **Merging is flexible:** Git can compare any two snapshots, not just neighbors.

Storage stays small because unchanged files are shared between snapshots. In pack files, Git also compresses similar objects as deltas, but that's a storage trick unrelated to the parent–child relationship.

Older systems like RCS and early SVN actually stored diffs. Darcs and Pijul go further and treat patches as the fundamental object.

## One-line summary

> Git **stores snapshots** but **thinks in diffs**. `add`, `commit`, `merge`, `rebase`, `cherry-pick`, `revert` and `stash` all compute a diff between two snapshots and apply it somewhere.

This would fit well as a short section in the sophomore deck, right after "Commits form a graph", or as a bridge slide into the senior internals section. I can add it to either one.