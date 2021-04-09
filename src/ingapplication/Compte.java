package ingapplication;

/**
 *
 * @author omaima
 */
public class Compte {
    static int numCompte = 33030000;
    private int num;
    private int solde;
    private String numCarte;
    private String codeCarte;
    private String cin;

    public Compte( int solde, String cin , String numCarte, String codeCarte) {
        numCompte++;
        this.solde = solde;
        this.cin = cin;
        this.numCarte = numCarte;
        this.codeCarte = codeCarte;
    }
    
    public Compte(int numCompte,int solde, String numCarte, String codeCarte, String cin) {
        this.numCompte = numCompte;
        this.num = numCompte;
        this.solde = solde;
        this.numCarte = numCarte;
        this.codeCarte = codeCarte;
        this.cin = cin;
    }

    public Compte(int num, String numCarte, String codeCarte) {
        this.num = num;
        this.numCarte = numCarte;
        this.codeCarte = codeCarte;
    }

    public int getNum() {
        return num;
    }
    public Compte() {
    }
 
    
    public static int getNumCompte() {
        return numCompte;
    }
   /* public static int getNumCompte111() {
        return numCompte;
    }*/
    
   

    public int getSolde() {
        return solde;
    }

    public String getNumCarte() {
        return numCarte;
    }

    public String getCodeCarte() {
        return codeCarte;
    }

    public String getCin() {
        return cin;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public void setNumCarte(String numCarte) {
        this.numCarte = numCarte;
    }

    public void setCodeCarte(String codeCarte) {
        this.codeCarte = codeCarte;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    
    
}
