#!/bin/sh
# build.sh -- builds dist/ (macOS Terminal, Linux, Windows Git Bash)
set -e                                     # stop at the first error
rm -rf build dist
mkdir -p dist/lib
javac -d build/util util/src/edu/yeditepe/util/Table.java
jar --create --file dist/lib/table.jar -C build/util .
javac -d build/app -cp dist/lib/table.jar -sourcepath app/src \
      app/src/edu/yeditepe/books/Main.java
jar --create --file dist/books.jar --manifest app/manifest.txt \
    -C build/app . -C app/res .
echo "built: dist/books.jar"
