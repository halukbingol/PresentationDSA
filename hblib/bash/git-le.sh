#!/bin/bash

folderName=$1 # String-4-sophomore
fileName=$2 # strings-sophomore

touch "${folderName}/.gitignore"

echo '# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V specific' >> "${folderName}/.gitignore"

echo '# folder' >> "${folderName}/.gitignore"
echo '/_old' >>    "${folderName}/.gitignore"
echo '' >> "${folderName}/.gitignore"
echo '# file' >>   "${folderName}/.gitignore"
echo "/${fileName}.pdf" >> "${folderName}/.gitignore"
echo '' >> "${folderName}/.gitignore"
echo '# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ V specific' >> "${folderName}/.gitignore"

git add \
	"${folderName}/.gitignore" \
	"${folderName}/run_examples.sh" \
	"${folderName}/codeoutput/" \
	"${folderName}/${fileName}.tex"
