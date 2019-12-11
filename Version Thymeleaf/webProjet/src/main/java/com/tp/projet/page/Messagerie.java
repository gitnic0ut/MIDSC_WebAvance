package com.tp.projet.page;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


/**
 * Projet
 */
@Entity
public class Messagerie {

    private String sujet;
    private String expediteur;
    private Date dateEnvoi;
 
    @Id
    @GeneratedValue
    private long id;

    public Messagerie() {
    }

    public Messagerie(String sujet, String expediteur, Date dateEnvoi, long id) {
        this.sujet = sujet;
        this.expediteur = expediteur;
        this.dateEnvoi = dateEnvoi;
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}