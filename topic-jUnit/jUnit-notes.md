# jUnit

[toc]

Now rewrite the slides part of the examples deck with code and run on separate frames.

Now the README, final compile of all six, and packaging.

I've made the six JUnit decks, built from your new `hblib` (template v20261016T1814, and your new definition frame compiles). All six compile with no errors and pass the rule check, and I rendered and looked at every page.

| Deck | Pages | Covers |
|-------|-----|---|
| `junit-0-concepts` | 24 | why test, the test pyramid, arrange-act-assert, JUnit's history and parts, the order JUnit runs a test class (as an algorithm), the four outcomes, FIRST, test doubles, TDD, coverage |
| `junit-1-freshman` | 37 | getting JUnit on Windows and macOS (IDE, build tool or one JAR), the first test, reading the result, a failing test and its fix, the common assertions, 7 common mistakes with their real messages |
| `junit-2-sophomore` | 33 | `@BeforeEach`, `@DisplayName`, `@Nested`, argument sources, a TDD exercise on the Turkish ID number check digits, hand-written fakes, tags, Maven/Gradle with the JUnit 6.1.3 BOM, XML reports |
| `junit-3-junior` | 33 | Mockito (`mock`, `when`, `verify`, and its message when a check fails), tests for one OS only, timeouts, `@TempDir`, dynamic tests using the Turkish `i`, a custom extension, parallel runs, coverage that checks nothing |
| `junit-4-senior` | 24 | the JUnit Platform and its engines, running tests from your own program, JUnit 4 and JUnit 5/6 tests side by side, a migration table, what changed in JUnit 6, suites, property-based testing, test strategy (including KVKK and synthetic test data), projects |
| `junit-5-examples` | 34 | each concept as a real program: the call order of a test class, the four outcomes in one run, `assertAll`, leap years done test-first, how a shared field breaks a test, a fake clock, JaCoCo coverage |

- **Versions:** The current release is JUnit 6.1.3, and the slides say so. The examples ran with the JUnit Jupiter 5.10 / Platform 1.9 command-line runner, which was the version available here. Every feature the slides use works the same way in JUnit 6.
- **The other tools:** Mockito 2.23 (the current version is 5; the slides use only calls that are unchanged), JaCoCo 0.8.11, and JUnit 4.13.2 for the old-style example.
- **What you'll see in the terminal boxes:** `junit` is short for the `java -jar … execute` command with plain-text output; the freshman deck and the README explain this. The one line that only reports how long the run took is removed.
- **Things that change between runs:** the parallel-run timings and the object ids printed in the array example. Everything else gives the same output every time `run_examples.sh` is run.
- **Not run here:** Maven, Gradle, PIT and OpenRewrite need the internet, so they are typed listings marked "Not run here".
- **Real bugs the tests catch:** the examples include genuine errors the tests find. Integer division in an average gives 72.0 instead of 72.5. A leap-year rule forgets 1900. An insertion sort fails on 98 of 200 random arrays. English upper-casing turns "istanbul" into "ISTANBUL" instead of "İSTANBUL".

`junit.zip` unzips into your `home` folder as `junit/` (the six decks and a README) plus the three `.sty` files. The libraries themselves did not change.

Sources:
- [JUnit 6.0.3 release notes (6.0.0: September 30, 2025, Java 17, Vintage deprecated)](https://docs.junit.org/6.0.3/release-notes.html)
- [JUnit 6.1.1 release notes (6.1.0: May 19, 2026; 6.1.3 latest stable)](https://docs.junit.org/6.1.1/release-notes/)
- [JUnit 6.2.0 release notes (6.2.0 still a milestone)](https://docs.junit.org/6.2.0/release-notes.html)