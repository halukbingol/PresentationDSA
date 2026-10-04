# Jdeps
. codeoutput/session.inc
fresh Jdeps
run 'javac -d classic/out classic/src/report/Report.java'
run 'jar --create --file report.jar --main-class report.Report -C classic/out .'
run 'jdeps -s report.jar'
run 'jdeps --print-module-deps report.jar'
