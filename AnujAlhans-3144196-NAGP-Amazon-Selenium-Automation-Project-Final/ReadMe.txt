1) Copy the project from shared location, Unzip it and Import the project into your Eclipse IDE.
2) By Default 'chrome' browser is present inside config.properties file present inside src/main/java/com.nagp.amazon.config
   Note: Change the browser values to 'FF' or 'IE' in the config.properties file, if required.
3) To Run the project, there are 2 options - 
   a) Using TestNG in Eclipse IDE :-
	   i) Find testng.xml file inside the project workspace.
	  ii) Right click on it and Run as TestNG Suite.
	 iii) Once the execution is completed, Extent Report is generated inside "Current Test Results" folder
	  iv) All failed Test Cases screenshots are stored inside folder "FailedTestCasesScreenshots"
	
	b) Using Command Line :-
	   i) Open command Prompt
	  ii) Change the directory to the Project location
	 iii) Run mvn clean test command to run the automation suite.
	  iv) Once the execution is completed, Extent Report is generated inside "Current Test Results" folder
	   v) All failed Test Cases screenshots are stored inside folder "FailedTestCasesScreenshots"
