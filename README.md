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


**You can find the documentation of every micro service in this readme**


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

## Comment Microservice EndPoints

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

![Capture1](https://user-images.githubusercontent.com/40526410/74184266-c5500980-4c46-11ea-8bee-66f2987082a0.JPG)

![Capture2](https://user-images.githubusercontent.com/40526410/74184464-21b32900-4c47-11ea-998c-cff6ed87896a.JPG)

![Capture3](https://user-images.githubusercontent.com/40526410/74184500-3099db80-4c47-11ea-861a-2c671f550a9a.JPG)

![Capture4](https://user-images.githubusercontent.com/40526410/74184534-40b1bb00-4c47-11ea-8017-05dd13354759.JPG)

![Capture5](https://user-images.githubusercontent.com/40526410/74184573-4effd700-4c47-11ea-8da7-a54c1b76d308.JPG)

![Capture6](https://user-images.githubusercontent.com/40526410/74184616-60e17a00-4c47-11ea-942a-900c40da08f3.JPG)

