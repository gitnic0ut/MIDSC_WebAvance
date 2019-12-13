package com.tp.projet.utilisateur;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
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
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Projet> projetList;

    public Users() {
    }

    public Users(long id) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }
    

  

}