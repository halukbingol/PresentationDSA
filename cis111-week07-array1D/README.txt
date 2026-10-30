topic-array1D -- One-dimensional arrays (cis111, week 7: Arrays 1D, bjlo2 Ch. 6)
================================================================================

Seven LaTeX Beamer decks by Sait Erkovan, made with the hblib libraries and the rules in
hblib/0hb-Rules-of-LaTeX-Beamer-v2.md.

  array1D-0-concepts/   array1D-concepts.tex    ideas, pictures, pseudo code; no Java
  array1D-1-freshman/   array1D-freshman.tex    syntax, first programs, common errors and their messages
  array1D-2-sophomore/  array1D-sophomore.tex   java.util.Arrays, copy/compare, methods with a contract,
                                                JUnit 5 tests, reading input, String[] args, good habits
  array1D-3-junior/     array1D-junior.tex      growing an array, binary search, selection sort,
                                                counting array, prefix sums, two pointers, varargs,
                                                memory locality, int[] vs Integer[], records
  array1D-4-senior/     array1D-senior.tex      arrays in the JVM, bytecodes, run-time checks, covariance,
                                                limits and overflow, security (CERT OBJ05/06/13-J),
                                                threads, open-ended projects
  array1D-5-examples/   array1D-examples.tex    every idea of the concepts deck as a small program
  array1D-6-presentation/ array1D-presentation.tex
                                                the week-7 lecture: one deck for the class, written for
                                                first-year, first-term students who meet arrays here for
                                                the first time; it links weeks 1-6 to the topic and the
                                                topic to weeks 8-13

The lecture deck (array1D-6-presentation)
  45 frames: Why arrays?, Creating and using an array, Common array algorithms, Partially filled
  arrays, Arrays and methods, Summary. Sorting, binary search, JUnit, String[] args and the
  midterm practice are not part of the lecture.
  Optional parts are switched on and off near the top of array1D-presentation.tex:

      \newif\ifActivities  \Activitiestrue   quick checks, trace table, draw-it exercise (4 frames)
      \newif\ifEclipseLab  \EclipseLabtrue   the debugger, as in the labs (1 frame)
      \newif\ifExtraAlgos  \ExtraAlgostrue   counting array, reverse and palindrome (2 frames)

  Change ...true to ...false to leave a part out (all three off: 38 frames); every optional
  part is between "% EXTRA <name> V" and "% EXTRA <name> A" lines, so it can also be deleted
  as a block. The folder is self-contained: codeoutput/ holds only the programs of this deck,
  so the output boxes show short paths (codeoutput/Name.java). Some names (FirstArray,
  PrintArray, ...) also exist in decks 1-3 with other content.

Scope
  - Only one-dimensional arrays. Two- and more-dimensional arrays are in topic-arrayND.
  - ArrayList is not part of this topic.
  - The decks avoid repeating each other: the concepts deck has the pictures, the examples
    deck has the programs for the same ideas, and each level deck adds new material.

Running the programs
  Each deck folder has run_examples.sh. It runs every program in codeoutput/ and rewrites its
  output file, so every output on the slides is real:

      bash run_examples.sh              all programs of the deck
      bash run_examples.sh Name.java    one program

  Needs bash (macOS: Terminal; Windows: Git Bash) and JDK 17 or newer (javac and java on the PATH).
  The outputs in this folder were made with OpenJDK 21 on Linux.
  Timing and memory numbers (junior: SortGrowth, Locality, Boxing; senior: LostUpdates) and
  hash codes such as [I@2a139a55 differ from run to run; that is expected.

  array1D-2-sophomore/codeoutput/TempStats.sh runs JUnit 5 tests. It looks for the JUnit jars
  (junit-jupiter-api_*.jar, junit-platform-launcher_*.jar, ...) in ~/.p2/pool/plugins, where an
  Eclipse installation keeps them. If they are elsewhere, set JUNIT_LIB to that folder:

      JUNIT_LIB=/path/to/the/jars bash run_examples.sh TempStats.sh

  The bugs in TempStats.java and the wrong test keepsInputWrongAssert are on purpose: the slides
  show the failures and ask the students to fix them.

Compiling the slides
  pdflatex, bibtex, pdflatex, pdflatex (the decks cite hblib/hblibDataStructures.bib).
  hblib/bash/git-le.sh adds the levels 0-5; for the lecture deck add the
  pair '6' 'presentation' to its list (or add the folder by hand).

Library changes (hblib) needed by these decks; both are backward compatible
  hblibDatastructures.sty  v20261029T1600
      new \hArray[keys]{e0,e1,...}: array cells with indices; keys id, at, width, height, name,
      index=above|below|none, hot, cur, done, unused, font; cells are nodes (<id>-<i>) for arrows.
      new TikZ styles hvar (a variable box) and href (a reference arrow).
      loads the TikZ libraries arrows.meta and decorations.pathreplacing.
  hblibPresentation.sty    v20261029T1800
      \resetcounteronoverlays{algocf}: an algorithm keeps its number on every overlay of a frame.
  The template hblib/Template/hblibTemplate.tex still compiles with both.
