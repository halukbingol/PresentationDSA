# Bytecode of Concat.greet: default (Java 9+) and the old StringBuilder way.
unset JAVA_TOOL_OPTIONS
javap -c -cp build Concat | sed -n '/greet(/,/areturn/p' | sed 's/   */  /g' | cut -c1-74
echo "--- javac -XDstringConcat=inline (as before Java 9) ---"
mkdir -p build/inline
javac -XDstringConcat=inline -encoding UTF-8 -d build/inline codeoutput/Concat.java
javap -c -cp build/inline Concat | sed -n '/greet(/,/areturn/p' | sed 's/   */  /g' | cut -c1-74
