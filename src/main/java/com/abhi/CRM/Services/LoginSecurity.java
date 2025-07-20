//package com.abhi.CRM.Services;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class LoginSecurity {
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests(authz -> authz
////                        .requestMatchers("/loginPageStyle.css", "/css/**", "/js/**",
////                                "/images/**", "/register", "/createNewLogin",
////                                "/forgetPassword", "/loginPage").permitAll()
////                        .anyRequest().authenticated()
////                )
////                .formLogin((form) -> form
////                        .loginPage("/loginPage")   // Your custom login page URL
////                        .permitAll()
////                )
////                .logout((logout) -> logout
////                        .logoutUrl("/logout")
////                        .logoutSuccessUrl("/loginPage?logout")  // After logout, redirect here
////                        .permitAll()
////                );
////
////        return http.build();
////    }
////
////    @Bean
////    public InMemoryUserDetailsManager userDetailsService() {
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("Admin")
////                .password("Admin123")
////                .roles("ADMIN")
////                .build();
////        return new InMemoryUserDetailsManager(admin);
////    }
//}
