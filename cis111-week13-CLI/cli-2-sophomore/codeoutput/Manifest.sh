sh build.sh
unzip -p dist/books.jar META-INF/MANIFEST.MF
cd dist
find . -type f | sort
java -jar books.jar
cd ..
mkdir alone
cp dist/books.jar alone/
java -jar alone/books.jar 2>&1 | head -2
