# spring--boot-angular-master

This branch contains a funlly functional web application that provides the following functionality

  - Create a new company
  - Get a list of all companies
  - Able to update a company
  - Able to add beneficial owner(s) of the company

Following are the technology stack that is used

  - Spring Boot
  - Spring Data Rest
  - AngularJS
  - BootStrap.

Application has been deployed to heroku and can be accessed using https://shrouded-sands-96456.herokuapp.com/.

Following are the list of services available

- Service to Get a List of Companies
```sh          
https://shrouded-sands-96456.herokuapp.com/companies -- Get Request
```
- To Create a New Company

```sh          
https://shrouded-sands-96456.herokuapp.com/companies -- POST  Request

Json to be used is

{"name":"Company1","address":"LandMark1, Location1","city":"City1","country":"India","email":"test@test.com","phoneNumber":"123","owners":[{"name":"Arun"}]}
```

### TO DO

- Implement Security. Following is the intended approach.

    - Using HTTP Basic, validate the username and password.
    - If authenticated, generate a unique encoded token that is added to the request header as X_AUTH_TOKEN. The token will be based on a user name and expiry time and can be encrypted using HMAC API in Java.
    - All subsequent API requests must be made by the client with the X_AUTH_TOKEN available in request header thus making the api stateless.







