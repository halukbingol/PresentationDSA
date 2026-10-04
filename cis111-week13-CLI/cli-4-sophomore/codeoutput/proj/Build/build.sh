#!/bin/sh
# build.sh: compile, package and run the bank example (macOS, Linux, Git Bash)
set -e                                  # stop at the first failing command
rm -rf out app.jar
find src -name "*.java" > sources.txt
javac -d out @sources.txt
jar --create --file app.jar --main-class edu.yeditepe.bank.Main -C out .
java -jar app.jar
echo "build OK"
