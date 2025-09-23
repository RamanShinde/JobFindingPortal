package com.JobFindingPlatform.JobFindingPlatform.Security;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfiguration {
   private JWTAuthenticationFilter jwtFilter;

   public RouteLocator routes(RouteLocatorBuilder builder){
       return builder.routes()
               // auth service
               .route("auth-service",r->r.path("/api/auth/**")
               .uri("http://localhost:7778"))
               // jobseeker service
               .route("jobseeker-service",r->r.path("/api/job_seekers/**")
                       .filters(f-> f.filter(jwtFilter))
                       .uri("http://localhost:7779"))
               // recruiter service
               .route("recruiter-service",r->r.path("/api/recruiters/**")
                       .filters(f->f.filter(jwtFilter))
                       .uri("http://localhost:7779"))
               // Jobpost service -
               .route("jobPost-service", r -> r.path("/api/jobPosts/**")
                       .filters(f -> f.filter(jwtFilter))
                       .uri("http://localhost:7781"))

               // Application service - JWT required
               .route("application-service", r -> r.path("/api/applications/**")
                       .filters(f -> f.filter(jwtFilter))
                       .uri("http://localhost:7782"))

               // Admin service - JWT required
               .route("admin-service", r -> r.path("/api/admins/**")
                       .filters(f -> f.filter(jwtFilter))
                       .uri("http://localhost:7783"))

               // Email service - JWT required
               .route("email-service", r -> r.path("/api/notification/**")
                       .filters(f -> f.filter(jwtFilter))
                       .uri("http://localhost:7784"))

               // File Upload service - JWT required
               .route("fileUpload-service", r -> r.path("/api/upload/**")
                       .filters(f -> f.filter(jwtFilter))
                       .uri("http://localhost:7785"))

               // Payment service - JWT required
               .route("payment-service", r -> r.path("/api/payment/**")
                       .filters(f -> f.filter(jwtFilter))
                       .uri("http://localhost:7786"))

               // Dashboard service - JWT required
               .route("dashboard-service", r -> r.path("/api/dashBoards/**")
                       .filters(f -> f.filter(jwtFilter))
                       .uri("http://localhost:7787"))

               .build();

   }
}
