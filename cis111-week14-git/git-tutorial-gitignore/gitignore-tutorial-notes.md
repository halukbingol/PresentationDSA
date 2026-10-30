# gitignore-tutorial-notes

[toc]

I'll start by checking the current official gitignore documentation. One point matters from the start: `.gitignore` patterns are not regular expressions. They are glob (wildcard) patterns, and the tutorial will make that contrast its central idea.

I've made the tutorial (9 pages, about an hour of self-study). It compiles with no errors and no overfull boxes, and passes the rule check.

One correction shaped it: `.gitignore` does not use regular expressions. Its patterns are glob (wildcard) patterns. So the tutorial teaches the real rules by contrasting them with the regex the students already know. It opens with the mistake they will make: `.*\.log` written as a regex in `.gitignore` ignores only `.secret.log`, because it means "a name starting with a dot".

Every output is from a real Git session in a fresh repository. The sections cover:
- a regex-vs-glob symbol table;
- the commands that show what is ignored and why (`git status --ignored`, `git check-ignore -v`);
- `*`, `?` and character sets, then the four slash rules shown on the same six files, and `**`;
- `!` negation, the order of lines, and the classic trap (`build/` + `!build/keep.txt` doesn't work, `build/*` does), with an algorithm2e box;
- special characters, and where patterns come from: `.gitignore` files, `.git/info/exclude`, and the global ignore file, with commands for setting it on Windows and macOS;
- files that are already tracked (`git rm --cached`);
- upper and lower case on Windows and macOS (`core.ignorecase`), shown with both settings;
- a small Java program that turns a glob into a regex; its results agree with Git on the test paths;
- a `.gitignore` for Java projects, a "regex habit → glob" table, and exercises whose answers are checked by Git itself.

The sessions ran with Git 2.43. I checked the rules against the current official Git 2.54 documentation, and they are the same.

It is a printed document like the Lab 5 handout, so it needs your `hblibPresentation.sty` updated to v20261027T1800. The zip includes it, together with the session files and a README.

Sources:
- [gitignore documentation (Git 2.54.0)](https://git-scm.com/docs/gitignore/2.54.0)
- [gitignore(5), Linux manual page](https://www.man7.org/linux/man-pages/man5/gitignore.5.html)
