# Shared by the demo scripts (sourced, not run):
# run each demo in a fresh folder and print commands like a terminal.
unset JAVA_TOOL_OPTIONS
fresh() {                      # fresh <demo>: copy codeoutput/proj/<demo> to build/run/<demo>
    rm -rf "build/run/$1"; mkdir -p "build/run/$1"
    if [ -d "codeoutput/proj/$1" ]; then cp -r "codeoutput/proj/$1/." "build/run/$1/"; fi
    cd "build/run/$1" || exit 1
}
run() {                        # run '<command line>': show it, run it, show a non-zero exit code
    echo "\$ $1"
    eval "$1" 2>&1
    rc=$?
    if [ $rc -ne 0 ]; then echo "[exit code $rc]"; fi
    return 0
}
