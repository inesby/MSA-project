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


## User Microservice EndPoint

| Path | Type | Function |
| --- | --- | --- |
| /Users | GET | List all users |
| /Users{id} | GET| List users by their id |
| /Users/age/{ageLimit} | GET| List users with age greater than ageLimit |
| /Users/names/{recherche} | GET| List users with specific names |
| /Users | PUT| Creates a new user |
| /Users| POST | Creates a new user |




