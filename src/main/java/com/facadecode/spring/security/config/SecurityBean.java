package com.facadecode.spring.security.config;

import com.facadecode.spring.security.service.DbUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityBean {
    @Autowired
    private DbUserDetailsService dbUserDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(dbUserDetailsService.getAllUserDetails());
    }
}
