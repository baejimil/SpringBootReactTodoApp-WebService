package com.baejimeel.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                auth -> auth.anyRequest().authenticated()
//                );
//        http.httpBasic(Customizer.withDefaults());
//
//        http.sessionManagement(
//                session -> session.sessionCreationPolicy
//                        (SessionCreationPolicy.STATELESS));
//
//        http.csrf().disable();
//
//        return http.build();
//        위의 코드를 아래와 같이 사용함
        return
                http
                        .authorizeHttpRequests(
                                auth -> auth
                                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                        .anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults())
                        .sessionManagement(session -> session.sessionCreationPolicy
                                (SessionCreationPolicy.STATELESS))
                        .csrf().disable()
                        .build();
    }
}
