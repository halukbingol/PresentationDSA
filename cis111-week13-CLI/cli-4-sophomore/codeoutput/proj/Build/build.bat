@echo off
rem build.bat: the same for Windows (Command Prompt)
if exist out rmdir /s /q out
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt || exit /b 1
jar --create --file app.jar --main-class edu.yeditepe.bank.Main -C out .
java -jar app.jar
echo build OK
