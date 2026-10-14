javac -d build/util util/src/edu/yeditepe/util/Table.java
mkdir -p dist/lib
jar --create --file dist/lib/table.jar -C build/util .
javac -d build/app -cp dist/lib/table.jar -sourcepath app/src app/src/edu/yeditepe/books/Main.java
find build -name "*.class" | sort
java -cp build/app:app/res:dist/lib/table.jar edu.yeditepe.books.Main
