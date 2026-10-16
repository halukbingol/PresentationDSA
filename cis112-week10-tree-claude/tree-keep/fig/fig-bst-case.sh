#!/bin/bash


# cases

# l>p
./fig-bst-svg-pdf.sh "6,8" "6,8,5,.,.,.,." "fig-bst-case-685-a"
./fig-bst-svg-pdf.sh "6,a,b" "8,6,5,a,b,.,." "fig-bst-case-685-b"

# r>p
./fig-bst-svg-pdf.sh "6,8" "6,5,8,.,.,.,." "fig-bst-case-658-a"
./fig-bst-svg-pdf.sh "6,c,d" "8,5,6,.,.,c,d" "fig-bst-case-658-b"

# l>r>p
./fig-bst-svg-pdf.sh "6,8" "6,7,8,.,.,.,." "fig-bst-case-678-a"
./fig-bst-svg-pdf.sh "6,c,d" "8,7,6,.,.,c,d" "fig-bst-case-678-b"

# r>l>p
./fig-bst-svg-pdf.sh "6,8" "6,8,7,.,.,.,." "fig-bst-case-687-a"
./fig-bst-svg-pdf.sh "6,a,b" "8,6,7,a,b,.,." "fig-bst-case-687-b"

# p>l & p>r
./fig-bst-svg-pdf.sh "6,3,5" "6,3,5,.,.,.,." "fig-bst-case-635-a"
./fig-bst-svg-pdf.sh "none"  "6,3,5,.,.,.,." "fig-bst-case-635-b"


exit 0 # ###################






# BACKUP

# l>p
./fig-bst-svg-pdf.sh "6,8" "6,8,5,.,.,.,." "fig-bst-case-685-a"
./fig-bst-svg-pdf.sh "6,8" "8,6,5,?,?,.,." "fig-bst-case-685-b"

# r>p
./fig-bst-svg-pdf.sh "6,8" "6,5,8,.,.,.,." "fig-bst-case-658-a"
./fig-bst-svg-pdf.sh "6,8" "8,5,6,.,.,?,?" "fig-bst-case-658-b"

# l>r>p
./fig-bst-svg-pdf.sh "6,8" "6,7,8,.,.,.,." "fig-bst-case-678-a"
./fig-bst-svg-pdf.sh "6,8" "8,7,6,.,.,?,?" "fig-bst-case-678-b"

# r>l>p
./fig-bst-svg-pdf.sh "6,8" "6,8,7,.,.,.,." "fig-bst-case-687-a"
./fig-bst-svg-pdf.sh "6,8" "8,6,7,?,?,.,." "fig-bst-case-687-b"

# p>l & p>r
./fig-bst-svg-pdf.sh "6,8" "6,3,5,.,.,.,." "fig-bst-case-635-a"
# ./fig-bst-svg-pdf.sh "a,b" "8,6,5,?,?" "fig-bst-case6-8-5b"
