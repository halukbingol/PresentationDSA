#!/bin/bash
APP_NAME=git-le

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A usage
usage() {
    echo "Usage:"
    echo "   $APP_NAME <topicDir> <topicName>"
    echo "Example:"
    echo "   $APP_NAME topic-regex regex"
    echo "   $APP_NAME cis111-week09-string string"
    exit 1
}
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A usage



# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V gitAddTopicX
function gitAddTopicX(){
	echo '--gitAddTopicX:' "$PWD" 
	local toTopicX="$1"
	local topicName="$2"

	fGitIgnore="${toTopicX}/.gitignore"
	gitAddGitIgnore "${fGitIgnore}"

	gitAddLevel "${toTopicX}" "${topicName}" '0' 'concepts'
	gitAddLevel "${toTopicX}" "${topicName}" '1' 'freshman'
	gitAddLevel "${toTopicX}" "${topicName}" '2' 'sophomore'
	gitAddLevel "${toTopicX}" "${topicName}" '3' 'junior'
	gitAddLevel "${toTopicX}" "${topicName}" '4' 'senior'
	gitAddLevel "${toTopicX}" "${topicName}" '5' 'examples'
}
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A gitAddTopicX



# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V gitAddLevel
function gitAddLevel(){
	echo '--gitAddLevel:' "$PWD" 
	echo "${FUNCNAME[0]}"  "$PWD" 

	local toTopicX="$1"
	local topicName="$2"
	local levelNo="$3"
	local levelName="$4"

	git add "${toTopicX}/${topicName}-${levelNo}-${levelName}/run_examples.sh"
	git add "${toTopicX}/${topicName}-${levelNo}-${levelName}/codeoutput/"
	git add "${toTopicX}/${topicName}-${levelNo}-${levelName}/${topicName}-${levelName}.tex"

	fGitIgnore="${toTopicX}/${topicName}-${levelNo}-${levelName}/.gitignore"
	gitAddGitIgnore "${fGitIgnore}"

	
}
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A gitAddLevel



# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V gitAddGitIgnore
function gitAddGitIgnore(){
	echo "---${FUNCNAME[0]}"  "$PWD" 

	fGitIgnore="$1"

	if [ -f "$fGitIgnore" ]; then
	    git add "$fGitIgnore"
	    echo "Added $fGitIgnore"
	# else
	#     echo "File not found: $fGitIgnore" >&2
	fi	
}
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A gitAddGitIgnore



# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V main

# Check if arguments were provided
if [ $# -ne 2 ]; then
    usage
fi

topicDir=$1  # topic-regex,  cis111-week09-string
topicName=$2 # regex, string



toTopicX="$HOME/Documents/hb-git/git-YU/git-PresentationDSA/${topicDir}"
cd "${toTopicX}"

echo '--main:' "$PWD" 

gitAddTopicX "${toTopicX}" "${topicName}"
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ A main
