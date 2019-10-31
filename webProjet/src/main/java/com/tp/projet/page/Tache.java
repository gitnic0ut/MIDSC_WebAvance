package com.tp.projet.page;

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
 * Tache
 */
@Entity
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
    @ManyToMany
    @JoinTable(
        name = "tache_has", 
        joinColumns = @JoinColumn(name = "tache_id"), 
        inverseJoinColumns = @JoinColumn(name = "project_id", nullable = true)
    )
    private List<Projet> projetList;


    /* Constructeurs */

    public Tache() {
    }

    public Tache(String name, int hour, float completion, String description, long id, Date dateCreation, Date dateDue,
            List<Projet> projetList) {
        this.name = name;
        this.hour = hour;
        this.completion = completion;
        this.description = description;
        this.id = id;
        this.dateCreation = dateCreation;
        this.dateDue = dateDue;
        this.projetList = projetList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public float getCompletion() {
        return completion;
    }

    public void setCompletion(float completion) {
        this.completion = completion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }

  

}