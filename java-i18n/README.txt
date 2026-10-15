Internationalization in Java -- six Beamer decks
=================================================

decks/i18n-1-concepts    i18n-concepts.tex   i18n/l10n, locales (BCP 47), Unicode and encodings, numbers, money,
                                             dates and zones, bundles, plurals, Turkish i, sorting, the Java toolbox
decks/i18n-2-examples    i18n-examples.tex   every idea as a small real program: locales, default locale,
                                             numbers, currencies, parsing, compact numbers, dates, zones, bundles,
                                             MessageFormat, case, Collator, Normalizer, bytes, Scanner
decks/i18n-3-freshman    i18n-freshman.tex   first-week surprises: printf with a comma, Scanner on a Turkish
                                             computer, ? instead of letters (Windows chcp 65001), the "QUİT" bug,
                                             a first resource bundle and its errors
decks/i18n-4-sophomore   i18n-sophomore.tex  a localized application in packages and a JAR, lookup order and the
                                             default-locale trap, bundle encodings, MessageFormat pitfalls,
                                             safe parsing, Collator strength, tests in many locales,
                                             pseudo-localization, Maven/Gradle
decks/i18n-5-junior      i18n-junior.tex     chars / code points / graphemes, normalization forms, case mapping,
                                             -u- extensions (calendar, currency, first day), DISPLAY vs FORMAT,
                                             CLDR vs COMPAT, CLDR plurals, bundle lookup algorithm, time zone
                                             rules, thread safety of formatters, right-to-left text
decks/i18n-6-senior      i18n-senior.tex     architecture, Accept-Language negotiation, language packs as modules
                                             (ResourceBundleProvider), reloadable bundles, CI bundle checks,
                                             jlink --include-locales, security (Turkish i, look-alike names,
                                             CSV with the default locale, encodings), containers, translation workflow

hblib/                   hblibCodeoutput.sty v1.9 (new: more characters in code/output: € £ ¥ °, quotes,
                         dashes, no-break spaces, more Latin letters; drawn \hbLira and \hbRupee),
                         hblibPresentation.sty and hblibDatastructures.sty unchanged.
                         v1.9 is backward compatible (the java-cli and java-strings decks compile with it).

Building a deck (Windows: Command Prompt; macOS: Terminal)
-----------------------------------------------------------
  cd decks/i18n-3-freshman
  pdflatex i18n-freshman.tex      (twice, for i/N and the outline)

Programs and outputs
--------------------
Every output on the slides is REAL (Java 21, Linux), made by run_examples.sh:
  codeoutput/<Name>.java   a program            -> codeoutput/<Name>.txt
  codeoutput/<Name>.sh     a terminal session   -> codeoutput/<Name>.txt
  codeoutput/<Name>/       the session's project folder (a temporary copy is used)
  bash run_examples.sh [Name.java | Name.sh]      (macOS: Terminal; Windows: Git Bash)
The runner starts from an English (US) system in Istanbul (LANG=en_US.UTF-8, TZ=Europe/Istanbul);
examples that need another locale say so on the command line (LANG=tr_TR.UTF-8, -Duser.language=tr).
On Linux, LANG=tr_TR.UTF-8 needs the locale installed (locale-gen tr_TR.UTF-8).
Maven, Gradle, ICU4J and Docker listings are marked "Not run here" (no network access while building).

Rules: 0hb-Rules-of-LaTeX-Beamer-v2.md (all six decks pass the rule check).
