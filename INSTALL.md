# How to install and use our project
This document retranscribes  the instructions needed to extract tables from Wikipedia pages to convert them to CSV and HTML files.
## Installation
### Git Bash
Git Bash is a git command prompt to interact with the remote server hosting the Project.
In order to clone the Project you must execute the following command:
Git clone https://github.com/ysimp/pdl-wiki.git
### SourceTree
To avoid having to write command lines to clone the Project, you can use SourceTree which is an interface that will allow you to interact with your Git repositories, so you can focus on your coding. SourceTree will certainly allow you to visualize your code, to make commits of your project on your Git space.
### IDE (Text Editor)
After cloning your project in your personal folder or downloading the .rar or .zip… file from Gitlab, it is desirable to have an IDE (Eclipse, Netbeans, IntelliJ) in the latest version that will help you to code, structure, Compile, run tests and run your Project in Java. To open your already downloaded project, it is desirable to do the following:
File> Open Project from File System> Directory> ... ..> Finish
In order to install your favorite IDE you must have a Java Development Kit (JDK) with a minimal version 8.
Input & output : 
In order to run the project you must have an output folder in the root of your project. This folder will contain two subfolders: html and wikitext which will in turn contain the results of the execution of our extractor.
You must also check the existence of the inputData folder in the root of your project which contains the wikiurls.txt file in which the various URLs of the wikipedia pages to be extracted have been stored.

## Main Program
This is the starting point of the project. This is the class that must be executed directly because it contains the main () function of the project.
Do not forget to update the Project by right clicking on the Project> Maven> Update Project, in order to download the dependency libraries.

