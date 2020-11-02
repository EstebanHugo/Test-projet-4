package com.projet4.ui.model;

public class ReunionUi {

    private int color;
    private String title;
    private String adressmail;
    private int idreunion;


    public ReunionUi(int color, String title, String adressmail, int idreunion) {
        this.color = color;
        this.title = title;
        this.adressmail = adressmail;
        this.idreunion = idreunion;
    }

    public int getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }

    public String getAdressmail() {
        return adressmail;
    }

    public int getIdreunion() {
        return idreunion;
    }
}
