package com.courses.models;

public class Client {
    private Long id;
    private String nom;
    private String siret;
    private String adresse;
    private Comptable comptable;

    public Client(Long id, String nom, String siret, String adresse, Comptable comptable) {
        this.id = id;
        this.nom = nom;
        this.siret = siret;
        this.adresse = adresse;
        this.comptable = comptable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Comptable getComptable() {
        return comptable;
    }

    public void setComptable(Comptable comptable) {
        this.comptable = comptable;
    }
}
