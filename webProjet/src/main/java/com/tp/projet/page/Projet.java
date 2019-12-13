package com.tp.projet.page;

import com.tp.projet.utilisateur.*;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


/**
 * Projet
 */
@Entity
@Data
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
        inverseJoinColumns = @JoinColumn(name = "user_id", nullable = true)
    )
    private List<Users> userList;

    /**
     *  Table de liaison avec des taches 
     *    1 seul projet peut comporter de 0 à x taches
     * */

    @OneToMany(mappedBy="projet")
    private List<Tache> tacheList;

    
    /* Constructeurs */

    public Projet() {
    }

    public Projet(long id) {
        this.id = id;
    }

    public Projet(List<Users> userList) {
        this.userList = userList;
    }



    public Projet(String name, int nbMember, Date dateCreation, Date dateDue, List<Users> userList,
            List<Tache> tacheList, long id) {
        this.name = name;
        this.nbMember = nbMember;
        this.dateCreation = dateCreation;
        this.dateDue = dateDue;
        this.userList = userList;
        this.tacheList = tacheList;
        this.id = id;
    }

    public Projet(long id, List<Users> userList) {
        this.id = id;
        this.userList = userList;
    }


    /* Getters & Setters */


}