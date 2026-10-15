#@ mkdir -p course/week1 course/week2/lab
#@ head -c 1200 /dev/zero > course/week1/notes.txt
#@ head -c 300 /dev/zero > course/week1/Hello.java
#@ head -c 2500 /dev/zero > course/week2/slides.pdf
#@ head -c 450 /dev/zero > course/week2/lab/Tree.java
#@ head -c 50 /dev/zero > course/README.md
javac FileTree.java
java FileTree course
