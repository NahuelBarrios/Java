package com.catalogo.service;

import com.catalogo.entities.UsersLog;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsersLongServicio {
 
    
    public UserDetails getUserAsUserDetail(UsersLog usuario) {
    UserDetails uDetails;

    uDetails = new User(usuario.getUsername(), usuario.getPassword(), getAuthorities(usuario));

    return uDetails;
  }

  // Usamos el tipo de datos SET solo para usar otro diferente a List private
  Set<? extends GrantedAuthority> getAuthorities(UsersLog usuario) {

    Set<SimpleGrantedAuthority> authorities = new HashSet<>();

    var userType = usuario.getRoles();

    authorities.add(new SimpleGrantedAuthority("CLAIM_userType_" + userType.toString()));

    return authorities;
  }
}
