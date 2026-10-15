# i18n

[toc]

I'll build the six Java internationalization (i18n) decks on your new `hblib` libraries and template, following the v2 rules. All output shown will come from real Java 21 runs. First I'll look inside the zip.

Backward compatible. Now the README, cleanup and package.

I've made the six "Internationalization in Java" decks. All six compile with no errors and pass the v2 rules check.

| Deck | Pages | Covers |
|---|---|---|
| 1 Concepts | 31 | What i18n and l10n mean, locales, Unicode and encodings, numbers, money, dates and time zones, translated texts and plurals, the Turkish i, sorting, the Java classes, a working process |
| 2 Examples | 43 | Each idea as a small real program, from locales and number formats to text bytes and `Scanner` |
| 3 Freshman | 27 | First-week surprises: `printf` printing `3,14`, `Scanner` failing on a Turkish computer, `?` instead of letters (and `chcp 65001` on Windows), the "QUİT" bug, a first translation file and its errors |
| 4 Sophomore | 34 | A translated shop application built into a JAR, how Java picks the translation file and the default-locale trap, file encodings, `MessageFormat` pitfalls, safe parsing, `Collator`, tests in many locales, a fake test language (pseudo-localization) |
| 5 Junior | 39 | Characters vs. code points vs. what readers see, normalization, case mapping, locale add-ons (calendar, currency, first day of week), Unicode CLDR plural rules, the lookup algorithm, time zone rules, thread safety, right-to-left text |
| 6 Senior | 34 | Architecture, choosing the language from the browser's Accept-Language header, language packs as Java modules, translations that reload without a restart, automatic translation checks, smaller runtimes, security, containers, the translation workflow |

- **The outputs are real.** Every output on the slides comes from actually running Java 21. Some demos run as Turkish: the scanner failing on `3.5`, the "QUİT" bug, a reserved user name `admin` slipping through on a Turkish server, and a CSV file that gains an extra field.
- **Not run:** Maven, Gradle, the ICU4J library and Docker had no network here, so those slides are code listings marked "Not run here".
- **Windows and macOS:** both are covered: regional settings menus, the console code page, and commands side by side.

I changed one library. `hblibCodeoutput.sty` is now v1.9: code and output boxes can now show €, £, ¥, °, quotes, dashes, no-break spaces and more Latin letters, and the lira (`\hbLira`) and rupee (`\hbRupee`) signs, which are hand-drawn because the fonts lack them. Your other two libraries are unchanged. The command-line decks still compile with v1.9, so it doesn't break existing decks.

Text in Japanese, Arabic or Cyrillic can't be typeset with pdflatex. Those examples print character codes (like `U+0430`) instead, and the slides explain why.

The zip contains the six `.tex` files and PDFs, each deck's `codeoutput/` folder with its `run_examples.sh`, the three library files, and a README.

Version facts on the slides that change over time, such as the Java release where a feature appeared, were checked against the OpenJDK sources below.

Sources:
- [OpenJDK: 8291660 Grapheme support in BreakIterator](https://mail.openjdk.org/pipermail/i18n-dev/2022-August/005783.html)
- [OpenJDK: 8174269 Remove COMPAT locale data provider (integrated)](https://mail.openjdk.org/pipermail/i18n-dev/2024-March/008869.html)
- [Java SE 22: java.text.ListFormat](https://cr.openjdk.org/~iris/se/22/latestSpec/api/java.base/java/text/ListFormat.html)