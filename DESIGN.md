
# Project Architecture

## Project structure 
This is a maven project so it uses the convention defined by this one. It is structured according to the following tree :

The src directory: Contains all source files (source codes and tests)
The src/main directory: Contains all the source codes of the project.
The src / test directory: Contains the source codes of the tests
The input directory: Contains the URLs of Wikipedia pages input to our program
The output directory: Contains all the tables extracted from all the pages supplied as input.

## Dependencies
There are libraries from which the project depends for its proper functioning :

### Junit :
is the Java unit test framework that allows you to make assertions

### Logging :
consists of adding processing in the applications to allow the emission and storage of messages following events. It keeps track of exceptions and executions(Stacktrace).

### JSOUP :
is a java library for working with real HTML. It provides a very convenient API for extracting and manipulating data using the best of DOM, CSS and JQuery methods. It serves as an HTML parser.

### JWBF  :
The Wiki Bot Framework is a library for maintaining Wikipedia-like Wikis based on Mediawiki. The library provides methods for connecting, editing, and reading collections of articles to help you create your Bot Wiki project.

### API Wikimedia : 
content in the JWBF, it is a web service that provides access to some features such as authentication, page operations and search. It can provide meta-information about the wiki and the logged-in user.
### Bliki :
the Wikipédia java API is a parsing library that converts wikitext from Wikipedia to HTML.

### Apache MAVEN :
is a management and production automation tool for Java software projects in general. It is used to automate continuous integration during software development.
The Maven architecture is based on the POM.xml file.
POM (Project Object Model) contains project information and configuration details used by Maven to build the project.
It contains default values ​​for most projects. Examples that illustrate it include the directory building, which is in the Target; 
the source directory, which is in src / main / java; the source directory of the test, located in src / test / java; etc.
When performing a task or goal, Maven searches for the POM in the current directory. It reads the POM, retrieves the configuration information, and then executes the objective.
Some of the configurations that can be specified in the POM are project dependencies, plug-ins or goals that can be executed, build profiles, and so on. Other information such as the project version, description, developers, contact lists, and more can also be specified.

# Package Organization and Class Descriptions

In order to properly organize our project, we have created a number of packages in the src/main and src/test directories :

The src/main directory contains four packages :

the Default Package: it contains the class allowing the execution of our application.

the Bliki package : is composed of the class API_BlikiImp which allows to extract the tables of a Wikipedia page from the code wikitext.

the Jsoup package : contains the API_JsoupImp class that extracts the tables from a Wikipedia page from the html code.

The utils package: includes all the classes that represent a web page, a table, a row and a cell of a table

The src/test directory consists of a single package  testPDL which includes all the unit tests of our program.
