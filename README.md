# RestfulServices-with-Springboot
Portfolio project to demonstrate application of building Restful services.

API Principles applied: 
- Custom Exception Handling 
- DAO for Database access 
- Resource controllers 
- Resource Models with Data Validation
- XML Support
- Swagger2 Documentation -> GET /swagger-ui/index.html
- Versioning via URI, parameters, headers and content negotitation
- API Monitoring using Hal Browser
- Static/Dynamic data filtering
- Basic User Authentication

User Resources:
- GET /users -> retrieves all users
- POST /users -> creates new user with simple data validation for request body
- GET /users/{user_id} -> get user data
- GET /users/{user_id}/posts -> get user posts
- GET /users/{user_id}/posts/{post_id} -> get user post
- POST /users/{user_id}/posts -> create new post

The User DAO service features:
- retrieve all users
- retrieve user by user_id
- retrieve users posts (all)
- retrieve users post (by post_id)
- delete user
- array as storage for testing purposes

Post DAO Service features:
- retrieve all posts
- create new post
- retrieve posts by user_id
- retrieve post by user_id and post_id


Backlog
- Implement Post Resources
- Update Swagger Documentation with 3.0
