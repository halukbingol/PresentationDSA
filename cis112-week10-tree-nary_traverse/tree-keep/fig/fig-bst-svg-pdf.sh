#!/bin/bash


# -------------------------------------------------------------------
# fig-bst-svg-pdf.sh — Binary tree generator in pdf
#
# Arguments:
#   $1 : highlighted nodes (comma-separated)
#   $2 : tree data (comma-separated, use "null" for empty nodes)
#   $3 : output file (without .pdf extension) 
# -------------------------------------------------------------------


#bintreeSvg --preset teal --highlight "$1" "$2" "$3.svg" \

listHighlight="$1"
listNode="$2"
filename="${3%.*}"

echo "$filename"

bintreeSvg --preset teal --highlight "$listHighlight" "$listNode" "${filename}.svg" \
  && rsvg-convert -f pdf -o "${filename}.pdf" "${filename}.svg" \
  && rm "${filename}.svg"  
  
echo "✓  ${filename}.pdf written" 

exit 0 # ###################

bintreeSvg --preset teal --highlight "$1" "$2" "$3.svg" \
  && rsvg-convert -f pdf -o "${3}.pdf" "${3}.svg" \
  && rm "${3}.svg"  
  
echo "✓  ${3}.pdf written" 