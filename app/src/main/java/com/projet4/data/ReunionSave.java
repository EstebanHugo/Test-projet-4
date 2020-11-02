package com.projet4.data;

import java.util.Date;
import java.util.List;

public class ReunionSave {

    private String lieu;
    private String sujetdereu;
    private Date heure;
    private int dureeminute;
    private List<String> adressmails;
    private final int identifiant;

    public ReunionSave(String lieu, String sujetdereu, Date heure, int dureeminute, List<String> adressmails, int identifiant) {
        this.lieu = lieu;
        this.sujetdereu = sujetdereu;
        this.heure = heure;
        this.dureeminute = dureeminute;
        this.adressmails = adressmails;
        this.identifiant = identifiant;
    }

    public String getLieu() {
        return lieu;
    }

    public String getSujetdereu() {
        return sujetdereu;
    }

    public Date getHeure() {
        return heure;
    }

    public int getDureeminute() {
        return dureeminute;
    }

    public List<String> getAdressmails() {
        return adressmails;
    }

    public int getIdentifiant() {
        return identifiant;
    }
}
