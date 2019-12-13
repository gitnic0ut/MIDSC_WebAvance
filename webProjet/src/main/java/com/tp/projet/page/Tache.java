package com.tp.projet.page;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


/**
 * Tache
 */
@Embeddable
@Entity
@Data
public class Tache {

    private String name;
    private int hour;
    private float completion; /* pourcentage de complétude de la tache */
    private String description; 
    
    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateCreation = new Date(); /* date de création de la tache */
  
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateDue; /* date de fin de la tache */

    /**
     *  Table de liaison avec un projet 
     *    x taches peuvent être attribuées à 1 seul projet
     * */
    @ManyToOne
    private Projet projet;


    /* Constructeurs */

    public Tache() {
    }

    public Tache(Projet projet) {
        this.projet = projet;
    }




}