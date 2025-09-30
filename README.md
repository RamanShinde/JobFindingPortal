A scalable, microservices-based job platform built with Spring Boot, Spring Cloud Gateway, Eureka Server, JWT Security, and MySQL. Designed to connect job seekers and recruiters with secure authentication, dynamic routing, and cloud integrations.

+-------------------+       +-------------------+
|   Eureka Server   |<----->|   Microservices   |
|   (Service Reg.)  |       | (Auth, JobPost,   |
|   Port: 8761      |       |  Recruiter, etc.) |
+-------------------+       +-------------------+
         ↑
         |
         ↓
+-------------------+
|  API Gateway      |
|  (Routing Layer)  |
|  Port: 8081       |
+-------------------+
         ↓
+-------------------+
|  Frontend (TBD)   |
+-------------------+


Technology Used:-
- Backend: Java, Spring Boot, Spring Security, Spring Cloud Gateway
- Service Discovery: Eureka Server
- Database: MySQL
- Email: Gmail SMTP
- Cloud Storage: Cloudinary
- Payments: Razorpay
- Containerization: Docker (optional)
- IDE: IntelliJ, VS Code


How to Run :-
step 1:- Start Eureka Server
Step 2:- Start Monolithic Gateway App
Step 3:- Run all Rest-Api on postman
Note:-
Before run create a databse  in the mysql then link to the spring applicarion through application.proerties.

JobFindingPortal/
├── eureka-server/
│   └── src/
├── job-finding-platform/
│   └── src/
├── README.md
└── .gitignore

