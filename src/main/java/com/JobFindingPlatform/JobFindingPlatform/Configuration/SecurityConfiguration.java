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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
//                               // Login and Regiteration
                                .requestMatchers(HttpMethod.POST, "/User/login", "/User/register").permitAll()
                                .requestMatchers("Api/JobPost", "Api/JobPost/**").permitAll()
                                // Role Based access
                                .requestMatchers("Api/Recruiter/**").hasRole("RECRUITER")
                                .requestMatchers("Api/JobSeeker/**").hasRole("JOBSEEKER")
                                .requestMatchers("Api/Admin/**").hasRole("ADMIN")
                                .requestMatchers("/api/applications/apply/**").hasRole("JOBSEEKER")
                                .requestMatchers("/api/applications/status/**").hasRole("RECRUITER")
                                .anyRequest().authenticated()
                ).sessionManagement((sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))
                .httpBasic(Customizer.withDefaults());
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

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration cfg) throws Exception {
        return cfg.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
