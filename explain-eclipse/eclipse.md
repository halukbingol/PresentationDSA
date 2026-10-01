# eclipse

[toc]

Eclipse is a graphical tool, and I can't run it here to take screenshots. So I'll draw the Eclipse window, the Debug perspective and the project structure as labeled TikZ diagrams. These are schematics, not screenshots. All Java code and console output will be real: each program is compiled and run, as in the Java deck.

I'll also extend the runner for two Eclipse habits: classes inside packages, and program arguments, which go in a `<Name>.args` file.Maven Central isn't reachable from here, so the JUnit test will be shown as code only. The slide will explain what the JUnit view shows, without a made-up result. Now the deck generator:The Hello slide still wraps one long line, so I'll split it into two statements in the program. Let me also zoom in on the Debug perspective diagram.Two small drawing errors in the diagram: the toolbar buttons overlap the view tabs, and the highlighted "current line" sits on line 8 instead of line 7. I'll fix both.Line 7 is now highlighted, with the breakpoint dot next to it. Last, the rules check and packaging.The Eclipse tutorial is ready: 26 frames, which makes 37 PDF pages because of the step slides. It uses your template's preamble, both libraries, `\hSection` + `\subsection` and your formatting rules. It compiles with no errors, missing files or overflowing slides, and I checked every slide by eye.

**Contents:**
1. **What is Eclipse?**: why use an IDE, installing, and the workspace.
2. **The workbench**: a labeled diagram of the Eclipse window (Package Explorer, editor, Outline, Console, perspective switcher), plus views, perspectives and "Reset Perspective".
3. **Your first project**: creating a project, package and class, running it, and what Eclipse puts on disk (`src/`, `bin/`, `.project`).
4. **Writing code faster**: `Ctrl+Space` templates (`main`, `sysout`), quick fix with `Ctrl+1`, Source menu shortcuts, and refactoring (before and after, with identical output).
5. **Running programs**: program arguments through Run Configurations, and keyboard input in the Console.
6. **Debugging**: a buggy average program (prints 54.0 instead of 82.33), breakpoints and stepping keys, a diagram of the Debug perspective paused on line 7, a variable trace that reveals both bugs, and the fixed version.
7. **More tools**: JUnit 5 tests, Git in Eclipse (linking to your Git lectures), and importing projects and exporting runnable JARs.
8. **Summary**: a troubleshooting table, a shortcut cheat sheet and 7 exercises.

**Screenshots vs. real output:**
- **Diagrams:** I couldn't run Eclipse here, so its windows are drawn as TikZ schematics rather than screenshots. They follow Eclipse's real layout and labels. You may want to swap in your own screenshots for the window and Debug slides.
- **Code and output:** all Java code and console output are real. The 8 programs were compiled and run with Java 21. The quick-fix slide shows the actual `javac` error, and the slide text gives Eclipse's own wording for it.
- **JUnit:** the test is shown as code only. JUnit couldn't be downloaded here, so there is no run result on the slide; it describes the green and red bar instead.

The runner now also understands `package` lines and `<Name>.args` files for program arguments, which Eclipse projects need. The zip contains the complete project, including your two `.sty` files unchanged.
