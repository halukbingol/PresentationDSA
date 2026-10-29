# regex-notes

[toc]

Now writing the senior generator.

I've made the six decks on regular expressions in Java and built `regex.zip`. All six compile with no errors and no overfull boxes over 3pt, and all pass the rules check.

| Folder | Pages | Focus |
|---|---|---|
| `regex-0-concepts` | 29 | what a pattern is, building blocks, `Pattern` and `Matcher`, why every `\` is written twice in Java, automaton vs. backtracking, `grep`, limits |
| `regex-1-freshman` | 33 | `matches`, `split`, `replaceAll`, escaping, the real error messages |
| `regex-2-sophomore` | 32 | `find`, groups, flags, look-ahead, greedy vs. lazy, JUnit tests |
| `regex-3-junior` | 30 | Turkish letters and Unicode, back-references, look-around, possessive quantifiers, newer APIs, speed |
| `regex-4-senior` | 36 | regular languages, a DFA, two algorithms (backtracking and NFA simulation), slow patterns (ReDoS), stack overflow, time limits, RE2/J, regex injection, projects |
| `regex-5-examples` | 34 | each concept as a real program, including a 35-line backtracking matcher that prints its steps and a DFA as a table |

- **Outputs:** every output on the slides is from a real run, made by `run_examples.sh`. Rerunning gives the same outputs except the timings (junior: Speed; senior: Csv, Memo, Re2). Those numbers change from run to run, but how they grow stays the same, and the notes on those slides say so.
- **Library behaviour:** Java caches failed attempts in some loops, so the textbook slow pattern `(a+)+b` is only quadratic in today's JDK. The senior deck therefore uses patterns that are really slow:
  - A CSV pattern grows from 3 ms to about 160 ms between 12 and 24 fields; the fixed version takes 0 ms.
  - `(a+)+\1b` takes about 4× longer for every 2 extra characters, reaching about 1.5 s at 26.
- **RE2/J:** the RE2/J run is real. It uses version 1.7, from Debian's `libre2j-java` package; the session copies `re2j-1.7.jar` into the project folder. Maven and the Windows `findstr`/PowerShell commands are marked "Not run here".
- **Library files:** no library change was needed. The zip holds the three `.sty` files plus `regex/`, with the generated `.tex` files, programs, outputs and a `README.txt`.

Sources:
- [RE2/J: Linear-time regular-expression matching for Java (Google Open Source Blog)](https://opensource.googleblog.com/2015/02/re2j-linear-time-regular-expression.html)
- [com.google.re2j:re2j 1.7 on Maven Central](https://central.sonatype.com/artifact/com.google.re2j/re2j/1.7)
- [Debian package libre2j-java 1.7](https://packages-picconi.debian.org/en/sid/libre2j-java)
