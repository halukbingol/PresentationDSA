# notes

[toc]

This is a big build: six decks, each with real Java programs whose output gets compiled and run. First I'll check the uploaded libraries and the Java setup here.

Re-reading your latest rules file so all six decks follow it exactly:

Fixing the three libraries: the version lines, the Queue bug, the package name, and the new `\hString` macro:

Now the shared generator module that all six decks use. It handles the rule-compliant frame markers, the preamble, and writing and running the Java programs:

Now Deck 1 (concepts). It is mostly diagrams of how strings live in memory, with short snippets and no runnable programs.

Let me look at all pages:

Now rewriting each diagram in Deck 1 to use it:

The diagrams render properly now. Checking two of them at full size, plus the one remaining overfull warning:

Both look right. One small fix: the "after" label overlaps the faded box. Then on to Deck 2.

Now Deck 2 (by example). Each program is written to `codeoutput/`, compiled and run for real, and its actual output goes on the slide.

All outputs look right; I checked each against the code. Compiling Deck 2:

I'll widen the code boxes to 70% of the slide (outputs here are narrow), shorten the code lines over 70 characters, and switch notes containing `''` to double-quoted strings:

These look good. Applying the small-output fix:

Deck 2 is done. Now Deck 3, for freshmen: first programs, Scanner input, loops over characters, the classic traps, and reading error messages. It also covers setting up Java on Windows and macOS.

`\hStack` works with brackets when each one is wrapped in braces. Writing Deck 4:

Two slides are still too tall (Timing by 23pt, Anagram by 16pt). I'll remove blank lines and combine the warm-up calls:

Only small overflows of 1–5pt are left. Checking visually whether they reach the footer:

Those were the wrong pages, but this stack slide shows the row labels sitting slightly below their stacks. I'll align them, then look at the right pages:

Both notes touch the footer. I'll make the Timing note one line and remove one blank line from Anagram:

I'll check the facts on the encodings slide before running. One correction: NFD file names come from the older HFS+ file system; APFS keeps whichever form it is given. Rewording that, then running:

The Unicode output is right. Now a UTF-8 error inside a listing; checking which one:

Restored, and no other generator is affected. One more scan, for control characters a decoded escape could have left behind:

A few slides overflow. Checking the rest before fixing them all together:

Now rewriting the Deck 5 programs to fit this layout, and fixing the matching diagram so it shows the pattern at both shifts, 0 and 7:

The KMP line ranges shifted after the rewrite. Checking the exact lines:

Much better: no code wraps now. Moving the floating outputs down slightly so they don't cover the "Java" label, then tracking down the remaining overflows by line number:

The overflows are Naive (17pt), Edit distance (16pt) and Unicode (11pt). I'll remove blank lines and shorten their notes:

Those look right. Edit distance is still 10pt too tall, so I'll build its table header with one `String.join` line instead of three:

Deck 5 is done. Before the senior deck, I'll check whether saving the scripts also decoded other escapes (`\t`, `\n`) inside Java string literals, not just `\u`:

Before running, I'll compute the two hash codes quoted on the switch slide, rather than trusting the numbers I wrote:

Both values are correct. Running the senior programs:

The two patterns agree on 200,000 random strings. Updating ReDoS and compiling Deck 6:

The ReDoS output came from the old source, because I ran the program before regenerating the file. Rerunning it, then finding the four overflowing frames:

Still four overflows. Viewing them:

My patch script stopped early on its own assertion: the `cut` line appears twice, so nothing was saved except the Concat change. Rerunning it correctly:

Only Hash flooding remains, 17pt over. I'll merge two lines of `main`:

No overflows left in Deck 6. One claim to correct against the real ReDoS numbers: the times grow 5–10× per 4 characters, not "about 10×". Then all six decks get the full rules check:

The section markers are correct; my check looked at the wrong line. Fixing the check and the ReDoS note:

No errors anywhere. Junior has one slide 5pt over (the naive-search slide, counted once per click), so I'll check it visually:

The note touches the footer. Removing the blank line after the imports fixes it:

All clean. Packaging: removing build files, adding a short README, and zipping with your folder layout (`hblib/` next to `decks/`, so the `../../hblib/` paths work):

I've made the six "Strings in Java" decks on your template and libraries. Every program on the slides was compiled and run with Java 21, and the output shown is what it really printed. All six decks compile without errors, pass all the rules in your rules file, and nothing runs off a slide.

| Deck | Frames | What's in it |
|---|---|---|
| Concepts | 19 | What a string is, references and memory diagrams, immutability, `==` vs `equals`, the string pool, Unicode, encodings |
| Examples | 21 | 15 programs covering the core API, including Turkish case rules and text blocks |
| Freshman | 23 | Installing Java and compiling on Windows and macOS, `Scanner` and the `nextLine` trap, loops, reading error messages, palindromes |
| Sophomore | 18 | `equals`/`hashCode`, why `+=` in a loop is quadratic, the Turkish `Collator`, maps, anagrams, bracket matching with your `\hStack` |
| Junior | 20 | Naive search, KMP, Rabin–Karp and edit distance (pseudo code with `algorithm2e`), regular expressions, Unicode, encodings |
| Senior | 20 | Inside `String`, the JVM's handling of strings, benchmarking, security, a history timeline |

Some measured results that shaped the slides:
- **Compact strings:** one million 32-character strings take 68 MB normally and 99 MB with compact strings turned off.
- **ReDoS:** on Java 21 the textbook catastrophic pattern `(a+)+b` stays fast. I use `(.*a){20}` instead, which goes from 7 ms to 2.6 s as the input grows. An equivalent rewritten pattern runs in microseconds, and I checked it accepts the same strings.
- **KMP:** the worst-case example needs 1,991 comparisons, against 10,901 for the naive search.
- **Timings vary:** the timing slides say that students' numbers will differ from run to run.

An independent check of the 20 Java version facts on the slides (JEP numbers, which release added what) found them all correct.

I had to correct the libraries you sent:
- **All three libraries:** line 3 is a bare version stamp like `v20261002T0800`, which LaTeX prints as text before `\begin{document}`, so nothing compiled. I made those lines comments.
- **`hblibDatastructures`:** `\hQueue` drew the capacity number instead of the elements. Its `\ProvidesPackage` name was also still `adtlibrary`.
- **New `\hString` macro:** draws character boxes with 0-based indices and a highlighted range, like `substring(b, e)`.
- **`hblibCodeoutput` (now v1.6):**
  - A `codesnippet` style for short code typed directly on a slide.
  - More accented letters (Ä, Ã, Ÿ, §, …), so garbled text like `AÄŸaÃ§` prints in outputs.

To change the content, edit the `.java` files in a deck's `codeoutput/` folder and run `sh run_examples.sh`; the slides then pick up the new outputs. The README explains how to build on Windows and macOS.

Files are in:
- strings-concepts.pdf
- strings-examples.pdf
- strings-freshman.pdf
- strings-sophomore.pdf
- strings-junior.pdf
- strings-senior.pdf
- java-strings.zip