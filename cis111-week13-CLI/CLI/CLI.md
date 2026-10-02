# CLI

[toc]

I'll convert this one to Beamer the same way as the last deck: same styling, code as real listings, and code screenshots retyped in LaTeX. Starting with the extraction.I'll redraw that cipher diagram in TikZ so it's crisp and editable. Writing the Beamer file now, reusing the styling from the Week 7 deck.Mostly right. Fixing a few spots: the yellow arrows on slide 9 point to the wrong place, a long line overflows on slide 7, and two callouts sit on top of code (slides 11 and 13).The asterisk tweak broke comment highlighting on slide 11, so I'm reverting it. Courier's raised asterisk is just how that font draws it.I've converted the CLI deck to a Beamer presentation that matches the Week 7 one. It builds with `pdflatex` with no errors and has 17 pages. The 5 Self Check slides (14–18) were hidden in the original, so they're hidden here too; the same `\hiddenslides` switch near the top shows them.

- **No images:** everything is LaTeX, so the project is just the `.tex` file and the PDF.
- **CaesarCipher.java (slides 11–13):** retyped as numbered listings using the textbook's line numbers. The original skips lines 54–73 (the `encrypt` method), and so does this version.
- **Cipher diagram (slide 10):** redrawn in TikZ.
- **Trace table (Self Check 7.12):** now a LaTeX table, with the crossed-out values drawn as slashes like the hand-drawn original.
- **Arrows (slide 9):** the yellow arrows from `-v` and `input.dat` down to `args` are drawn in TikZ.

**Content I added or fixed (please check):**
- **Slide 21 was incomplete:** its `main` method stopped after the `--file` case, and slide 22 was blank. I used slide 22 to finish the method: a `-n/--count` case (since `printHelp` lists it), a `default` case for unknown options, and the closing braces. This is the one place where I wrote code of my own.
- **Slide 7:** `java Calculator.java 5 * 3` won't work in Bash, because the shell replaces `*` with the file names in the current folder. It's now `5 '*' 3`, with a one-line note on the slide.
- **Slide 10:** the `–d` in the command was an en dash, which Java wouldn't recognise as an option. It's now a normal hyphen, `-d`.
- **Printed text:** "consol" is now "console" (slide 5), "Don't forget the close the files!" is now "…to close the files!" (slide 13), and the `printHelp` option descriptions are lined up in columns.

Want me to add the missing `encrypt` method (lines 54–73) to slide 13 so the whole program is on the slides?

Files are in cis111-w11-beamer:
- cis111-w11-beamer.zip (source and compiled PDF)
- cis111-w11-CLI.pdf (preview)