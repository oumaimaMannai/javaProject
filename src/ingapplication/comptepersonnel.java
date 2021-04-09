package ingapplication;

import java.sql.*;
import java.util.Date;

/**
 *
 * @author omaima
 */
public class comptepersonnel {
    private String Matricule;
    private int numCompte;
    private static int id = 1;
    private String Date;
    private String typeOperation;
    private int Montant;

    public comptepersonnel(String Matricule, int numCompte, String Date, String typeOperation, int Montant) {
        this.Matricule = Matricule;
        this.numCompte = numCompte;
        this.Date = Date;
        this.typeOperation = typeOperation;
        this.Montant = Montant;
        id++;
    }

    public int getId() {
        return id;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int Montant) {
        this.Montant = Montant;
    }
    
}
