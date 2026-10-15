# Trees notes

Same plan, with Java throughout. Continuing: a quick test of the new tree styles.

Stack decks still compile with the updated library. Packaging now.

I've made the six tree decks on your `hblib` libraries and template. All six compile with no errors and pass my rules check against `0hb-Rules-of-LaTeX-Beamer-v2.md`.

| Deck | Pages | Covers |
|---|---|---|
| Concepts | 35 | tree vocabulary (depth, height, levels), binary tree shapes and node-count facts, N-ary trees, three ways to store a tree (linked nodes, an array, first child / next sibling), the four traversals with numbered pictures and pseudocode, a walk-around trick for finding the orders by hand, which traversal for which task |
| Examples | 29 | real programs: a node class, the four traversals, size/height/leaves, expression trees, a tree in an array, N-ary trees, a real folder tree (names in preorder, sizes in postorder), a binary search tree (BST) |
| Freshman | 34 | building a tree by hand, thinking recursively, tracing traversals, common mistakes with their real error messages |
| Sophomore | 33 | a generic node class, traversals that take a lambda, traversals with an explicit stack or queue, an inorder iterator, BST insert/search/delete, a classic bug in checking that a tree is a BST, rebuilding a tree from two traversals, saving a tree as text, generic N-ary trees |
| Junior | 31 | why height matters (sorted input), AVL trees with rotations and why their height stays logarithmic, timings against `TreeMap`, deep trees and a traversal that needs no extra memory (Morris), tries for words, heaps (`PriorityQueue`) |
| Senior | 28 | expression trees with Java 21's sealed records and pattern matching (symbolic derivative), immutable trees that share unchanged nodes between versions, parallel traversal (fork/join), `TreeMap` as a `NavigableMap`, the trees inside `HashMap`, XML as a tree and the risk of untrusted XML, B-trees in databases |

All program output on the slides is real, from running the programs with JDK 21 on Linux; `run_examples.sh` recreates it. Windows and macOS are covered on every deck, mainly as typed commands side by side.

**Things worth knowing before teaching from these:**
- **I changed one of your libraries.** All six decks draw trees, so per the v2 rules I added TikZ tree styles to `hblibDatastructures.sty` and bumped its version line. Nothing existing in it changed, and the six stack decks still compile with the new copy. Only the copy in this package has the change.
- **Parallel was not faster.** On this 2-processor machine the fork/join sum was slower than the sequential one in every run (about 60 ms vs 50 ms). The senior deck says so and explains why: adding numbers is too little work per node.
- **Random trees came out shorter than the textbook figure.** For 1,000 to 100,000 keys, random BST heights were 1.8 to 2.4 times log₂ n; the slide gives both the measured values and the theoretical figure, which only applies for very large n. The AVL heights stayed under 1.44 log₂ n, as the theory says.
- **One freshman mistake needed a different tree.** The "`||` instead of `&&`" leaf-counting bug gave the right count by coincidence on the slides' small tree. That example uses a slightly bigger tree, so the bug shows.
- **The runner now compiles with `javac -g`.** Without it, Java's null-pointer messages say `"<parameter1>" is null` instead of `"t" is null`.
- **Turkish words sort by character code** in the trie example, not alphabetically. The slide says this and names `Collator` as the fix.
- **Facts I didn't look up:** two dates are from memory, AVL trees (1962) and the Visitor pattern (1994).

Files are in `java-tree.zip`, with a README:
- six `.tex` files, each with its PDF
- a `codeoutput/` folder for each deck
- `run_examples.sh`
- the updated `hblib` libraries