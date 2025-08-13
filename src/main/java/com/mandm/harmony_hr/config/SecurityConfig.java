package com.mandm.harmony_hr.config;

import com.mandm.harmony_hr.authentication.JwtAuthEntryPoint;
import com.mandm.harmony_hr.authentication.JwtAuthFilter;
import com.mandm.harmony_hr.services.SecurityUsersDetailsService;
import com.mandm.harmony_hr.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    private final SecurityUsersDetailsService securityUsersDetailsService;
    private final JwtAuthEntryPoint unauthorizedHandler;

    @Autowired
    private JwtUtils jwtUtils;

    public SecurityConfig(SecurityUsersDetailsService securityUsersDetailsService, JwtAuthEntryPoint unauthorizedHandler) {
        this.securityUsersDetailsService = securityUsersDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
    }

    @Bean
    public JwtAuthFilter jwtAuthenticationFilter(JwtUtils jwtUtils, SecurityUsersDetailsService securityUsersDetailsService) {
        return new JwtAuthFilter(jwtUtils, securityUsersDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(securityUsersDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configure(http))
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/test/**").permitAll()
                        .anyRequest().authenticated()
                ).addFilterBefore(
                        jwtAuthenticationFilter(jwtUtils, securityUsersDetailsService),  // Pass dependencies directly
                        UsernamePasswordAuthenticationFilter.class
                );



        return http.build();
    }


}
