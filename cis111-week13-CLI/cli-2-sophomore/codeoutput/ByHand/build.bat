@echo off
rem build.bat -- builds dist\ (Windows Command Prompt)
if exist build rmdir /s /q build
if exist dist rmdir /s /q dist
mkdir dist\lib
javac -d build\util util\src\edu\yeditepe\util\Table.java || exit /b 1
jar --create --file dist\lib\table.jar -C build\util . || exit /b 1
javac -d build\app -cp dist\lib\table.jar -sourcepath app\src ^
      app\src\edu\yeditepe\books\Main.java || exit /b 1
jar --create --file dist\books.jar --manifest app\manifest.txt ^
    -C build\app . -C app\res . || exit /b 1
echo built: dist\books.jar
