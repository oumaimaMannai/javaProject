/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author omaima
 */
public class DeposerArgent extends javax.swing.JFrame {

    /**
     * Creates new form Argent
     */
    public DeposerArgent() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        montant = new javax.swing.JTextField();
        soldeCom1 = new javax.swing.JLabel();
        retirer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNumC = new javax.swing.JLabel();
        montant1 = new javax.swing.JTextField();
        soldeCom2 = new javax.swing.JLabel();
        deposer = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();

        montant.setBackground(new java.awt.Color(108, 122, 137));
        montant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        montant.setForeground(new java.awt.Color(228, 241, 254));

        soldeCom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soldeCom1.setForeground(new java.awt.Color(236, 240, 241));
        soldeCom1.setText("Solde");

        retirer.setBackground(new java.awt.Color(38, 194, 129));
        retirer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        retirer.setForeground(new java.awt.Color(255, 255, 255));
        retirer.setText("Retirer");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("D�poser");
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Numero du compte : ");

        jLabelNumC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumC.setText("num");

        montant1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        montant1.setForeground(new java.awt.Color(3, 34, 76));

        soldeCom2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soldeCom2.setText("Montant");

        deposer.setBackground(new java.awt.Color(38, 194, 129));
        deposer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deposer.setForeground(new java.awt.Color(255, 255, 255));
        deposer.setText("D�poser");
        deposer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deposerActionPerformed(evt);
            }
        });

        Annuler.setBackground(new java.awt.Color(242, 38, 19));
        Annuler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Annuler.setForeground(new java.awt.Color(255, 255, 255));
        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jLabelNumC, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(soldeCom2)
                    .addComponent(montant1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(deposer, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNumC))
                .addGap(37, 37, 37)
                .addComponent(soldeCom2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(montant1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deposer)
                    .addComponent(Annuler))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deposerArgent(int numC, int mont){
         
            Connection con = ConnectBD.connecterBD();
            PreparedStatement ps;
            
        try {
            ps = con.prepareStatement("UPDATE `compte` SET `solde`= ? WHERE `numCompte`= ?");
                
                ps.setString(1, String.valueOf(mont));
                ps.setString(2, String.valueOf(numC));
                
                if (ps.executeUpdate() != 0){
                    
                       JOptionPane.showMessageDialog(null, "L'op�ration effectu�e avec succ�s ");
                       this.dispose();
                       
                    }else{
                       JOptionPane.showMessageDialog(null, "Erreur ! ");
                    }
        } catch (SQLException ex) {
            Logger.getLogger(CompteQuery.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
/************************************************************************************************/    
    private void deposerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deposerActionPerformed

        int numCompte = Integer.valueOf(jLabelNumC.getText());
        int mont = Integer.valueOf(montant1.getText());
        
        PreparedStatement st;
        ResultSet rs;       
        
        String TypeOperation = "d�poser";
        String matricule = Accueil.matricule.getText();
        int montant = mont;
        
        String query= "SELECT `solde` FROM `compte` WHERE `numCompte` = ?";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setInt(1, numCompte);
            rs = st.executeQuery();
                
            if (rs.next()){
                    mont = rs.getInt(1)+mont;                    
                    deposerArgent(numCompte,mont);
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String date= dateFormat.format(new Date());

                    comptepersonnel comtPer = new comptepersonnel(matricule, numCompte,date, TypeOperation, montant);
                    comptepersonnelQuery compteperq = new comptepersonnelQuery();
                    boolean verif = compteperq.insertComptepersonnel(comtPer);
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeposerArgent.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
    //   verif(numCompte, mont);
    }//GEN-LAST:event_deposerActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed

        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeposerArgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeposerArgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeposerArgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeposerArgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeposerArgent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JButton deposer;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelNumC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField montant;
    private javax.swing.JTextField montant1;
    private javax.swing.JButton retirer;
    private javax.swing.JLabel soldeCom1;
    private javax.swing.JLabel soldeCom2;
    // End of variables declaration//GEN-END:variables
}
