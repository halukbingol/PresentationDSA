# Converting an Excel Row to a md Table Row

[toc]

There are several ways, from manual to automated.

## hb

```excel
=SUBSTITUTE(
	TEXTJOIN(
		" | ",TRUE,B3:E3
	), 
	"\,", ""   
)

=SUBSTITUTE(TEXTJOIN(" | ",TRUE,B3:E3), "\,", "")
```
