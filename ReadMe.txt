This is a take home test project of informatica. 

#Problem statement :- 
Write a REST service in Java which takes a language as input (e.g. rust, go, coffeescript, …) and provides a JSON output, listing all the projects that are using that language in GitHub
The output must contain only project id, name, url and the owner login
We expect working code to be provided with instructions on how to execute it – either email, upload to GitHub etc.
You may use open source libraries where available
The relevant GitHub API is: https://docs.github.com/en/rest/reference/search#search-repositories


Solution :-  In this application we are consuming GitHubAPI to solve the problem.

To run the application

	$mvn spring-boot:run

To run the application on IDE(IntelliJ/Eclipse)
Import the project as a maven project and edit the run maven configuration.
	goal : spring-boot:run

JDK required 1.8 or above.

Endpoints Details:-

GET http://localhost:8080/search-api/search-projects/{<@PathVariable>}

For example - GET http://localhost:8080/search-api/search-projects/java

we can cross check our response via below
Github api endpoints - https://api.github.com/search/repositories?q=language:jenkins

