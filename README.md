NOTE: The current solution is only compatible with Windows
REQUIREMENTS: JDK 8, Maven - version 3.3.1 or higher.
EXECUTION: 
1. Clone the repository
2. Open terminal in the local path where you have cloned the repository  
3. Write mvn test in the terminal

Phase 2 of this solution would contain: 
- restructure of the code so each feature could be executed separately
- getting some variables like chromedriver, and timeouts in a separate properties class
- making a parent class that includes shared metodes @Before and @After that should be applied for every scenario
- support for OS.