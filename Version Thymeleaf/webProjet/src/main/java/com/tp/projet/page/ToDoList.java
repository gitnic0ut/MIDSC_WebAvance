package com.tp.projet.page;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


/**
 * Projet
 */
@Entity
public class ToDoList {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String aFaire;
    private String pret;
    private String enCours;
    private String enTest;
    private String fait;
    private String membre;
    private Date dateCreation;

    public ToDoList() {
    }

    public ToDoList(long id, String name, String aFaire, String pret, String enCours, String enTest, String fait,
            String membre, Date dateCreation) {
        this.id = id;
        this.name = name;
        this.aFaire = aFaire;
        this.pret = pret;
        this.enCours = enCours;
        this.enTest = enTest;
        this.fait = fait;
        this.membre = membre;
        this.dateCreation = dateCreation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaFaire() {
        return aFaire;
    }

    public void setaFaire(String aFaire) {
        this.aFaire = aFaire;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getEnCours() {
        return enCours;
    }

    public void setEnCours(String enCours) {
        this.enCours = enCours;
    }

    public String getEnTest() {
        return enTest;
    }

    public void setEnTest(String enTest) {
        this.enTest = enTest;
    }

    public String getFait() {
        return fait;
    }

    public void setFait(String fait) {
        this.fait = fait;
    }

    public String getMembre() {
        return membre;
    }

    public void setMembre(String membre) {
        this.membre = membre;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

}