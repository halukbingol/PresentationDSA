#!/bin/bash


# delete

# 92 max
./fig-bst-svg-pdf.sh "92"       "92,72,70,69,56,67,20,44,25,35,47,40,50"    "fig-bst-delete-01.pdf"
# remove 92, create hole
./fig-bst-svg-pdf.sh "hole"   "hole,72,70,69,56,67,20,44,25,35,47,40,50"    "fig-bst-delete-02.pdf"
# 50 <-> hole
./fig-bst-svg-pdf.sh "50,hole"  "50,72,70,69,56,67,20,44,25,35,47,40,hole"  "fig-bst-delete-03.pdf"
# 50 <-> 72
./fig-bst-svg-pdf.sh "50,72"    "72,50,70,69,56,67,20,44,25,35,47,40,hole"  "fig-bst-delete-04.pdf"
# 50 <-> 69
./fig-bst-svg-pdf.sh "50,69"    "72,69,70,50,56,67,20,44,25,35,47,40,hole"  "fig-bst-delete-05.pdf"
# done
./fig-bst-svg-pdf.sh "50,44,25" "72,69,70,50,56,67,20,44,25,35,47,40,hole"  "fig-bst-delete-06.pdf"





exit 0 # ###################




#                 v     
bintreePdf -t   "92,72,70,69,56,69,20,44,25,35,47,40,67" -o "fig-bst-delete-01.pdf"
#                 v                                     
bintreePdf -t "hole,72,70,69,56,69,20,44,25,35,47,40,67" -o "fig-bst-delete-02.pdf"
#                v                                      v 
bintreePdf -t   "67,72,70,69,56,69,20,44,25,35,47,40,hole" -o "fig-bst-delete-03.pdf"
#                v   v                                   
bintreePdf -t   "72,67,70,69,56,69,20,44,25,35,47,40,hole" -o "fig-bst-delete-04.pdf"
#                    v     v                                   
bintreePdf -t   "72,69,70,67,56,69,20,44,25,35,47,40,hole" -o "fig-bst-delete-05.pdf"
