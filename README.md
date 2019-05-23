# rest-api-money-transfer
Simple REST API app transfering money between accounts. Done as a standalone JAR file. 

# Technologies
**Java** - The core program

**Jersey** - The framework implementing javax.ws.rs for the REST API

**Jetty** - Creating and embedded server

**Jackson** - Handling the JSON conversions

**JUnit** - Automated Tests

**Maven** - Managing dependencies, building the project, and runing the streak of "J's". :)

# How it works?

The Application is very simple. It only has 3 endopints:
http://localhost:8080/bank/test -- to test if it works. It return a String "Test"

http://localhost:8080/bank/get-balance/{id} -- to get the balance of an acocunt of id. It returns a ResponseObject, which will contain the account balance if the account exists and a boolean false if no such account exists.

http://localhost:8080/bank/transfer -- to transfer money between two accounts. Fill return a JSON containing true or false depending on if the transfer succeeded or failed.

The application has an **in-memory database** with 6 accounts that can be used to manually test the transfers (automated test of the classes are also included). Their numbers and balances are: `{1, 500.0}, {2, 5000.0}, {3, 0.0}, {4, 10.0}, {5, 2000.0}, {6, 1000.0}`. 

You can use Postman or any other client tool to play around with the app. The first two endpoints are simple GET methods and just use the url. They respond with jsons that look like this:

`{
    "balance": 100
}`

`{
    "status": false
}`

The third one however needs a request body with application/json. It's method should be POST. The format of the json should be as follows:

`{
	"senderId": 1,
	"recipientId": 2,
	"ammount": 400
}`

After the transfer you can use `/get-balance/{id}` to check the change in the accounts balance.

# Running the application
In the command line go to the project directory, to the "target" folder. When inside it type java `java -jar rest-api-money-transfer-1.0.jar`, and the app will run. You need the Java Runtime Environemtn of verions at least 8. :)
