package ingapplication;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class VirementQuery {
 
 private int chercherSolde(int num){
     
        PreparedStatement st;
        ResultSet rs; 
        int verif = 0;
        
        String query= "SELECT `solde` FROM `compte` WHERE `numCompte` = ?";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setString(1, String.valueOf(num));
            rs = st.executeQuery();
            
                if (rs.next()){
                    verif = rs.getInt(1);
                }            
        } catch (SQLException ex) {
            Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verif;
    } 
/****************************************************************************************************/
  public boolean virementClient(int numC, int mont){
     
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            boolean verif = false;
            
            int solde = chercherSolde(numC);
            mont = solde - mont ;
        try {
            
            ps = con.prepareStatement("UPDATE `compte` SET `solde`= ? WHERE `numCompte`= ?");
                
                ps.setString(1, String.valueOf(mont));
                ps.setString(2, String.valueOf(numC));
                
                if (ps.executeUpdate() != 0){
                        verif = true;                       
                    }else{
                        verif = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return verif;
    } 
/****************************************************************************************************/    
    
     public boolean Effectuer(int numC, int mont){
         
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            boolean verif = false;
            
            int solde = chercherSolde(numC);
            mont = mont + solde;
        try {
            
            ps = con.prepareStatement("UPDATE `compte` SET `solde`= ? WHERE `numCompte`= ?");
                
                ps.setString(1, String.valueOf(mont));
                ps.setString(2, String.valueOf(numC));
                
                if (ps.executeUpdate() != 0){
                        verif = true;                       
                    }else{
                        verif = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return verif;
    }
/******************************************************************************************************************/    
     public boolean insertVirement(virement vir){
        
            boolean virIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("INSERT INTO `virement`(`numCompte`, `numCompteR`, `dateV`, `montantV`) VALUES (?,?,?,?)");
                ps.setString(1, String.valueOf(vir.getNumCompte()));
                ps.setString(2, String.valueOf(vir.getNumCompteR()));
                ps.setString(3, vir.getDatev().toString());
                ps.setString(4, String.valueOf(vir.getMontantv()));
                
                if (ps.executeUpdate() != 0){
                        virIsCreated = true;
                    }else{
                        virIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return virIsCreated;
    }
/******************************************************************************************************/  
     
//     public int chercher(String numCompte, String numCompteR){
//            
//            PreparedStatement st;
//            ResultSet rs;
//            int id = 00;
//            String query ="SELECT `idV` FROM `virement` WHERE `numCompte`=? and `numCompteR`=?";
//         try {
//             
//             st = ConnectBD.connecterBD().prepareStatement(query);
//                st.setString(1, numCompte);
//                st.setString(2, numCompteR);
//                
//                rs = st.executeQuery();
//             if (rs.next()){
//                 id = rs.getInt("idV");
//             }
//             
//         } catch (SQLException ex) {
//             Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         
//        return id;
//     }
/******************************************************************************************************/  
     
     public String chercherCin(String numCompte){
            
            PreparedStatement st;
            ResultSet rs;
            String id = "";
            String query ="SELECT `cin` FROM `compte` WHERE `numCompte` = ?";
         try {
             
             st = ConnectBD.connecterBD().prepareStatement(query);
                st.setString(1, numCompte);
                
                rs = st.executeQuery();
             if (rs.next()){
                 id = rs.getString("cin");
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return id;
     }
/******************************************************************************************************/  
     
     public String chercherNom(String cin){
            
            PreparedStatement st;
            ResultSet rs;
            String id = "";
            String query ="SELECT `nomC`,`prenomC` FROM `client` WHERE `CIN` = ?";
         try {
             
             st = ConnectBD.connecterBD().prepareStatement(query);
                st.setString(1, cin);
                
                rs = st.executeQuery();
             if (rs.next()){
                 id = rs.getString("nomC")+" "+rs.getString("prenomC");
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return id;
     }   
/******************************************************************************************************/    
public boolean verifMontant(int numCompte , int montant){
       
        PreparedStatement st;
        ResultSet rs;  
        boolean verif = false;
        
      String query= "SELECT `solde` FROM `compte` WHERE `numCompte` = ?";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setInt(1, numCompte);
            rs = st.executeQuery();
                
            if (rs.next()){
                if (rs.getInt(1) > montant){                    
                    verif = true;
                }else{
                    JOptionPane.showMessageDialog(null, "Votre solde est insuffisant ! ");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RetirerArgent.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return verif;
}
}
