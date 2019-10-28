package com.tp.projet;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Utilisateur
 */
@Entity
public class Utilisateur {

    private String pseudo;
    private String password;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dateInscription = new Date();

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    @JoinTable(
        name = "project_has", 
        joinColumns = @JoinColumn(name = "utilisateur_id", nullable = true), 
        inverseJoinColumns = @JoinColumn(name = "project_id", nullable = true)
    )
    private List<Projet> projetList;

    public Utilisateur() {
    }

    public Utilisateur(String pseudo, String password, String email, Date dateInscription, long id,
            List<Projet> projetList) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.dateInscription = dateInscription;
        this.id = id;
        this.projetList = projetList;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }
        
}