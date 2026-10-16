#!/bin/bash

topic_home='cis111-week14-git'
topic='git'


cd "/Users/bingol/Documents/hb-git/git-YU/git-PresentationDSA/${topic_home}"


git mv "${topic}-1-concepts"  "${topic}-0-concepts"
git mv "${topic}-2-examples"  "${topic}-5-examples"
git mv "${topic}-3-freshman"  "${topic}-1-freshman"
git mv "${topic}-4-sophomore" "${topic}-2-sophomore"
git mv "${topic}-5-junior"    "${topic}-3-junior"
git mv "${topic}-6-senior"    "${topic}-4-senior"



# git mv "${topic}"'-1-concepts'  "${topic}"'-0-concepts'
# git mv "${topic}"'-2-examples'  "${topic}"'-5-examples'
# git mv "${topic}"'-3-freshman'  "${topic}"'-1-freshman'
# git mv "${topic}"'-4-sophomore' "${topic}"'-2-sophomore'
# git mv "${topic}"'-5-junior'    "${topic}"'-3-junior'
# git mv "${topic}"'-6-senior'    "${topic}"'-4-senior'