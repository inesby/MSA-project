# Forum Web Application

This project was done by 
###### Ines Ben Youssef 
###### Seif eddine Skini

## Getting Started

**We have developed this web application using Microservice Architecture. So we have dived the project into 5 sub projects:**

- **User Microservice:** Responsible for all operations that includes users.

- **Post Microservice:** Responsible for all operations that includes posts.

- **Comment Microsevrice:** Responsible for all operations that includes comments.

- **ForumUI Microsevice:** Responsible for all operations of displaying the forums through connsoming the other microservices.

- **Config Microservice:** Responsible for all operations that includes all the configurations of all these microservices.

**You can find the documentation of every micro service in a readme in the microservice directory**


## User Microservice EndPoints

| Path | Type | Function |
| --- | --- | --- |
| /Users | GET | List all users |
| /Users{id} | GET| List users by their id |
| /Users/age/{ageLimit} | GET| List users with age greater than ageLimit |
| /Users/names/{recherche} | GET| List users with specific names |
| /Users | PUT| Creates a new user |
| /Users | POST | Creates a new user |
| /Users/{id} | DELETE | deletes a user by their id |

**The application is running on port 9091**

## Post Microservice EndPoints

| Path | Type | Function |
| --- | --- | --- |
| /Posts | GET | List all posts |
| /Posts/{id} | GET| List posts by their writer id |
| /Posts/keywords/{recherche} | GET| List posts with specific keywords |
| /Posts | PUT| Creates a new post |
| /Posts | POST | Creates a new post |
| /Posts/{id} | DELETE | deletes a post by its id |

**The application is running on port 9092**

## Post Microservice EndPoints

| Path | Type | Function |
| --- | --- | --- |
| /Comments | GET | List all comments |
| /Comments/posts/{id} | GET| List comments by their post id |
| /Comments/{id} | GET| List comments by their id |
| /Comments/keywords/{recherche} | GET| List comments with specific keywords |
| /Comments | PUT| Creates a new comment |
| /Comments | POST | Creates a new comment |
| /Comments/{id} | DELETE | deletes a comment by its id |

**The application is running on port 9093**


## ForumUI Microservice EndPoints

| Path | Type | Function |
| --- | --- | --- |
| / | GET | displays the main forum page : Users and  Posts  |
| /details-post/{id} | GET | displays the comments for the post with id : id |

**The application is running on port 9094**




