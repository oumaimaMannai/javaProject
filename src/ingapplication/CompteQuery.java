package ingapplication;

import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class CompteQuery {

    public boolean ouvrirCompte(Compte compte, String TypeOperation,int montant, String matricule){
        
            boolean compteIsCreated = false;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("INSERT INTO `compte`(`numCompte`, `solde`, `cin`,`numCarte`, `codeCarte`) VALUES (?,?,?,?,?)");
                ps.setString(1, String.valueOf(compte.getNumCompte()));
                ps.setString(2, String.valueOf(compte.getSolde()));
                ps.setString(3, compte.getCin());
                ps.setString(4, compte.getNumCarte());
                ps.setString(5, compte.getCodeCarte());
                
                
                if (ps.executeUpdate() != 0){
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String date= dateFormat.format(new Date());
                    
                        comptepersonnel comtPer = new comptepersonnel(matricule, compte.getNumCompte(),date, TypeOperation, montant);
                        comptepersonnelQuery compteperq = new comptepersonnelQuery();
                        boolean verif = compteperq.insertComptepersonnel(comtPer);
                        
                        if (verif){
                             compteIsCreated = true;
                        }     
                    }else{
                        compteIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CompteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return compteIsCreated;
    }
    
/******************************************************************************************************/      
     public boolean fermerCompte(int numCompte, String matricule){
        
            boolean compteIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            boolean verif = false;
            
        try {
            
            comptepersonnelQuery cp = new comptepersonnelQuery();
            int id = cp.chercher(matricule, numCompte);
            if (id != 00){
                verif = cp.deleteComptepersonnel(id);
            }
            
            ps = con.prepareStatement("DELETE FROM `compte` WHERE `numCompte` = ?");                
                ps.setString(1, String.valueOf(numCompte));                
                
                if ((ps.executeUpdate() != 0)&& (verif)){
                        compteIsCreated = true;
                    }else{
                        compteIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CompteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return compteIsCreated;
    }
     
/******************************************************************************************************/ 
    public boolean carte(Compte compte){
        
            boolean compteIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
            String matricule = Accueil.matricule.getText();
            String TypeOperation = "Ajouter carte";
            int numCom = Integer.valueOf(compte.getNum());
            
        try {
            ps = con.prepareStatement("UPDATE `compte` SET `numCarte`=?,`codeCarte`=? WHERE `numCompte`=?");
            
                ps.setString(1, String.valueOf(compte.getNumCarte()));
                ps.setString(2, String.valueOf(compte.getCodeCarte()));
                ps.setString(3, String.valueOf(compte.getNum()));
                
                if (ps.executeUpdate() != 0){
                        compteIsCreated = true;
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String date= dateFormat.format(new Date());

                        comptepersonnel comtPer = new comptepersonnel(matricule,numCom ,date, TypeOperation, 0);
                        comptepersonnelQuery compteperq = new comptepersonnelQuery();
                        boolean verif = compteperq.insertComptepersonnel(comtPer);
                        
                    }else{
                        compteIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CompteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return compteIsCreated;
    }
/******************************************************************************************************/ 
    public boolean desactiverCarte(int numcompte){
        
            boolean compteIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
            String matricule = Accueil.matricule.getText();
            String TypeOperation = "Désactiver carte";
            
        try {
            ps = con.prepareStatement("UPDATE `compte` SET `numCarte`=0,`codeCarte`=0 WHERE `numCompte`=?");
            
                ps.setString(1, String.valueOf(numcompte));
                
                if (ps.executeUpdate() != 0){
                        compteIsCreated = true;
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String date= dateFormat.format(new Date());

                        comptepersonnel comtPer = new comptepersonnel(matricule,numcompte ,date, TypeOperation, 0);
                        comptepersonnelQuery compteperq = new comptepersonnelQuery();
                        boolean verif = compteperq.insertComptepersonnel(comtPer);
                        
                    }else{
                        compteIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CompteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return compteIsCreated;
    }
/******************************************************************************************************/    
//       //create a list of compte
//    public ArrayList<> operationList()
//    {
//        ArrayList<Compte> cList = new ArrayList<>();        
//        Connection con = ConnectBD.connecterBD();
//        Statement st;
//        ResultSet rs;
//        
//        try {            
//            st = con.createStatement();
//            rs = st.executeQuery("SELECT `solde`, `numCarte`, `codeCarte`, `cin`, `numCompte` FROM `compte`");
//            
//            Compte per;
//            while (rs.next()) {
//                per = new Compte(rs.getInt("numCompte"),
//                                    rs.getInt("solde"),
//                                    rs.getString("numCarte"), 
//                                    rs.getString("codeCarte"), 
//                                    rs.getString("cin"));                
//                cList.add(per);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(CompteQuery.class.getName()).log(Level.SEVERE, null, ex);
//        }        
//        return  cList;
//    }             

/******************************************************************************************************/      
    //create a list of compte
    public ArrayList<Compte> compteList()
    {
        ArrayList<Compte> cList = new ArrayList<>();        
        Connection con = ConnectBD.connecterBD();
        Statement st;
        ResultSet rs;
        
        try {            
            st = con.createStatement();
            rs = st.executeQuery("SELECT `solde`, `numCarte`, `codeCarte`, `cin`, `numCompte` FROM `compte`");
            
            Compte per;
            while (rs.next()) {
                per = new Compte(rs.getInt("numCompte"),
                                    rs.getInt("solde"),
                                    rs.getString("numCarte"), 
                                    rs.getString("codeCarte"), 
                                    rs.getString("cin"));                
                cList.add(per);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return  cList;
    }             
}