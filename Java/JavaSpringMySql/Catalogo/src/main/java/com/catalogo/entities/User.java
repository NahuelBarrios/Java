package com.catalogo.entities;

import java.util.List;
import javax.persistence.*;
import javax.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints  = {
    @UniqueConstraint(columnNames = {"username"}),
    @UniqueConstraint(columnNames = {"email"})
})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    
    private String name;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Rol> roles;
}
