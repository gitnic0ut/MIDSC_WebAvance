package com.tp.projet.page;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


/**
 * Projet
 */
@Entity
public class Planning {

    @Id
    @GeneratedValue
    private long id;

    private String membre;
    private String tache;
    private String salle;
    private Boolean configuration; /* semaine de 5 ou 7 jours */
    private Date dateCreation;
    private Date dateEcheance;

    public Planning() {
    }

    public Planning(long id, String membre, String tache, String salle, Boolean configuration, Date dateCreation,
            Date dateEcheance) {
        this.id = id;
        this.membre = membre;
        this.tache = tache;
        this.salle = salle;
        this.configuration = configuration;
        this.dateCreation = dateCreation;
        this.dateEcheance = dateEcheance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMembre() {
        return membre;
    }

    public void setMembre(String membre) {
        this.membre = membre;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public Boolean getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Boolean configuration) {
        this.configuration = configuration;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

}