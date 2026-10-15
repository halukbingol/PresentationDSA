# stack-notes

[toc]

I'll build the six stack decks (concepts, examples, freshman, sophomore, junior, senior) on your new `hblib` libraries and template, following the v2 rules. First I'm unpacking the libraries to see what changed.

Now the runner for this set: library classes (no `main`) are compiled but not run, and `.jvmargs` files pass JVM options like `-ea` or `-Xss`.

I've made the six stack decks on your `hblib` libraries and template. All six compile with no errors and pass my rules check against `0hb-Rules-of-LaTeX-Beamer-v2.md`.

| Deck | Pages | Covers |
|---|---|---|
| Concepts | 34 | the LIFO idea, the stack operations, an array with a `top` index (drawn with your `\hStack`), push/pop/peek as algorithm2e pseudocode, overflow and underflow, growing by doubling and why it stays cheap, running time, applications (brackets, postfix, the call stack), Java's stack classes |
| Examples | 40 | real programs: a stack of `int` in a fixed array, a generic stack that grows, reversing a word, checking brackets, evaluating postfix, decimal to binary, undo/redo, the call stack, `ArrayDeque`, `java.util.Stack` |
| Freshman | 35 | installing the JDK, building the stack class step by step, tracing on paper, a stack you can type commands to, five common mistakes with their real error messages, compiler errors |
| Sophomore | 35 | an interface plus a generic implementation, iterating from the top, why `new T[n]` is not allowed, counting copies, amortized cost, popped objects that are never freed (loitering), tests (plus JUnit), converting infix to postfix, `Deque` methods |
| Junior | 30 | linked vs array stacks, the cost of boxing `int` into `Integer`, a benchmark, bytes per element, the potential-method proof, why to shrink at one quarter, recursion vs `-Xss`, depth-first search in a maze, changing a stack while iterating over it |
| Senior | 34 | the JVM's operand stack (`javap`), thread stacks, `StackWalker`, virtual threads, a data race, a lock-free stack (Treiber) and the ABA problem, deep-nesting denial-of-service attacks, what went wrong with `java.util.Stack` |

All program output on the slides is real, from running the programs with JDK 21 on Linux. The runner (`run_examples.sh`) recreates the outputs.

Windows and macOS are covered on every deck, mainly as typed commands side by side. JUnit, JMH and Maven/Gradle are typed listings marked "Not run here".

**Things worth knowing before teaching from these:**
- **The benchmark surprised me.** In every run, the linked stack of `Integer` was as fast as or faster than the array stacks of `Integer`. Only the `int[]` stack was clearly faster than both, and `java.util.Stack` was the slowest. The junior deck says this as it happened and makes "measure, don't guess" the lesson. I also softened the concepts deck's general claim that arrays are faster.
- **Some numbers change from run to run:** benchmark times, the data-race count, stack depths for `-Xss`, and the virtual-thread time. The slides only make claims that held in every run.
- **`ArrayDeque` didn't flag a change made while iterating** in my test, while `java.util.Stack` threw an exception. The junior deck shows both and treats "fail fast" as best effort.
- **One fact I didn't look up:** that Jackson limits JSON nesting to 1000 levels by default since version 2.15. It appears on the deep-nesting result slide in the senior deck.

**Changes to your library and template:**
- I didn't change any of your libraries.
- From the template I left out its theme block and its `L` column definition, because the libraries already provide both, as the v2 rules ask.
- I didn't change your shared `run_examples.sh`; this set comes with its own copy. It only compiles classes without a `main` (so programs can use them), and it accepts a `.jvmargs` file with JVM options for a program.

Files are in `java-stack.zip`, with a README:
- six `.tex` files, each with its PDF
- a `codeoutput/` folder for each deck
- `run_examples.sh`
- the `hblib` libraries