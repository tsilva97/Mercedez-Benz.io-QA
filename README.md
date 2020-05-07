# Mercedez-Benz.io-QA
QA Engineer Technical Challenge - Task 2

# Usage
The test automation tool is usable through a CLI where the allowed commands are explained, each workflow will output a new test in Extent Reports which will be available when the tool is closed. This project was developed and tested on Windows 10 and supports Chrome 81 and Firefox 75.0. 

# Extending the project
The project is extensible to support other browsers and more workflows. To add new browsers please modify the Setup class and add the new option to the MainCLI and Messages class. To add a new workflow create a new method in the Master class and build the workflow, the two existing workflows provide a good example of how to do this. To use new elements to be tested or new data to use as input please add it to the elements.data and to the data.data files maintaining the correct format. 
