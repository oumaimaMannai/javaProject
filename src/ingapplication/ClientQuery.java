package ingapplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClientQuery {
    
    public boolean insertClient(Client client){
        
            boolean clientIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("INSERT INTO `client`(`CIN`, `nomC`, `prenomC`, `adresse`, `sexe`, `etatCivile`, `dateNaiss`, `numeroTel`, `mail`) VALUES (?,?,?,?,?,?,?,?,?)");
                ps.setString(1, client.getCin());
                ps.setString(2, client.getNomc());
                ps.setString(3, client.getPrenom());
                ps.setString(4, client.getAdresse()) ;                
                ps.setString(5, client.getSexe());
                ps.setString(6, client.getEtatCivile());
                ps.setString(7, client.getDateNais());
                ps.setString(8, client.getNumeroTel());
                ps.setString(9, client.getMail());
                
                if (ps.executeUpdate() != 0){
                        JOptionPane.showMessageDialog(null, "Client ajouté avec succès ");
                        clientIsCreated = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Erreur !");
                        clientIsCreated = false;
                    }
                
                
        
        } catch (SQLException ex) {
            Logger.getLogger(ClientQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientIsCreated;
    }
/******************************************************************************************************/    
    
    public boolean updateClient(Client client){
        
            boolean clientIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("UPDATE `client` SET `nomC`=?, `prenomC`=?, `adresse`=?, `sexe`=?, `etatCivile`=?, `dateNaiss`=?, `numeroTel`=?,`mail`=? WHERE `CIN`= ?");
                
                ps.setString(1, client.getNomc());
                ps.setString(2, client.getPrenom());
                ps.setString(3, client.getAdresse()) ;                
                ps.setString(4, client.getSexe());
                ps.setString(5, client.getEtatCivile());
                ps.setString(6, client.getDateNais());
                ps.setString(7, client.getNumeroTel());
                ps.setString(8, client.getMail());
                ps.setString(9, client.getCin());
                
                if (ps.executeUpdate() != 0){
                        JOptionPane.showMessageDialog(null, "Client modifié avec succès");
                        clientIsCreated = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Erreur !");
                        clientIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ClientQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return clientIsCreated;
    }
    
/******************************************************************************************************/
    
     public boolean deleteClient(String cin){
        
            boolean clientIsCreated = true;
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("DELETE FROM `client` WHERE `CIN` = ?");
                
                ps.setString(1, cin);                
                
                if (ps.executeUpdate() != 0){
                        JOptionPane.showMessageDialog(null, "Client supprimé avec succès");
                        clientIsCreated = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Erreur !");
                        clientIsCreated = false;
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ClientQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return clientIsCreated;
    }
    
    
/******************************************************************************************************/    
    
    //create a list of client
    public ArrayList<Client> clientList()
    {
        ArrayList<Client> cList = new ArrayList<>();
        
        Connection con = ConnectBD.connecterBD();
        Statement st;
        ResultSet rs;
        
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT `CIN`, `nomC`, `prenomC`, `adresse`, `sexe`, `etatCivile`, `dateNaiss`, `numeroTel`, `mail` FROM `client`");
            
            Client clt;
            
            while (rs.next()) {
                clt = new Client(rs.getString("CIN"),
                                rs.getString("nomC"),
                                rs.getString("prenomC"),
                                rs.getString("adresse"),
                                rs.getString("numeroTel"),
                                rs.getString("dateNaiss"),
                                rs.getString("sexe"),
                                rs.getString("etatCivile"),
                                rs.getString("mail"));
                
                cList.add(clt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  cList;
    }    
}
