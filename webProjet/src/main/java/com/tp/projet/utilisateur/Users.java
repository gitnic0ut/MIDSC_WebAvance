package com.tp.projet.utilisateur;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import com.tp.projet.page.Projet;

import lombok.Data;

/**
 * User
 */
@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String displayName;
    private String password;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dateInscription = new Date();

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "project_has", 
        joinColumns = @JoinColumn(name = "user_id", nullable = true), 
        inverseJoinColumns = @JoinColumn(name = "project_id", nullable = true)
    )
    private List<Projet> projetList;

    public Users() {
    }

    public Users(String userName) {
        this.userName = userName;
        this.displayName = userName;
        this.roles.add(UserRole.USER); // be a user by default
        this.password = null;
    }

    public Users(String userName, String displayName, List<String> roles, String derivedPassword) {
        this.userName = userName;
        this.displayName = displayName;
        this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
        this.password = derivedPassword;
    }

    public Users(String userName, String displayName, String password, String email, Date dateInscription,
    List<String> roles) {
        this.userName = userName;
        this.displayName = displayName;
        this.password = password;
        this.email = email;
        this.dateInscription = dateInscription;
        this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
    }
    

  

}