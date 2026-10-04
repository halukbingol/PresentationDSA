Strings in Java -- six LaTeX Beamer presentations
Haluk O. Bingol, FCIS, Yeditepe University

hblib/                      shared libraries (\usepackage{../../hblib/...})
  hblibPresentation.sty     theme, i/N, \hSection, algorithm2e, ...
  hblibCodeoutput.sty       \lstcode, \lstcodedownstep, \lstcodeoverlaystep, ... (v1.6)
  hblibDatastructures.sty   \hString (new), \hStack, \hQueue
decks/
  1-concepts/   strings-concepts.tex    the concepts (no programs)
  2-examples/   strings-examples.tex    learning by example
  3-freshman/   strings-freshman.tex    first steps with text
  4-sophomore/  strings-sophomore.tex   objects, efficiency, data structures
  5-junior/     strings-junior.tex      string algorithms, regex, Unicode
  6-senior/     strings-senior.tex      internals, performance, security

Each deck folder has codeoutput/ (programs and their real outputs, Java 21)
and run_examples.sh, which reruns every program and rewrites the outputs.

Build a deck (Windows: Command Prompt or Git Bash; macOS: Terminal):
  cd decks/3-freshman
  sh run_examples.sh          (optional: rerun the programs; Windows: in Git Bash)
  pdflatex strings-freshman.tex
  pdflatex strings-freshman.tex   (twice, for i/N and the outline)
