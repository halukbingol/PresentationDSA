The Eclipse IDE -- six Beamer decks (Eclipse IDE 2026-06, from eclipse.org)
==========================================================================

eclipse-0-concepts    eclipse-concepts.tex    what an IDE is, Eclipse in a nutshell, workspace and projects,
                                              workbench, perspectives, build automatically (ecj), incremental
                                              build, launch configurations, debugging (JDWP), Content Assist,
                                              Quick Fix, refactoring, plug-ins
eclipse-1-freshman    eclipse-freshman.tex    download and install on Windows and macOS, the workspace, first
                                              project and class, run, templates, shortcuts, Console input,
                                              program arguments, compile errors with their real messages,
                                              runtime errors, messages from Eclipse itself
eclipse-2-sophomore   eclipse-sophomore.tex   packages, .project/.classpath, build path, JUnit 5 (red and green),
                                              breakpoints and debugging, refactoring, source generation,
                                              EGit, runnable JAR, good habits
eclipse-3-junior      eclipse-junior.tex      compiler settings in .settings/, annotation-based null analysis,
                                              Maven/Gradle (m2e, Buildship), code with errors still runs,
                                              ecj versus javac, remote debugging, navigation, troubleshooting
eclipse-4-senior      eclipse-senior.tex      OSGi bundles and extension points, JDT Core as a library
                                              (BatchCompiler), JDT LS and LSP, debug information in class
                                              files, team setups (.settings, .launch, Oomph), security,
                                              headless Eclipse, choosing an IDE, open-ended projects
eclipse-5-examples    eclipse-examples.tex    the concepts as real sessions: a workspace on disk, why the builder
                                              recompiles other files (NoSuchMethodError), the Problems view,
                                              run configurations (-ea), the call stack, Quick Fix, refactoring,
                                              Content Assist, JUnit

../hblib/   shared by all topics (home/hblib; each deck loads it as ../../hblib/...):
            hblibPresentation.sty v20261016T1150, hblibCodeoutput.sty v20261016T1749,
            hblibDatastructures.sty v20261015T2000 (no library change for these decks)

Building a deck (Windows: Command Prompt; macOS: Terminal)
-----------------------------------------------------------
  cd eclipse-1-freshman
  pdflatex eclipse-freshman.tex       (twice, for i/N and the outline)

Programs, sessions and their outputs
------------------------------------
Eclipse itself is a desktop program and could not run where these decks were made, so the
slides show menus with \menu and \keys, not screenshots. Every OUTPUT on the slides is real
(JDK 21, Linux), made by the same compiler Eclipse uses:
  ecj 3.32 (Eclipse Compiler for Java, JDT Core) -- the Problems-view messages
  jdb                                            -- debugger sessions (same JDWP as Eclipse)
  JUnit 5 console launcher                       -- the JUnit view's tree
  codeoutput/<Name>.java   a program; its output -> codeoutput/<Name>.txt
  codeoutput/<Name>.sh     a terminal session, run in a copy of codeoutput/<Name>/;
                           lines starting with "#@ " are silent set-up
  regenerate all:          bash run_examples.sh      (macOS: Terminal; Windows: Git Bash)
Notes:
  - The set-up runs ecj with -proc:none (the Linux ecj package lacks annotation processing);
    this changes no message.
  - jdb prints object ids (id=449) that differ from run to run; everything else is reproducible.
  - Not run here (marked on the slides): Maven, plug-in development, headless Eclipse.
