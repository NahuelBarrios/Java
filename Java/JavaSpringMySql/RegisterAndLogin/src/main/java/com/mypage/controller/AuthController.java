package com.mypage.controller;

import com.mypage.entities.Role;
import com.mypage.entities.User;
import com.mypage.payload.LoginDto;
import com.mypage.payload.SignUpDto;
import com.mypage.repository.RoleRepository;
import com.mypage.repository.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),loginDto.getPassword()));
    
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in succesfully!.",HttpStatus.OK);
    }
    
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUSer(@RequestBody SignUpDto signUpDto)
    {
        //Chequea si el username existe en la db
        if(userRepository.existsByUsername(signUpDto.getUsername()))
        {
            return new ResponseEntity<>("Username is already taken!",HttpStatus.BAD_REQUEST);
        }
        
        //Chequea si el email existe en la db
        if(userRepository.existsByEmail(signUpDto.getEmail()))
        {
            return new ResponseEntity<>("Email is already taken!",HttpStatus.BAD_REQUEST);
        }
      
        //Creo el objeto usuario
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        
        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));
        
        userRepository.save(user);
        return new ResponseEntity<>("User registred successfully",HttpStatus.OK);
    }
}
