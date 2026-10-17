# eclipse-notes

[toc]

I've made the six Eclipse IDE decks for version 2026-06, following `0hb-procedure.md` and the rules file. All six compile twice with no errors and pass the rule check. I rendered and looked at every page.

| Deck | Pages | Covers |
|---|---|---|
| `eclipse-0-concepts` | 27 | what an IDE is, workspace and projects, workbench and perspectives, how Eclipse compiles on every save, running, debugging, Content Assist, Quick Fix, refactoring, plug-ins |
| `eclipse-1-freshman` | 44 | download from eclipse.org on Windows and macOS, first project, running, templates, shortcuts, Console input, program arguments, 8 compile errors with their real messages, runtime errors |
| `eclipse-2-sophomore` | 33 | packages, `.project` and `.classpath`, build path, JUnit 5 (a red bar, the debugger finds the bug, a green bar), refactoring, Git in Eclipse, runnable JAR |
| `eclipse-3-junior` | 31 | compiler settings stored in `.settings/`, `@NonNull`/`@Nullable` null analysis, Maven and Gradle, code with errors still runs, Eclipse's compiler versus `javac`, remote debugging, navigation |
| `eclipse-4-senior` | 25 | plug-in architecture, Eclipse's compiler used from your own Java program, debug information in class files, team setups, security, Eclipse without a window, projects |
| `eclipse-5-examples` | 32 | each concept as a real session |

- **No screenshots:** Eclipse is a desktop program and couldn't run here, so menus and shortcuts are drawn with `\menu` and `\keys`, and the workbench is a diagram.
- **Real output:** every output on the slides comes from actually running:
  - `ecj`, the compiler built into Eclipse, so its messages are the ones the Problems view shows.
  - `jdb` for the debugger sessions; it uses the same debug connection as Eclipse.
  - The JUnit 5 command-line runner.
- **Version gap:** the `ecj` installed here is from Eclipse 4.26, older than 2026-06 (4.40). The messages and settings it shows still work the same way.
- **Not run here:** Maven, plug-in development and headless Eclipse are marked "Not run here" on the slides.
- **Debugger ids:** `jdb` prints object ids such as `id=449` that change from run to run. Everything else gives the same output every time `run_examples.sh` is run.
- **A shortcut to check:** I left out the macOS shortcut for Call Hierarchy because I wasn't sure of it; that row says "menu". Please check the macOS shortcuts against **Key Assist** (⌘⇧L) in your Eclipse.
- **Script fix:** `run_examples.sh` now forces UTF-8, because "Ayşe" given as a program argument came out garbled without it.

**Template:** I installed your modified `hblibTemplate.tex` with its version set to `% v20261016T1841`. It compiles to 38 pages. `hblib.zip` contains it along with your other `hblib` files. The libraries themselves did not change.

**Files:** `eclipse.zip` unzips into your `home` folder as `eclipse/` (the six deck folders and a README) plus the three `.sty` files in `hblib/`. The six PDFs and `hblib.zip` are attached too.

Sources:
- [ADTmag: Eclipse IDE 2026-06 (version 4.40)](https://adtmag.com/articles/2026/06/15/ide-2026-adds-java-26-support-and-developer-tooling-updates.aspx)
- [eclipse-dev list on the Java version Eclipse needs to run](https://www.eclipse.org/lists/eclipse-dev/msg12290.html)