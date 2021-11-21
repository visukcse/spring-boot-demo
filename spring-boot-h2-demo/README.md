# spring-boot-h2-demo
	Demo project of spring boot with fly way migration with h2 database.
	
# Requirements
	Java 1.8
	Spring boot 2.5.6

# Fly way migration
/spring-boot-h2-demo/src/main/resources/db/migration has two scripts

	First script creates 'H2ENTITY' table 
	Second script creates three records in 

# How to access DB
	http://localhost:8080/h2-console/

# How to consume
	GET http://localhost:8080/employee/
	GET http://localhost:8080/employee/1

	POST http://localhost:8080/employee/more
	[
		{
		"designation": "Student",
		"firstName": "Latha",
		"lastName": "K"
		},
		{
		"designation": "Professor",
		"firstName": "Jaya",
		"lastName": "K"
		}
	]

	POST http://localhost:8080/employee/
	{
	    "designation": "MD",
	    "firstName": "Krishnan",
	    "lastName": "P"
	}


