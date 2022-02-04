package com.virtusa.login;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Logindetails implements UserDetailsService{
PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.springframework.security.core.userdetails.UserDetails user = User.builder().username("root")
				.password(encoder.encode("password"))
				.authorities("ROOT").build();
		if(user.getUsername().equals(username)) {
			return user;
		}
		
		throw new UsernameNotFoundException("user not found");
	}


}
