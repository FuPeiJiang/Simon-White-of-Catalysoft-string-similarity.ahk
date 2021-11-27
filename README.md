
found it here: https://stackoverflow.com/questions/653157/a-better-similarity-ranking-algorithm-for-variable-length-strings/6859596#653165

java code at: https://web.archive.org/web/20210415112545/http://www.catalysoft.com/articles/strikeamatch.html by Simon White of Catalysoft

translated to ahk + I edited so that `-` `_` `.` <code>&nbsp;</code> (whitespace char) all count as word delimeter

I'm using this in [ahk_explorer](https://github.com/FuPeiJiang/ahk_explorer)<br>
< 3 chars<br>
&nbsp;&nbsp;&nbsp;&nbsp;sort by found position<br>
3 or more chars<br>
&nbsp;&nbsp;&nbsp;&nbsp;sort by similarity_value

all I need is that it finds the file even if I make a typo:<br>
"lecutre" find "Lecture101_-_OK"
