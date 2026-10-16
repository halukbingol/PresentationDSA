javac -d build/util util/src/edu/yeditepe/util/Table.java
javac -d build/test -cp build/util test/TableTest.java
java -cp build/util:build/test TableTest
java -ea -cp build/util:build/test TableTest
