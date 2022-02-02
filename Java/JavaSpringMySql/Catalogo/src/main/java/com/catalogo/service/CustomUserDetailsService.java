package com.catalogo.service;

import com.catalogo.entities.User;
import com.catalogo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    public CustomUserDetailsService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail);
        
        
    }
    
}
