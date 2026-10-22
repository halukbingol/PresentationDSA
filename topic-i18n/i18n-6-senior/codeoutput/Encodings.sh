for l in en_US.UTF-8 tr_TR.UTF-8 tr_TR; do echo "== LANG=$l"; LANG=$l java -XshowSettings:properties -version 2>&1 | grep -E "^ +(file|native|stdout|sun.jnu).encoding"; done
