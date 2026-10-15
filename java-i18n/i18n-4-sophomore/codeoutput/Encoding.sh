#@ printf 'quit=\xc7\xfdk\xfd\xfe\n' > Texts_tr.properties
#@ printf 'quit=\\u00c7\\u0131k\\u0131\\u015f\n' > Escaped_tr.properties
#@ printf 'quit=Çıkış\n' > Utf8_tr.properties
file *.properties
java Show.java Texts
java Show.java Escaped
java Show.java Utf8
iconv -f ISO-8859-9 -t UTF-8 Texts_tr.properties > tmp && mv tmp Texts_tr.properties
java Show.java Texts
