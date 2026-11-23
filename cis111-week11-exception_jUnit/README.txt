topic-ExceptionHandling-UnitTesting -- Exception handling and unit testing (cis111, week 11)
=========================================================================================

Seven LaTeX Beamer decks by Sait Erkovan, made with the hblib libraries and the rules in
hblib/0hb-Rules-of-LaTeX-Beamer-v2.md. Both topics are taught in the same week: exceptions
first, then unit tests with JUnit 5. The old week-11 slides (cis111-w11-ExceptionHandling-
UnitTesting-20260413.pptx) were used only as a checklist at the end; everything they cover is
in the decks (throw, the exception classes, try/catch, checked exceptions and throws, finally,
try-with-resources, quick checks, good habits, the assert statement, reading a file, testing by
hand versus JUnit, annotations, the assert methods, Eclipse, how JUnit finds the tests).

  ExceptionHandling_UnitTesting-0-concepts/     ExceptionHandling_UnitTesting-concepts.tex
        kinds of errors, signalling a problem (special value or exception), the call stack and
        unwinding, exception objects and families, cleanup, design rules, why and what to test,
        unit tests, choosing cases, when to test; pictures, tables and pseudo code, no programs
  ExceptionHandling_UnitTesting-1-freshman/     ExceptionHandling_UnitTesting-freshman.tex
        reading a stack trace, a gallery of ten run-time exceptions, eight compile errors around
        exceptions and their messages, the Scanner input trap, a first exception of your own,
        a first JUnit test class and the common mistakes with tests (private, no import, ...)
  ExceptionHandling_UnitTesting-2-sophomore/    ExceptionHandling_UnitTesting-sophomore.tex
        own exception types (checked, with data), requireNonNull, chaining and "Caused by",
        multi-catch, two resources, logging; @BeforeEach, @DisplayName, assertThrows with the
        message, assertAll, parameterized tests, @Timeout, @Disabled, Console Launcher, Maven, Gradle
  ExceptionHandling_UnitTesting-3-junior/       ExceptionHandling_UnitTesting-junior.tex
        what exceptions cost (measured), return in finally, suppressed exceptions, lambdas and
        checked exceptions, StackOverflowError and OutOfMemoryError, layers, Optional, the
        checked-exception debate; test doubles written by hand, @TempDir, coverage, mutation
        testing by hand, property-based testing
  ExceptionHandling_UnitTesting-4-senior/       ExceptionHandling_UnitTesting-senior.tex
        try/catch/finally in bytecode (javap), helpful NullPointerException messages, lost stack
        traces (OmitStackTraceInFastThrow), exceptions in other threads and the exit status, the
        default handler, security (CWE list, OWASP Top 10 2025 A10, fail closed, failure
        atomicity), retry with backoff and resilience patterns, a test runner of our own with
        reflection, a new object per test, AssertionFailedError, order-dependent and flaky tests,
        the test pyramid, continuous integration
  ExceptionHandling_UnitTesting-5-examples/     ExceptionHandling_UnitTesting-examples.tex
        every idea of the concepts deck as a small program or session (ticket prices, largest
        value, shipping, a test-first clock, visible and hidden tests of a prime check, ...)
  ExceptionHandling_UnitTesting-6-presentation/ ExceptionHandling_UnitTesting-presentation.tex
        the week-11 lecture: one deck for the class, written for first-year, first-term students

The lecture deck (ExceptionHandling_UnitTesting-6-presentation)
  42 frames: When things go wrong, Exceptions (about 16 frames), Unit tests with JUnit (about 12),
  Advanced topics (optional), Summary. One example runs through the deck: grades and their
  average (Grades.java, GradesTest.java). Decisions taken with the instructor:
    - finally and try-with-resources are in the deck; the assert statement is an optional
      "advanced topics" section at the end
    - JUnit: assertEquals with a tolerance for doubles, assertArrayEquals, assertThrows;
      @BeforeEach only in the sophomore deck (the students have not met classes yet)
    - visible TS_ and hidden TH_ tests are shown, without naming any exam
    - "test first" is one sentence here; the concepts and examples decks show it in full
  Optional parts are switched on and off near the top of ExceptionHandling_UnitTesting-presentation.tex:

      \newif\ifActivities  \Activitiestrue   quick checks and a choose-the-tests exercise (4 frames)
      \newif\ifEclipseLab  \EclipseLabtrue   from a red bar to the bug, in Eclipse (1 frame)
      \newif\ifAdvanced    \Advancedtrue     the assert statement (a section, 2 frames)

  Change ...true to ...false to leave a part out (Activities off: 38 frames; all three off:
  35 frames); every optional part is between "% EXTRA <name> V" and "% EXTRA <name> A" lines,
  so it can also be deleted as a block. The folder is self-contained: codeoutput/ holds only
  the programs of this deck.

Scope
  - The decks avoid repeating each other: the concepts deck has the pictures, the examples deck
    has the programs for the same ideas, and each level deck adds new material.
  - No ArrayList; no midterm or exam is named.

Running the programs
  Each deck folder (except the concepts deck, whose codeoutput/ is empty) has run_examples.sh.
  It runs every program and session in codeoutput/ and rewrites its output file, so every
  output on the slides is real:

      bash run_examples.sh              all programs of the deck
      bash run_examples.sh Name.java    one program (or Name.sh, one session)

  Needs bash (macOS: Terminal; Windows: Git Bash) and JDK 17 or newer (javac and java on the PATH).
  The outputs in this folder were made with OpenJDK 21 on Linux.

  JUnit 5. The .sh sessions with tests look for the JUnit jars (junit-jupiter-api_*.jar,
  junit-jupiter-engine_*, junit-jupiter-params_*, junit-platform-*, org.opentest4j_*,
  org.apiguardian.api_*) in ~/.p2/pool/plugins, where an Eclipse installation keeps them.
  If they are elsewhere, set JUNIT_LIB to that folder:

      JUNIT_LIB=/path/to/the/jars bash run_examples.sh

  The outputs were made with JUnit 5.13.4 (the version in Eclipse). Each test folder has a copy
  of RunTests.java, a small launcher that prints one line per test (ok, FAIL, ERROR, SKIP) in
  the order of the method names. Without the jars these sessions print compile errors.
  The failures and errors in the test sessions are on purpose (e.g. presentation GradesBug,
  Pitfalls, Hidden; freshman Mistakes; sophomore All, Time; examples TicketBug, Largest,
  Shipping, Tdd, Prime; junior Mutants; senior Flaky): the slides show and explain them.

  Outputs that differ from run to run (expected):
    - times: junior ExceptionCost, TraceCost
    - counts: junior Errors (number of calls before StackOverflowError), senior FastThrow
      (the call after which the trace disappears)
    - hash codes: presentation Pitfalls ([C@5c909414, a char array compared with assertEquals),
      senior Handler (the incident number)
    - the date line of the JUnit warning in freshman Mistakes
    - file messages of the operating system: sophomore LogDemo shows "(No such file or
      directory)"; Windows says "(The system cannot find the file specified)"
  senior Exit shows exit statuses with "echo $?" (bash); in Command Prompt use echo %ERRORLEVEL%.

Compiling the slides
  pdflatex, bibtex, pdflatex, pdflatex (the decks cite hblib/hblibDataStructures.bib).
  hblib/bash/git-le.sh adds the levels 0-5; for the lecture deck add the pair
  '6' 'presentation' to its list (or add the folder by hand).
  The PDFs in this folder were compiled outside Windows with a stand-in for datetime2 and
  IEEEtran.bst; compile again on your machine for the final date line and reference style.

No library change: hblib is used as it is.
