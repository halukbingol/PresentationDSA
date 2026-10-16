java Report.java > en.csv
LANG=tr_TR.UTF-8 java Report.java > tr.csv
cat en.csv tr.csv
awk -F, '{ print FILENAME ": " NF " fields" }' en.csv tr.csv
