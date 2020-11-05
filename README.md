# RestfulServices-with-Springboot
Portfolio project to demonstrate application of building Restful services.

## API Features: 
- Custom Exception Handling 
- DAO Services for Database access
- Resource controllers 
- Resource Models with Data Validation
- JSON/XML Support
- Swagger2 Documentation -> GET /swagger-ui/index.html
- Versioning via URI, parameters, headers and content negotitation
- API Monitoring using Hal Browser
- Static/Dynamic data filtering
- Basic User Authentication
- H2 Database with JPA to retrieve information 

## User Resources:
- GET /users -> retrieves all users from UserDaoService
- POST /users -> creates new user with simple data validation for request body from UserDaoService
- GET /users/{user_id} -> get user data from UserDaoService
- GET /users/{user_id}/posts -> get user posts from UserDaoService
- GET /users/{user_id}/posts/{post_id} -> get user post from UserDaoService
- POST /users/{user_id}/posts -> create new post from UserDaoService
- GET /jpa/users -> retrieves all users from H2 Database
- POST /jpa/users -> creates new user with simple data validation for request body from H2 Database
- GET /jpa/users/{user_id} -> get user data from H2 Database
- GET /jpa/users/{user_id}/posts -> get user posts from H2 Database
- GET /jpa/users/{user_id}/posts/{post_id} -> get user post from H2 Database
- POST /jpa/users/{user_id}/posts -> create new post from H2 Database



## Backlog
- Implement Post Resources
- Update Swagger Documentation with 3.0
- Add Exception handling to JPA Endpoints
- Add Validation for JPA Endpoints