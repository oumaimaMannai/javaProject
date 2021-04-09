package ingapplication;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class comptepersonnelQuery {
    
     public boolean insertComptepersonnel(comptepersonnel cp){
        
            boolean cpIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("INSERT INTO `comptepersonnel`(`Matricule`, `numCompte`, `Date`, `typeOperation`, `Montant`) VALUES (?,?,?,?,?)");
                ps.setString(1, cp.getMatricule());
                ps.setString(2, String.valueOf(cp.getNumCompte()));
                ps.setString(3, cp.getDate());
                ps.setString(4, cp.getTypeOperation()) ;
                ps.setString(5, String.valueOf(cp.getMontant())) ;
                
                if (ps.executeUpdate() != 0){
                        cpIsCreated = true;
                    }else{
                        cpIsCreated = false;
                    }
                
                
        
        } catch (SQLException ex) {
            Logger.getLogger(comptepersonnelQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cpIsCreated;
    }
/******************************************************************************************************/  
     
     public int chercher(String matricule, int numCompte){
         
            PreparedStatement st;
            ResultSet rs;
            int id = 00;
            String query ="SELECT `id` FROM `comptepersonnel` WHERE `Matricule` =? and `numCompte`=?";
         try {
             
             st = ConnectBD.connecterBD().prepareStatement(query);
                st.setString(1,matricule);
                st.setString(2, String.valueOf(numCompte));
                
                rs = st.executeQuery();
             if (rs.next()){
                 id = rs.getInt("id");
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(comptepersonnelQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        return id;
     }
     
/******************************************************************************************************/  
     
     public boolean deleteComptepersonnel(int id){
        
            boolean cpIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("DELETE FROM `comptepersonnel` WHERE `id` = ?");
                
                ps.setString(1, String.valueOf(id));                
                
                if (ps.executeUpdate() != 0){
                        cpIsCreated = true;
                    }else{
                        cpIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(comptepersonnelQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cpIsCreated;
    }
    
}
