java -XshowSettings:locale -version 2>&1 | head -4
java Prov.java
java -Djava.locale.providers=COMPAT Prov.java
