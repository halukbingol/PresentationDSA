Patterns in .gitignore: Globs, not Regular Expressions -- a tutorial (LaTeX article)
====================================================================================
Haluk O. Bingol, FCIS, Yeditepe University

gitignore-tutorial.tex / .pdf   the tutorial (9 pages, about one hour of self-study)
codeoutput/                     the sessions and the program shown in it, with their real outputs:
                                  <Name>.sh + <Name>/   a terminal session in a copy of the folder (a fresh git repository)
                                  GlobToRegex.java       a simplified .gitignore-pattern -> regex translator
                                  <Name>.txt             what it printed
run_examples.sh                 reruns everything and rewrites codeoutput/*.txt

Contents: globs vs regular expressions (the .*\.log mistake), status --ignored / check-ignore -v / ls-files,
* ? [..] [!..], the four slash rules, **, negation and the "ignored folder" trap (with an algorithm),
special characters, the sources (.gitignore files, .git/info/exclude, core.excludesFile; Windows and macOS),
tracked files (git rm --cached), core.ignorecase on Windows and macOS, a glob-to-regex translator in Java,
a .gitignore for Java projects, a regex-habit table, exercises with answers checked by git.

Building (Windows: Command Prompt; macOS: Terminal)
  cd git-tutorial-gitignore
  pdflatex gitignore-tutorial.tex      (twice, for page i/N and the references)
  Needs ../../hblib/hblibPresentation.sty v20261027T1800 or newer (handout support).

Notes
  - Outputs: Git 2.43 and JDK 21 on Linux. The pattern rules are the same in the current Git
    documentation (2.54). On Windows and macOS only core.ignorecase differs (true by default); the tutorial
    shows both settings.
  - Each session runs with a temporary HOME and a fixed author and date; the global ignore file is shown
    with the home folder shortened to ~.
