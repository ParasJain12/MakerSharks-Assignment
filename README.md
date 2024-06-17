# User Registration and Fetch API

This is a simple Spring Boot application that provides RESTful endpoints for user registration and fetching user details. The application uses basic authentication to protect the user details endpoint.

## Features

- **User Registration**: Allows new users to register with a username, email, and password.
- **Fetch User Details**: Allows fetching user details by username with basic authentication.

## Endpoints

1. **Register User**
   - **URL**: `/api/user/register`
   - **Method**: `POST`
   - **Request Body**: 
     ```json
     {
       "username": "paras",
       "email": "paras@example.com",
       "password": "jain"
     }
     ```
   - **Response**:
     - `201 Created` on successful registration.
     - `409 Conflict` if the user already exists.

2. **Fetch User Details**
   - **URL**: `/api/user/fetch`
   - **Method**: `GET`
   - **Query Parameter**: `username`
   - **Authorization**: Basic Auth
   - **Response**:
     - `200 OK` with user details (excluding password) on success.
     - `404 Not Found` if the user does not exist.
     - `401 Unauthorized` if authentication fails.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Running the Application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/user-registration-fetch-api.git
   cd user-registration-fetch-api
2. **Build the Application**
   mvn clean install
3. **Run the application**
   mvn spring-boot:run

The application will start and be accessible at http://localhost:8080.

**Testing with Postman**
Register a User:

Method: POST
URL: http://localhost:8080/api/user/register
Body: (Select raw and JSON)
json
Copy code
{
  "username": "paras",
  "email": "paras@example.com",
  "password": "jain"
}
Fetch User Details:

Method: GET
URL: http://localhost:8080/api/user/fetch?username=paras
Authorization: Select Basic Auth and enter the following credentials:
Username: user
Password: password
