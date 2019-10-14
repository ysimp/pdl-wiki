# Wikipedia Matrix : The Truth 
This project is implemented within the framework of the EU PDL of our Master 1 (MIAGE).
## Project context
Its goal is to improve the WikipediaMatrix 2018-2019 project which automatically extracts tabular data from Wikipedia pages retrieved by their URL in CSV files.
There are two ways to extract the raw tabular data from either the HTML code (used by the web browser to describe the page) or the Wikitext (a markup language used).
## Goal of the project
- Understanding the existing project (Wikipedia Matrix Project: The Truth of the former group M1 MIAGE 2018 - 2019).
-Improving the project at the documentation, code and test levels.
- Improvement of the two extractors.
## Functionality supported
The project has a file that contains 336 Wikipedia URLs. The software generates a CSV file for each table on the page. These files are in an output directory that contains tables from two different sources: 
• Tables extracted from the html code and will be saved in the output / html folder.
• Tables extracted from the wikitext code and will be saved in the output / wiki folder.
## Analysis of the existing
The existing project has several drawbacks:
First, very less information on the README.md document that creates difficulty in understanding how the project works.
Second, the classes are badly named, structured and organized, for example class name “TestExtraTableJsoup” which has no test but it's just a normal class.
Moreover, the extractor treats the standard tables against the others are not taken into account.
Finally, the absence of an important step after the installation of the project which is the tests and automatic assertions by JUnit which can be used to check the content of the CVS files obtained in output.
## Functionality to develop 
- We have to create Unit tests.
- We should then improve the operation of both extractors to get good results.
- We would have to perform functional tests that will automatically test all the features of the software.
## Project license
This project is open source.
## Technologies used
• Eclipse: The IDE used
• JUnit: Unit test
• Maven: Dependency Management.
• JSoup: The java based HTML Parser.
## Authors
### Simpara Yaya
### El Mahjoub Abdrahmane
### Konaté Mahamadou Kandé
### Jahoui Hajar
### Jahoui Jihad




