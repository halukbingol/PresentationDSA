Java on the Command Line -- six LaTeX Beamer presentations
Haluk O. Bingol, FCIS, Yeditepe University

hblib/                      shared libraries (\usepackage{../../hblib/...})
  hblibPresentation.sty     theme, i/N, \hSection, algorithm2e, ...
  hblibCodeoutput.sty       \lstcode, \lstoutput, ... (v1.7: long paths in titles are scaled to fit)
  hblibDatastructures.sty   \hString, \hStack, \hQueue
decks/
  1-concepts/   cli-concepts.tex    JDK/JRE/JVM, PATH, classpath, jar, streams, exit codes
  2-examples/   cli-examples.tex    javac, java, jar, jshell, javap by example
  3-freshman/   cli-freshman.tex    install, first program, reading error messages
  4-sophomore/  cli-sophomore.tex   projects, packages, classpath, jars, javadoc, build scripts
  5-junior/     cli-junior.tex      --release, modules, jdeps, jlink, JVM options
  6-senior/     cli-senior.tex      jpackage, CDS, jcmd/JFR, signing, reproducible jars, containers

Every terminal session on the slides is real (OpenJDK 21, Linux shell, like macOS Terminal):
  codeoutput/<Demo>.sh        the commands of one session
  codeoutput/proj/<Demo>/     the project files the session starts from
  codeoutput/<Demo>.txt       the recorded session (what the slides show)
  codeoutput/session.inc      helper: runs each demo in build/run/<Demo> and echoes "$ command"
Re-record all sessions:  sh run_examples.sh        (macOS Terminal, Linux, or Git Bash on Windows)
Re-record one session:   sh run_examples.sh Jar.sh
Then:                    pdflatex cli-examples.tex  (twice)
Windows equivalents of the commands are given on the slides.
