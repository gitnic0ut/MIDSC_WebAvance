package com.tp.projet.page;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


/**
 * Projet
 */
@Entity
public class Repertoire {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String commentaire;
    private String emplacement;
    private String projet;
    private float taille;
    private Date dateCreation;

    public Repertoire() {
    }

    public Repertoire(String name, String commentaire, String emplacement, String projet, float taille,
            Date dateCreation, long id) {
        this.name = name;
        this.commentaire = commentaire;
        this.emplacement = emplacement;
        this.projet = projet;
        this.taille = taille;
        this.dateCreation = dateCreation;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}