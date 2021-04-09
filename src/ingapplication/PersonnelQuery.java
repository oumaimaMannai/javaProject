package ingapplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author omaima
 */
public class PersonnelQuery {
    
    public boolean updatePersonnel(Personnel personnel){
        
            boolean personnelIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("UPDATE `personnel` SET `nom`=?,`prenom`=?,`motPasse`=? WHERE `Matricule` = ?");
                
                ps.setString(1, personnel.getNom());
                ps.setString(2, personnel.getPrenom());
                ps.setString(3, personnel.getMotPasse()) ;
                ps.setString(4, personnel.getMatricule());
                
                if (ps.executeUpdate() != 0){
                        JOptionPane.showMessageDialog(null, "Personnel modifié avec succès");
                        personnelIsCreated = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Erreur !");
                        personnelIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return personnelIsCreated;
    }
    
    
/******************************************************************************************************/
    
     public boolean deletePersonnel(String mat){
        
            boolean personnelIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("DELETE FROM `personnel` WHERE `Matricule` =?");
                
                ps.setString(1, mat);                
                
                if (ps.executeUpdate() != 0){
                        JOptionPane.showMessageDialog(null, "Personnel supprimé avec succès");
                        personnelIsCreated = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Erreur !");
                        personnelIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return personnelIsCreated;
    }
       
/******************************************************************************************************/    
    
    //create a list of personnel
    public ArrayList<Personnel> personnelList()
    {
        ArrayList<Personnel> cList = new ArrayList<>();
        
        Connection con = ConnectBD.connecterBD();
        Statement st;
        ResultSet rs;
        
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT `Matricule`,`nom`, `prenom`, `motPasse` FROM `personnel` ");
            
            Personnel per;
            
            while (rs.next()) {
                per = new Personnel(rs.getString("Matricule"),
                                    rs.getString("nom"), 
                                    rs.getString("prenom"), 
                                    rs.getString("motPasse"));
                
                cList.add(per);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  cList;
    }        
}
