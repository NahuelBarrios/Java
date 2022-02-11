package com.catalogo.entities;

import java.util.*;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UsersLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    private String username;
    
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "idRol"))
    private Set<Rol> roles;
    
//    @OneToMany
//    @JoinColumn(name = "idUsuario")
//    private List<Rol> roles = new ArrayList<>();
}
