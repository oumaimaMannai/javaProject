package ingapplication;

import java.util.Date;

/**
 *
 * @author omaima
 */
public class virement {
    private int idv;
    private int numCompte;
    private int numCompteR;
    private String datev;
    private int montantv;

    public virement(int numCompte, int numCompteR, String datev, int montantv) {
        this.numCompte = numCompte;
        this.numCompteR = numCompteR;
        this.datev = datev;
        this.montantv = montantv;
    }

    public int getIdv() {
        return idv;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public int getNumCompteR() {
        return numCompteR;
    }

    public void setNumCompteR(int numCompteR) {
        this.numCompteR = numCompteR;
    }

    public String getDatev() {
        return datev;
    }

    public void setDatev(String datev) {
        this.datev = datev;
    }

    public int getMontantv() {
        return montantv;
    }

    public void setMontantv(int montantv) {
        this.montantv = montantv;
    }
    
    
}
