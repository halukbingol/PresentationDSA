# Run CompactDemo with and without compact strings (JEP 254).
unset JAVA_TOOL_OPTIONS                 # only if your system sets it
for flag in -XX:+CompactStrings -XX:-CompactStrings; do
    printf '%-21s ' "$flag"
    java "$flag" -cp build CompactDemo
done
