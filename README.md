# Forum Project API

A simple REST API for managing topics.
Built with **Spring Boot** and secured with **JWT authentication**.

---

## Server

Local development server:

```
http://localhost:8080
```

---

## Authentication

This API uses **JWT token authentication**.

1. Send credentials to the login endpoint.
2. The API returns a **JWT token**.
3. Use this token in the `Authorization` header for protected requests.

Example header:

```
Authorization: Bearer <your_token>
```

---

## Endpoints

### Login

**POST** `/v1/login`

Authenticates a user and returns a JWT token.

---

### Topics

**GET** `/v1/topic/`
Returns a list of topics.

**GET** `/v1/topic/{id}`
Returns a specific topic by ID.

**POST** `/v1/topic/`
Creates a new topic.

**PUT** `/v1/topic/{id}`
Updates an existing topic.

**DELETE** `/v1/topic/{id}`
Deletes a topic.

---

## Error Handling

The API includes global error handling for common cases, such as:

* **404 Not Found** – when a topic does not exist.
* **401 Unauthorized** – when authentication fails.
* **500 Internal Server Error** – for unexpected errors.

Error responses are returned in JSON format, for example:

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "Topic not found.",
  "path": "/v1/topic/1",
  "timestamp": "2026-03-07T21:09:45"
}
```

---

## API Documentation

Interactive documentation is available through **Swagger UI** when the application is running.

Typical URL:

```
http://localhost:8080/swagger-ui.html
```

---

## Technologies

* Spring Boot
* Spring Security
* JWT Authentication
* JPA / Hibernate
* Maven
* Swagger (OpenAPI)
