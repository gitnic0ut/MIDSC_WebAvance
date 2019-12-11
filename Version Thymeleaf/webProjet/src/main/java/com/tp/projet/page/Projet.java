package com.tp.projet.page;


import com.tp.projet.utilisateur.*;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Projet
 */
@Entity
public class Projet {

    private String name;
    private int nbMember;
    
    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateCreation = new Date(); /* date de création du projet */
  
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateDue; /* date de rendu du projet */

    /**
     *  Table de liaison avec des membres 
     *    x projets peuvent être attribués de 1 à x membres
     * */
    @ManyToMany
    @JoinTable(
        name = "project_has", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "utilisateur_id", nullable = true)
    )
    private List<Utilisateur> utilisateurList;

    /**
     *  Table de liaison avec des taches 
     *    1 seul projet peut comporter de 0 à x taches
     * */
    @ManyToMany
    @JoinTable(
        name = "tache_has", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "tache_id", nullable = true)
    )
    private List<Tache> tacheList;

    
    /* Constructeurs */

    public Projet() {
    }

    public Projet(String name, int nbMember, Date dateCreation, Date dateDue, List<Utilisateur> utilisateurList,
            List<Tache> tacheList, long id) {
        this.name = name;
        this.nbMember = nbMember;
        this.dateCreation = dateCreation;
        this.dateDue = dateDue;
        this.utilisateurList = utilisateurList;
        this.tacheList = tacheList;
        this.id = id;
    }


    /* Getters & Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbMember() {
        return nbMember;
    }

    public void setNbMember(int nbMember) {
        this.nbMember = nbMember;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    public List<Tache> getTacheList() {
        return tacheList;
    }

    public void setTacheList(List<Tache> tacheList) {
        this.tacheList = tacheList;
    }

}