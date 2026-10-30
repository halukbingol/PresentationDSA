topic-arrayND -- Multi-dimensional arrays (cis111, week 8: Arrays 2D, bjlo2 Ch. 6)
================================================================================

Seven LaTeX Beamer decks by Sait Erkovan, made with the hblib libraries and the rules in
hblib/0hb-Rules-of-LaTeX-Beamer-v2.md. They continue topic-array1D and do not repeat it:
one-dimensional arrays (indices, references, aliasing, the 1D patterns, the 1D errors) are
assumed and only pointed to.

  arrayND-0-concepts/   arrayND-concepts.tex    tables, rows and columns, row-major order, arrays of
                                                rows, ragged tables, shallow and deep copies, visits,
                                                patterns, more dimensions; pictures and pseudo code
  arrayND-1-freshman/   arrayND-freshman.tex    syntax, first programs, the 2D compile and run-time
                                                errors and their messages, printf columns, the debugger
  arrayND-2-sophomore/  arrayND-sophomore.tex   deep methods of java.util.Arrays, shallow and deep copies,
                                                a small library with a contract, JUnit 5 tests on tables,
                                                reading tables, good habits
  arrayND-3-junior/     arrayND-junior.tex      ragged structures, matrix product, transpose, rotate,
                                                loop order measured, flat arrays, summed-area tables,
                                                Game of Life
  arrayND-4-senior/     arrayND-senior.tex      int[][] inside the JVM, the cost of rows, multianewarray,
                                                255 dimensions, size overflow, defensive deep copies,
                                                tables as keys, cycles, streams, parallel rows
  arrayND-5-examples/   arrayND-examples.tex    every idea of the concepts deck as a small program
  arrayND-6-presentation/ arrayND-presentation.tex
                                                the week-8 lecture: one deck for the class, written for
                                                first-year, first-term students who meet tables here for
                                                the first time; it links weeks 2-7 to the topic and the
                                                topic to weeks 9-12 and CIS112

The lecture deck (arrayND-6-presentation)
  41 frames: Why tables?, Creating and using a table, Common table algorithms, Tables and methods,
  More dimensions, Summary. It follows the decisions taken for array1D-6-presentation: Java code
  from the first section on, new syntax explained before it is used, exceptions only named
  (week 11), no JUnit frames, no midterm, the "Declaring and creating: two steps" opening.
  Optional parts are switched on and off near the top of arrayND-presentation.tex:

      \newif\ifActivities  \Activitiestrue   quick checks, trace table, draw-it exercise (4 frames)
      \newif\ifEclipseLab  \EclipseLabtrue   the debugger, as in the labs (1 frame)
      \newif\ifExtraAlgos  \ExtraAlgostrue   the diagonals of a square board (1 frame)

  Change ...true to ...false to leave a part out (all three off: 35 frames); every optional
  part is between "% EXTRA <name> V" and "% EXTRA <name> A" lines, so it can also be deleted
  as a block. The folder is self-contained: codeoutput/ holds only the programs of this deck.

Scope
  - Tables (2D), ragged tables, 3D and N dimensions. One-dimensional arrays are in topic-array1D.
  - ArrayList is not part of this topic.
  - The decks avoid repeating each other: the concepts deck has the pictures, the examples
    deck has the programs for the same ideas, and each level deck adds new material.

Running the programs
  Each deck folder (except the concepts deck) has run_examples.sh. It runs every program in
  codeoutput/ and rewrites its output file, so every output on the slides is real:

      bash run_examples.sh              all programs of the deck
      bash run_examples.sh Name.java    one program

  Needs bash (macOS: Terminal; Windows: Git Bash) and JDK 17 or newer (javac and java on the PATH).
  The outputs in this folder were made with OpenJDK 21 on Linux.
  Timing and memory numbers (junior: MatMulGrowth, LoopOrder; senior: RowCost) and hash codes
  such as [[I@2a139a55 differ from run to run; that is expected.

  arrayND-2-sophomore/codeoutput/GradeBook.sh runs JUnit 5 tests. It looks for the JUnit jars
  (junit-jupiter-api_*.jar, junit-platform-launcher_*.jar, ...) in ~/.p2/pool/plugins, where an
  Eclipse installation keeps them. If they are elsewhere, set JUNIT_LIB to that folder:

      JUNIT_LIB=/path/to/the/jars bash run_examples.sh GradeBook.sh

  Without the jars this session prints compile errors instead of test results. The bug in
  GradeBook.columnAverages and the wrong test withBonusWrongExpected are on purpose: the
  slides show the failures and ask the students to fix them.

Compiling the slides
  pdflatex, bibtex, pdflatex, pdflatex (the decks cite hblib/hblibDataStructures.bib).
  hblib/bash/git-le.sh adds the levels 0-5; for the lecture deck add the
  pair '6' 'presentation' to its list (or add the folder by hand).

Library change (hblib) needed by these decks; backward compatible
  hblibDatastructures.sty  v20261030T0050
      new \hGrid[keys]{{r0c0,r0c1,...},{r1c0,...},...}: a two-dimensional array, one brace group
      per row, row 0 on top; rows may differ in length (ragged). Keys id, at, width, height,
      name, index=both|rows|cols|none, hot, cur, done, unused (lists of r/c pairs), rowhot,
      colhot, font. Cell (r,c) is the node (<id>-r-c) for arrows and labels.
  The template hblib/Template/hblibTemplate.tex and all decks of topic-array1D still compile.
