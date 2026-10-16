sh build.sh > /dev/null
mkdir fat
cd fat
jar xf ../dist/lib/table.jar
rm -r META-INF
cd ..
jar --create --file books-all.jar --main-class edu.yeditepe.books.Main -C build/app . -C app/res . -C fat .
jar tf books-all.jar | grep -v /$
java -jar books-all.jar
ls -l dist/books.jar dist/lib/table.jar books-all.jar | awk '{print $5, $9}'
