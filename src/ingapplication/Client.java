package ingapplication;

import java.util.Date;

public class Client {
    
    private String cin;
    private String nomc;
    private String prenom;
    private String adresse;
    private String numeroTel;
    private String dateNais;
    private String sexe;
    private String etatCivile;
    private String mail;
    

    public Client() {}   
    
    public Client(String cin, String nomc, String prenom, String adresse, String numeroTel, String dateNais, String sexe, String etatCivile, String mail) {
        this.cin = cin;
        this.nomc = nomc;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTel = numeroTel;
        this.dateNais = dateNais;
        this.sexe = sexe;
        this.etatCivile = etatCivile;
        this.mail = mail;
    }


    public String getCin() {
        return cin;
    }

    public String getNomc() {
        return nomc;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getDateNais() {
        return dateNais;
    }

    public String getSexe() {
        return sexe;
    }

    public String getEtatCivile() {
        return etatCivile;
    }

    public String getMail() {
        return mail;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void setDateNais(String dateNais) {
        this.dateNais = dateNais;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setEtatCivile(String etatCivile) {
        this.etatCivile = etatCivile;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    
}
