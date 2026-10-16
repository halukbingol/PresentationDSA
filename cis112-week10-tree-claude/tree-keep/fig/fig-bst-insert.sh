#!/bin/bash



# insertion

# FAL
./fig-bst-svg-pdf.sh "FAL"     "97,70,51,63,55,37,10,43,27,30,34,FAL" "fig-bst-insert-01.pdf"
# 95 insert FAL
./fig-bst-svg-pdf.sh "95"      "97,70,51,63,55,37,10,43,27,30,34,95" "fig-bst-insert-02.pdf"
# 95 <-> 37             
./fig-bst-svg-pdf.sh "95,37"   "97,70,51,63,55,95,10,43,27,30,34,37" "fig-bst-insert-03.pdf"
# 95 <-> 51
./fig-bst-svg-pdf.sh "95,51"   "97,70,95,63,55,51,10,43,27,30,34,37" "fig-bst-insert-04.pdf"
# 95 <-> 82
./fig-bst-svg-pdf.sh "95,97"   "97,70,95,63,55,51,10,43,27,30,34,37" "fig-bst-insert-05.pdf"
# done
./fig-bst-svg-pdf.sh "none"    "97,70,95,63,55,51,10,43,27,30,34,37" "fig-bst-insert-06.pdf"




exit 0 # ###################



node bintree-svg.js --preset teal --highlight "B,D" "A,B,C,D,E,F,G" fig/teal.svg



#                              v                v 
bintreePdf -t "82,70,51,63,55,37,10,43,27,30,34,FAL" "fig-bst-insert-01.pdf"
#                              v                v "
bintreePdf -t "82,70,51,63,55,37,10,43,27,30,34,95" "fig-bst-insert-02.pdf"
#                     v        v                
bintreePdf -t "82,70,51,63,55,95,10,43,27,30,34,37" "fig-bst-insert-03.pdf"
#               v     v
bintreePdf -t "82,70,95,63,55,51,10,43,27,30,34,37" "fig-bst-insert-04.pdf"
#               v     v
bintreePdf -t "95,70,82,63,55,51,10,43,27,30,34,37" "fig-bst-insert-05.pdf"
