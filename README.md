# JavaTopTools API

A Spring Boot REST API that fetches and serves information about the most popular Java repositories on GitHub. This service provides endpoints to discover trending Java tools and libraries based on GitHub stars and activity.

## 🚀 Features

- Fetch top Java repositories sorted by stars
- REST API with endpoint documentation
- CORS configuration for cross-origin requests
- Built with Spring Boot 3.2.2 and Java 17
- Reactive programming using WebFlux
- Security configuration for safe public access

## 🛠️ Technologies

- Java 17
- Spring Boot 3.2.2
- Spring WebFlux
- Spring Security
- Maven

## 📋 Prerequisites

Before running this project, make sure you have:

- JDK 17 or later installed
- Maven 3.6+ installed
- Git installed
- Your favorite IDE (IntelliJ IDEA recommended)

## 🔧 Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/JavaTopTools_api.git
cd JavaTopTools_api
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The API will be available at http://localhost:8080/api in development mode.
this API is also deployed on Railway at https://javatoptoolsapi-production.up.railway.app/api

🌐 API Endpoints
Get Top Java Repositories

```text
GET /api/repositories
```

Query Parameters

page (optional): Page number (default: 1)
per_page (optional): Repositories per page (default: 30)

🔒 Security
The API implements Spring Security with CORS configuration to allow requests from specified origins. The security configuration allows public access to the API endpoints while protecting against common web vulnerabilities.


👥 Authors

[Nilsw13](https://github.com/nilsw13)

📌 Acknowledgments

Thanks to GitHub for providing their API
Spring Boot team for the amazing framework

👉 Liens
[Front-end repository](https://github.com/nilsw13/JavaTopTools_front)