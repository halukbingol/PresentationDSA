# Rules of LaTeX Beamer

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
where 
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