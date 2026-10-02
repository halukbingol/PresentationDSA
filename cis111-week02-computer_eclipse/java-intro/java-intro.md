# Java

> Consider LaTeX template `hbCisLaTeXTemplate.tex`
> and libraries `hblibCodeoutput.sty` and `hblibPresentation.sty`.
> 
> Provide an introduction to java tutorial in LaTeX.

[toc]

I'll build the tutorial as a complete project in your template's format. It uses your preamble, both libraries, `\hSection` with `\subsection`, and your formatting rules. Every Java program will live in `codeoutput/` and be compiled and run for real, so each output on the slides is exactly what Java prints. First I'll check the Java version, since it decides which language features I can show.Java 21 is available, so modern features such as switch expressions work. Now the example programs, kept short enough to fit on slides:Now the runner script. It handles your `codeoutput/` layout, where each source file and its `.txt` output sit side by side. If a `<name>.in` file exists, it is fed to the program as keyboard input.All outputs are correct now, including Turkish letters. I'll also make `Methods.java` more compact so it fits one slide, then write the deck.Now the deck itself. I'll generate it with a small script, so every frame, section and listing follows your formatting rules exactly.Now I'll update the slides to match: overlays for the wide programs, the loop split, and new line ranges for the Student class.That patch script hit a quoting problem and didn't save anything. I'll make the same edits directly instead.Most slides fit now. A few still have wrapped lines (Greet, Loops, BreakContinue, Student), and two need small adjustments: the pipeline note and the ArrayList overlay width. I'll fix those.The Student slides are fixed, but because the page numbers shifted, I rendered other slides than I meant to. I'll check the full deck again.Everything fits now. The `continue` comment on the break/continue slide looks clipped at this small size, so I'll zoom in to check.It's fine; the comment just looked clipped at low resolution. Last, the rules check and packaging.The Java tutorial is ready: 27 frames, which makes 47 PDF pages because of the step slides. It uses your template's preamble, both libraries, `\hSection` + `\subsection` and your formatting rules. It compiles with no errors, missing files or overflowing slides, and I checked every slide by eye.

**Contents:**
1. **What is Java?**: Java at a glance, and a diagram of `.java` → `javac` → `.class` → JVM on any OS, with the `javac` / `java` commands.
2. **Your first program**: Hello World, explained line by line.
3. **Variables, types and operators**: a primitive-type table, variables, integer division, Strings (`==` vs `.equals`), and `Scanner` input.
4. **Decisions and loops**: `if`/`else`, `switch`, `for`/`while`, and `break`/`continue`.
5. **Methods**: parameters, return values, overloading and recursion.
6. **Arrays and lists**: arrays, `ArrayList`, and when to use which.
7. **Classes and objects**: a class-vs-object diagram and a `Student` class.
8. **When things go wrong**: a real compiler error and a real exception, and how to read each.
9. **Summary**: cheat sheet, 8 exercises, and next steps.

**How the examples work:**
- **Real code and output:** all 16 programs are in `codeoutput/`. Each was compiled and run with Java 21, and the slides read both the code and the output from those files.
- **Error slides:** these show genuine `javac` and JVM messages.
- **Predict-the-output slides:** these use the step and overlay macros, so the code appears first and the output on the next click.

**The runner, `run_examples.sh`,** is adapted to your `codeoutput/` layout. It also:
- **Feeds input:** if `<Name>.in` exists, the file is used as keyboard input. The `Scanner` slide shows the input file next to the output.
- **Handles Turkish letters:** it forces UTF-8, so "Ayşe" prints correctly instead of "Ay?e".

To change an example, edit the `.java` file and run `sh run_examples.sh`, or `sh run_examples.sh Loops.java` for just one program. Then recompile the slides. The zip contains the complete project, including your two `.sty` files unchanged.