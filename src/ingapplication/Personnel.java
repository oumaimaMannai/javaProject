package ingapplication;

public class Personnel {
    
    private String Matricule;
    private String nom;
    private String prenom;
    private String motPasse;

    public Personnel(String Matricule, String nom, String prenom, String motPasse) {
        this.Matricule = Matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.motPasse = motPasse;
    }

    public String getMatricule() {
        return Matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotPasse() {
        return motPasse;
    }


    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }  
}
