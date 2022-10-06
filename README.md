## JSON RESTFUL API
### WhoKnows Backend API Specification

## Authentication
All API must have `X-Api-Key`

### API Key
Request:
- Header:
    - X-Api-Key: "The secret api key"

### Sign In User
Request:
- Method: POST
- Endpoint: `/api/auth/sign-in`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
    "email": "String",
    "password": "String"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "userId": "String, Unique",
    "fullName": "String",
    "email": "String",
    "phone": "String",
    "username": "String",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```

## User
### CREATE User
Request:
- Method: POST
- Endpoint: `/api/users`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "userId": "String, Unique",
  "fullName": "String",
  "email": "String",
  "phone": "String",
  "username": "String",
  "password": "String"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "userId": "String, Unique",
    "fullName": "String",
    "email": "String",
    "phone": "String",
    "username": "String",
    "createdAt": "Date",
    "updatedAt":"Date"
  }
}
```
### READ User
Request:
- Method: GET
- Endpoint: `/api/users/{userId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "userId": "String, Unique",
    "fullName": "String",
    "email": "String",
    "phone": "String",
    "username": "String",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```
### Update User
Request:
- Method: PUT
- Endpoint: `/api/users/{userId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "fullName": "String",
  "email": "String",
  "phone": "String",
  "username": "String",
  "password": "String"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "userId": "String, Unique",
    "fullName": "String",
    "email": "String",
    "phone": "String",
    "username": "String",
    "password": "String",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```
### Delete User
Request:
- Method: DELETE
- Endpoint: `/api/users/{userId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String"
}
```
### List Users
Request:
- Method: GET
- Endpoint: `/api/users`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json
- Query Param:
    - size: Number,
    - page: Number

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": [
    {
      "userId": "String, Unique",
      "fullName": "String",
      "email": "String",
      "phone": "String",
      "username": "String",
      "createdAt": "Date",
      "updatedAt": "Date",
      "room": ["Room"]
    }
  ]
}
```

## Room
### CREATE Room
Request:
- Method: POST
- Endpoint: `/api/rooms`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "roomId": "String, Unique",
  "userId": "String, Unique",
  "minute": "Number",
  "title": "String",
  "description": "String",
  "expired": "Boolean"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "roomId": "String, Unique",
    "userId": "String, Unique",
    "minute": "Number",
    "title": "String",
    "description": "String",
    "expired": "Boolean",
    "createdAt": "Date",
    "updatedAt": "Date",
    "questions": ["Quiz"],
    "participants": ["Participant"]
  }
}
```
### READ Room
Request:
- Method: GET
- Endpoint: `/api/user/{roomId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "roomId": "String, Unique",
    "userId": "String, Unique",
    "minute": "Number",
    "title": "String",
    "description": "String",
    "expired": "Boolean",
    "createdAt": "Date",
    "updatedAt": "Date",
    "questions": ["Quiz"],
    "participants": ["Participant"]
  }
}
```
### Update Room
Request:
- Method: PUT
- Endpoint: `/api/room/{roomId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "minute": "Number",
  "title": "String",
  "description": "String",
  "expired": "Boolean"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "roomId": "String, Unique",
    "userId": "String, Unique",
    "minute": "Number",
    "title": "String",
    "description": "String",
    "expired": "Boolean",
    "createdAt": "Date",
    "updatedAt": "Date",
    "questions": ["Quiz"],
    "participants": ["Participant"]
  }
}
```
### Delete Room
Request:
- Method: DELETE
- Endpoint: `/api/room/{roomId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json
      Response:
```json
{
  "code": "Number",
  "status": "String"
}
```
### List Rooms
Request:
- Method: GET
- Endpoint: `/api/rooms`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json
- Params:
    - size: Number,
    - page: Number

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": [
    {
      "roomId": "String, Unique",
      "userId": "String, Unique",
      "minute": "Number",
      "title": "String",
      "description": "String",
      "expired": "Boolean",
      "createdAt": "Date",
      "updatedAt": "Date",
      "questions": ["Quiz"],
      "participants": ["Participant"]
    }
  ]
}
```

## Quiz
### CREATE Quiz
Request:
- Method: POST
- Endpoint: `/api/questions`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "quizId": "String, Unique",
  "roomId": "String, Unique",
  "images": ["String"],
  "question": "String",
  "options": ["String"],
  "answer": "String",
  "createdBy": "String"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "quizId": "String, Unique",
    "roomId": "String, Unique",
    "images": ["String"],
    "question": "String",
    "options": ["String"],
    "answer": "String",
    "createdBy": "String",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```
### READ Quiz
Request:
- Method: GET
- Endpoint: `/api/quiz/{quizId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "quizId": "String, Unique",
    "roomId": "String, Unique",
    "images": ["String"],
    "question": "String",
    "options": ["String"],
    "answer": "String",
    "createdBy": "String",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```
### Update Quiz
Request:
- Method: PUT
- Endpoint: `/api/quiz/{quizId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "images": ["String"],
  "question": "String",
  "options": ["String"],
  "answer": "String"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "quizId": "String, Unique",
    "roomId": "String, Unique",
    "images": ["String"],
    "question": "String",
    "options": ["String"],
    "answer": "String",
    "createdBy": "String",
    "createdAt": "Date",
    "updatedAt": "Date"
  }
}
```
### Delete Quiz
Request:
- Method: DELETE
- Endpoint: `/api/quiz/{quizId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String"
}
```
### List Questions
Request:
- Method: GET
- Endpoint: `/api/questions`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json
- Query Param:
    - size: Number,
    - page: Number

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": [
    {
      "quizId": "String, Unique",
      "roomId": "String, Unique",
      "images": ["String"],
      "question": "String",
      "options": ["String"],
      "answer": "String",
      "createdBy": "String",
      "createdAt": "Date",
      "updatedAt": "Date"
    }
  ]
}
```

## Participant
### CREATE Participant
Request:
- Method: POST
- Endpoint: `/api/participants`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "participantId": "String, Unique",
  "roomId": "String",
  "userId": "String",
  "currentPage": "String",
  "timeLeft": "Number",
  "expired": "Boolean"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "participantId": "String, Unique",
    "roomId": "String",
    "userId": "String",
    "currentPage": "String",
    "timeLeft": "Number",
    "expired": "Boolean",
    "createdAt": "Date",
    "updatedAt":"Date",
    "result": "Result"
  }
}
```
### READ Participant
Request:
- Method: GET
- Endpoint: `/api/participant/{participantId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "participantId": "String, Unique",
    "roomId": "String",
    "userId": "String",
    "currentPage": "String",
    "timeLeft": "Number",
    "expired": "Boolean",
    "createdAt": "Date",
    "updatedAt": "Date",
    "result": ["Result"]
  }
}
```
### Update Participant
Request:
- Method: PUT
- Endpoint: `/api/participant/{participantId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "currentPage": "String",
  "timeLeft": "Number",
  "expired": "Boolean"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "participantId": "String, Unique",
    "roomId": "String",
    "userId": "String",
    "currentPage": "String",
    "timeLeft": "Number",
    "expired": "Boolean",
    "result": ["Result"]
  }
}
```
### Delete Participant
Request:
- Method: DELETE
- Endpoint: `/api/participant/{participantId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String"
}
```
### List Participant
Request:
- Method: GET
- Endpoint: `/api/participants`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json
- Query Param:
    - size: Number,
    - page: Number

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": [
    {
      "participantId": "String, Unique",
      "roomId": "String",
      "userId": "String",
      "currentPage": "String",
      "timeLeft": "Number",
      "expired": "Boolean",
      "createdAt": "Date",
      "updatedAt": "Date",
      "result": ["Result"]
    }
  ]
}
```

## Result
### CREATE Result
Request:
- Method: POST
- Endpoint: `/api/results`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "resultId": "String, Unique",
  "participantId": "String",
  "roomId": "String",
  "userId": "String",
  "correctQuiz": ["String"],
  "wrongQuiz": ["String"],
  "score": "Number"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "resultId": "String, Unique",
    "roomId": "String",
    "userId": "String",
    "correctQuiz": ["String"],
    "wrongQuiz": ["String"],
    "score": "Number",
    "createdAt": "Date",
    "updatedAt":"Date"
  }
}
```
### READ Result
Request:
- Method: GET
- Endpoint: `/api/result/{resultId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "resultId": "String, Unique",
    "participantId": "String",
    "roomId": "String",
    "userId": "String",
    "correctQuiz": ["String"],
    "wrongQuiz": ["String"],
    "score": "Number",
    "createdAt": "Date",
    "updatedAt":"Date"
  }
}
```
### Update Result
Request:
- Method: PUT
- Endpoint: `/api/user/{userId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Content-Type: application/json
    - Accept: application/json
- Body:
```json
{
  "correctQuiz": ["String"],
  "wrongQuiz": ["String"],
  "score": "Number"
}
```
Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": {
    "resultId": "String, Unique",
    "participantId": "String",
    "roomId": "String",
    "userId": "String",
    "correctQuiz": ["String"],
    "wrongQuiz": ["String"],
    "score": "Number",
    "createdAt": "Date",
    "updatedAt":"Date"
  }
}
```
### Delete Result
Request:
- Method: DELETE
- Endpoint: `/api/result/{resultId}`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json

Response:
```json
{
  "code": "Number",
  "status": "String"
}
```
### List Result
Request:
- Method: GET
- Endpoint: `/api/results`
- Header:
    - X-Api-Key: "The secret api key"
    - Accept: application/json
- Query Param:
    - size: Number,
    - page: Number

Response:
```json
{
  "code": "Number",
  "status": "String",
  "data": [
    {
      "resultId": "String, Unique",
      "participantId": "String",
      "roomId": "String",
      "userId": "String",
      "correctQuiz": ["String"],
      "wrongQuiz": ["String"],
      "score": "Number",
      "createdAt": "Date",
      "updatedAt":"Date"
    }
  ]
}
```
