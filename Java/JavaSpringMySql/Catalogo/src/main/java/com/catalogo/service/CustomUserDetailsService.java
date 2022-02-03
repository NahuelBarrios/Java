package com.catalogo.service;

import com.catalogo.entities.Rol;
import com.catalogo.entities.User;
import com.catalogo.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;



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
        
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(()->
                new UsernameNotFoundException("User no encontrado con nombre de usuario o correo: " + usernameOrEmail));        
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities (Set<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNameRol())).collect(Collectors.toList());
    }
}
