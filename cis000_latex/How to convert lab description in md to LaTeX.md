# How to convert lab description in md to LaTeX

[toc]

## Lab description template

Lab description template is located at 
`lab/cis11x-week00-template.tex`.

## How to convert lab description in md to LaTeX

A typical directory structure:

```txt
├── cis000_latex
│   ├── ...
│   ├── hblibCommon-UserManual.tex
│   ├── hblibCommon.sty
│   ├── in-ExamInfo-Intro.tex
│   ├── in-ExamTiming.tex
│   ├── in-Objection.tex
│   ├── in-Period1-BeforeExamStarts.tex
│   ├── in-Period2-DuringExam.tex
│   ├── in-Period3-AtTheEndOfTheExam.tex
│   ├── in-WarningAboutTheAutoGrader.tex
│   └── lab
│       └── cis11x-week00-template.tex
├── cis111_week01
│   ├── 0-config.txt
│   └── lab
│       ├── cis111-week01.md
│       ├── cis111-week01.pdf
│       ├── ...
│       ├── cis111-week01-md.tex
│       ├── ...
│       ├── cis111-week01.tex
│       └── ...
```

### steps

1. Copy `cis11x-week00-template.tex` under `cis111_week01/lab`.

1. Rename 
`cis111_week01/lab/cis11x-week00-template.tex` as 
`cis111_week01/lab/cis111-week01.tex`. 

1. Using AI convert `cis111-week01.md` to LaTeX, call it `cis111-week01-md.tex`.

1. Copy `cis11x-week00-md.tex` under `cis111_week01/lab`.

1. Copy related parts of `cis11x-week00-md.tex` into `cis111-week01.tex`.

Note that 

- `cis111-week01.tex` has specific sections for "WarmUp", "Goal", "Challenge", "Home".
Use them.

- At the bottom of `cis111-week01.tex` has usefull info included.