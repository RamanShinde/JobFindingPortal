package com.JobFindingPlatform.JobFindingPlatform.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeExchange(auth -> auth
                        // Upload File
                        .pathMatchers(HttpMethod.POST, "/Api/Upload/**").permitAll()
                        // Email
                        .pathMatchers(HttpMethod.POST, "/Api/Email/**").permitAll()
                        // Login and Registration
                        .pathMatchers(HttpMethod.POST, "/User/login", "/User/register").permitAll()
                        // Payment Module
                        .pathMatchers(HttpMethod.POST, "/Api/Payment/process").permitAll()
                        .pathMatchers(HttpMethod.GET, "/Api/Payment/**").permitAll()
                        // Subscription Plan
                        .pathMatchers(HttpMethod.POST, "/Api/SubscriptionPlan/**").permitAll()
                        .pathMatchers(HttpMethod.GET, "/Api/SubscriptionPlan/GetAllPlan", "/Api/SubscriptionPlan/**").permitAll()
                        .pathMatchers(HttpMethod.DELETE, "/Api/SubscriptionPlan/**").permitAll()
                        // JobPost
                        .pathMatchers("/Api/JobPost", "/Api/JobPost/**").permitAll()
                        // Role based
                        .pathMatchers("/Api/Recruiter/**").hasRole("RECRUITER")
                        .pathMatchers("/Api/JobSeeker/**").hasRole("JOBSEEKER")
                        .pathMatchers("/Api/Admin/**").hasRole("ADMIN")
                        .pathMatchers("/api/applications/apply/**").hasRole("JOBSEEKER")
                        .pathMatchers("/api/applications/status/**").hasRole("RECRUITER")
                        .anyExchange().authenticated()
                )
                .httpBasic(httpBasicSpec -> httpBasicSpec.disable()) // Disable basic auth
                .formLogin(form -> form.disable());                  // Disable form login

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService uds,
                                                               PasswordEncoder encoder) {
        DaoAuthenticationProvider prov = new DaoAuthenticationProvider();
        prov.setUserDetailsService(uds);
        prov.setPasswordEncoder(encoder);
        return prov;
    }

//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration cfg) throws Exception {
//        return cfg.getAuthenticationManager();
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
