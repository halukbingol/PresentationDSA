#@ export JAVA_HOME=$(dirname "$(dirname "$(readlink -f "$(command -v javac)")")")
java -version
javac -version
ls "$JAVA_HOME/bin" | xargs -n 8
