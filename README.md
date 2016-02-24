## Introduction

This utility class provides word count of the given text file. This specific style of word counter will be used in various contexts and must conform the below specification:
- Boundried by any type of whitespace
- Valid English words including all contraction and possessives
- Words with valid punctuation marks
- All other UTF-8 characters are ignored

The class takes input filename as String. User can select file from a location and output is given on console. There is also utility class which takes file name as input. File must be copied to c:/temp/ directory first.

This project is built using Java 1.8.0_73 and JUnit4.

## How to run the project
Download the Project zip file and unzip it.
You can import this project in Eclipse IDE using following steps:
File -> Import -> General -> Existing project into Workspace -> Next
Browse the project folder by selecting root directory -> Next -> Finish
Run the project by right click on project -> Run As -> Java Application
User can select the input text file and get the output of word count on console.

## Tests

Based on the requirement specification, the following test scenario have been covered in unit testing the utility:

1. Input file is missing or not found. 
2. File format is invalid (other than .txt)
3. Positive test cases
4. Test for word contraction (E.g. You shouldn't come here)
5. Test for word possessives
6. Test for valid punctuation marks
7. Test for other UTF-8 characters
8. Test for numbers
9. Test for numbers with colon
10. Empty file
11. Word count should not take more then 100ms.

The above criteria is sufficient for testing a small (several Mbs) in size. Hadoop/MapReduce can be used to calculate word count for big (Tbs) files.

This also can achieve same by reading big file in to small chunk and creating multiple thread and sum up count from each thread (map/reduce is build on same basic and has more control on how many map or reduced we can create and number of node we can control).

You can find com.junit package in the project and find junit test cases in WordCounterTest.java
You can run it by selecting the project -> right click -> run as -> JUnit Test
Input files for test can be found in /testcases folder. Make sure to create "temp" folder in C:\ and copy all input file there in order to run JUnit. All the tests have passed.

##Additional Testing

I would consider performance and load testing beyond unit testing. I will also make sure that code coverage is above 98%. 

## Usage

This jar can be used in any java application. To use this helper function one can use below code.

Make sure that input file is present in "C:\temp\" folder.
int count = WordCounter.wordCountHelper(<filename>);

##Time Spent

I spent approximately 4 hours in creating the entire project with test plan and test cases.# WordCounterApp 
