package com.basics.springsecurity.services;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDetails implements UserDetailsService {
    public PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.UserDetails user = User.withUsername("root")
                .password(encoder.encode("{noop}password"))
                .authorities("USER").build();
        if(user.getUsername().equals(username)) {
            return user;
        }

        throw new UsernameNotFoundException("user not found");
    }
}
