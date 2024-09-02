package com.courses.models;

import java.sql.Date;

public class TaxeApprentissage {
    private Long id;
    private Client client;
    private int masseSalariale;
    private int montant;
    private Date $date;

    public TaxeApprentissage(Long id, Client client, int masseSalariale, int montant, Date date) {
        this.id = id;
        this.client = client;
        this.masseSalariale = masseSalariale;
        this.montant = montant;
        this.$date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getMasseSalariale() {
        return masseSalariale;
    }

    public void setMasseSalariale(int masseSalariale) {
        this.masseSalariale = masseSalariale;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getdate() {
        return $date;
    }

    public void setdate(Date $date) {
        this.$date = $date;
    }
}
