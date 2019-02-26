Building the code:
1.	Maven is required to build the code.
2.	The summaryreport folder is a Maven project that can be built using “mvn clean install”.
3.	Upon successful completion of build, the target folder will have the following 2 jar files:
a.	summaryreport-0.0.1-SNAPSHOT.jar – Executable jar of the code
b.	summaryreport-0.0.1-SNAPSHOT-jar-with-dependencies.jar – Executable jar of the code with dependencies packaged.

Using the software:
1.	The code should be executed by running “java -jar summaryreport-0.0.1-SNAPSHOT-jar-with-dependencies.jar”.
2.	JRE 8 is required to run the code.
3.	The program asks the user for 3 inputs:
 
  a.	Path to input file – The complete path on the filesystem to the input file containing future transactions. Hitting Enter without providing input will pick the “Input.txt” file sent in the coding challenge.
  b.	Path to output file – The complete path on the filesystem to the output file. As per requirements, contents will be dumped in CSV format.
  c.	Date for summary report generation – Records with this transaction date will be considered for summary report generation. The Input.txt file provided has records only for 20th August 2010 and 19th August 2010.
4.	The output file will be placed in location specified in 3.b, and can be opened after the program terminates.

Troubleshooting:
The application generates a log file in the same folder as the jar file, by the name logging.log. This can be used for trying to pinpoint any issues found. Developers can import the attached source code in Eclipse as a project and execute from the main class com.abnamro.futuretransactions.report.App. Eclipse can then be used for debugging.
