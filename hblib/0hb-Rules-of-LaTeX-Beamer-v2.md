# Rules of LaTeX Beamer (v2)

[toc]

Rules for AI generated LaTeX presentation.

## Cross Platform

Explain for both Windows and MacOS.


## First lines

Make the very first line as

```latex
% !TEX spellcheck = en_US



% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V
% (NC) 2026 Haluk Bingol
% github.com/halukbingol/LaTeX-Templates
%
% Licensees may copy, distribute, display, and perform the work and make derivative works 
% and remixes based on it only for non-commercial purposes. 
% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A


```

## Title page

- Use the following in the title page
	
	```latex
	\author[Bingol]{Haluk O. Bingol}
	
	\institute[FCIS]{
		Faculty of Computer and Information Sciences\\
		Yeditepe University
	}
	```



## General formating


### slide no
- Every frame should have `i/N`, 
where 
	`i` is the frame number;
	`N` is the total number of frames.
	
### code
- use monospace font for code

### section 

- Put all `\section`, `\subsection` tags into these comments as the following

	```latex
	% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V
	\section{something}
	% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A
	```

### Environments

Use the following empty line and comment structure at the beginning and at the end of envirinments

#### figure

- Make all `begin{figure}` as
	
	```latex
	
	
	% +++++++++++++++++++++++++++++++++++++++ V fig
	%: -Fig.
	\begin{figure}
	```

- Make all `\end{figure}` as

	```latex
	\end{figure}
	% +++++++++++++++++++++++++++++++++++++++ A fig
	
	
	```	

#### table

- Make all `begin{table}` as
	
	```latex
	
	
	% +++++++++++++++++++++++++++++++++++++++ V tbl
	%: -Tbl.
	\begin{table}
	```

- Make all `\end{table}` as

	```latex
	\end{table}%
	% +++++++++++++++++++++++++++++++++++++++ A tbl
	```	


#### frame

- Make all `\begin{frame}` as
	
	```latex
	
	
	
	
	% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V frm
	\begin{frame}[t,fragile] \frametitle{aaa}
	```

- Make all `\end{frame}` as

	```latex
	\end{frame}
	% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A frm
	```	

#### lstlisting

- Make all `begin{lstlisting}` as
	
	```latex
	
	
	% +++++++++++++++++++++++++++++++++++++++ V lst
	%: -Lst.
	\begin{lstlisting}
	```

- Make all `\end{lstlisting}` as

	```latex
	\end{lstlisting}
	% +++++++++++++++++++++++++++++++++++++++ A lst
	
	
	```	


#### algorithm

- Make all `begin{algorithm}` as
	
	```latex


	% +++++++++++++++++++++++++++++++++++++++ V alg
	%: -Alg. 
	\begin{algorithm}[H]
	```

- Make all `\end{algorithm}` as

	```latex
	\end{algorithm}
	% +++++++++++++++++++++++++++++++++++++++ A alg
	
	```	


	
## Math formatting

- In math mode for display, use new lines as in

	```latex
	\[
		aaa
	\]
	```
	
	rather than 
	
	```latex
	\[aaa\]
	```
	
- Use `{` and `}` in subcripts and superscripts. 
That is,
use  `a_{b}` rather than `a_b` in math mode.



## Pseudo algorithms

Use `algorithm2e` package for pseudo algorithms.



## Deck structure

- Start every deck from `hbCisLaTeXTemplate.tex`:
`\documentclass[aspectratio=169,10pt,compress]{beamer}`.
- Load the libraries with a relative path, inside the `hblib` comment block:

	```latex
	% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V hblib
		\usepackage{../../hblib/hblibPresentation} % lib presentation: theme, i/N, \hSection, algorithm2e, ...
		\usepackage{../../hblib/hblibCodeoutput} % lib code + output: \lstcode, \lstterminal, ...
		\usepackage{../../hblib/hblibDatastructures} % lib data structures: \hString, \hStack, \hQueue
	% ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A hblib
	```

- Do not repeat in a deck what a library already provides (theme, colors, `L{width}` column, styles, macros).
Anything that more than one deck needs goes into a library.
- Do not define macros whose names a library package already uses
(e.g. `\cmd` is defined by `menukeys`; use `\hCode{...}` for commands in text).
- Put the date as `\date{{\tiny \hbTimeStamp}}`.
- Frame order: title page, outline (`\tableofcontents[hideallsubsections]`, in two columns if long),
the sections, a summary section, and a last frame with `\hRemark{\Huge Questions?}`.
- Start every section with `\hSection[short]{Long}` (it also makes a title frame).
- Folder layout (one shared `hblib`, one folder per topic, no `decks/` level):

	```
	home/
	  hblib/                      the three libraries, shared by all topics
	  <topic>/
	    README.txt
	    <topic>-0-concepts/       <name>.tex, <name>.pdf, codeoutput/, run_examples.sh
	    <topic>-1-freshman/
	    <topic>-2-sophomore/
	    <topic>-3-junior/
	    <topic>-4-senior/
	    <topic>-5-examples/
	```


## Levels

When a topic is asked for several audiences, make separate decks:

- **concepts** (folder `<topic>-0-concepts`): ideas, pictures and tables, little or no code
- **freshman** (`<topic>-1-freshman`): first steps, the most common errors and how to read them
- **sophomore** (`<topic>-2-sophomore`): projects, libraries, tools, good habits
- **junior** (`<topic>-3-junior`): advanced features, performance, larger systems
- **senior** (`<topic>-4-senior`): internals, security, production use, open-ended projects
- **examples** (`<topic>-5-examples`): the ideas of the concepts deck, each shown with a small real program or session

Each level deck ends with a summary (cheat sheet or recipes table) and exercises or projects.


## Code and output

- Never retype code or output into the `.tex`.
Keep programs in `codeoutput/` and show them with the `hblibCodeoutput` macros:
	- `\lstcode[opts]{codeoutput/X.java}{Java}` code only
	- `\lstcoderightstep[width][code opts][output opts]{code}{Java}{output}` code, then output on the next click
	- `\lstcodedownstep`, `\lstcodeoverlaystep`, `\lstoutput`
	- `\lstterminal[opts]{codeoutput/X.txt}` a terminal session; lines starting with `$ ` are commands
- All output shown must be **real**: produced by running the program or session.
`run_examples.sh` in each deck folder reruns everything and rewrites the outputs:
	- `codeoutput/<Name>.java` (+ optional `.in`, `.args`) → `codeoutput/<Name>.txt`
	- `codeoutput/<Name>.sh` (+ project folder `codeoutput/<Name>/`) → `codeoutput/<Name>.txt`;
	lines starting with `#@ ` run silently as setup.
- Commands that could not be run (another operating system, no network: Maven, Gradle, Docker, ...)
are typed `lstlisting`s and are marked `\hRemark{Not run here}`.
- Short code typed in the `.tex` uses `style=codesnippet` (code) or `style=texsnippet` (LaTeX).
- Show the output on the second click, so the audience can predict it first.
- Show Windows and macOS commands side by side when they differ
(Windows: Command Prompt, `;` in class paths, `^` to continue a line;
macOS: Terminal, `:` in class paths, `\` to continue a line).


## Layout check

- Compile twice with `pdflatex`; there must be no errors.
- Render the pages to images and look at every page: nothing may run off the slide or overlap.
An `Overfull` warning of 3 pt or less is acceptable after this check.
- Keep code lines short; shorten long output with `| head -n`, `grep` or `cut`
instead of making the font too small (smallest: `\tiny`).
- Keep notes under a code box to one or two lines.


## Content

- Check facts that change over time (versions, install commands, package names, dates) against official sources.
- Use examples from the audience's world where they fit (e.g. Turkish text for encodings and the Turkish `i`).
- Teach the common errors: show the real error message and how to read it.


## Libraries

- Libraries: `hblibPresentation.sty`, `hblibCodeoutput.sty`, `hblibDatastructures.sty`.
- Every change gets a new version line (`% vYYYYMMDDTHHMM`) and a new date/version in `\ProvidesPackage`.
- Changes must be backward compatible: existing decks must still compile.
- Keep the author's own edits when merging library versions.
- Inside a `.sty` use `\RequirePackage`, not `\usepackage`.
- Do not load packages that break beamer (e.g. `enumitem` is loaded only when the class is not beamer).
- There is one `hblib` for all topics: after a library change, compile the decks of every topic.
- Deliver libraries as `hblib/` with only the three `.sty` files, so the author's other files in `hblib/` are not overwritten.


## Rule check

Before delivering, check every deck mechanically (e.g. with a script) for:

- the first lines, author and institute
- frame, `lstlisting`, `algorithm`, figure and table markers and the blank lines around them
- `V` / `A` lines around every `\section`, `\subsection`, `\hSection`
- display math on separate lines, braces in sub- and superscripts
- every file read by `\lstcode`, `\lstoutput`, `\lstterminal` exists
