/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingapplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author omaima
 */
public class VirementModel extends javax.swing.JFrame {

    /**
     * Creates new form VirementModel
     */
    public VirementModel() {
        initComponents();
        NumCompteBox();
    }

    
    /******************************************************************************************************/     
    private void NumCompteBox(){
        PreparedStatement st;
        ResultSet rs;       
        
        String num = NumCompte1.getText();
        String query= "SELECT `numCompte` FROM `compte` where `numCompte` NOT LIKE ?";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setString(1, num);
            rs = st.executeQuery();
                NUMCOMPR.addItem("");
            while (rs.next()){
                NUMCOMPR.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VirementModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        nom1 = new javax.swing.JLabel();
        nom3 = new javax.swing.JLabel();
        NUMCOMPR = new javax.swing.JComboBox<>();
        nom5 = new javax.swing.JLabel();
        NomPrenomR = new javax.swing.JTextField();
        CINCR = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        nom2 = new javax.swing.JLabel();
        NumCompte1 = new javax.swing.JTextField();
        nom4 = new javax.swing.JLabel();
        nom6 = new javax.swing.JLabel();
        NomPrenom1 = new javax.swing.JTextField();
        CinClient = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        soldeCom1 = new javax.swing.JLabel();
        montant = new javax.swing.JTextField();
        Effectuer = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        nom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom1.setForeground(new java.awt.Color(51, 51, 51));
        nom1.setText("Numero du compte");

        nom3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom3.setForeground(new java.awt.Color(51, 51, 51));
        nom3.setText("CIN");

        NUMCOMPR.setEditable(true);
        NUMCOMPR.setForeground(new java.awt.Color(51, 51, 51));
        NUMCOMPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUMCOMPRActionPerformed(evt);
            }
        });

        nom5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom5.setForeground(new java.awt.Color(51, 51, 51));
        nom5.setText("Nom prénom");

        NomPrenomR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomPrenomR.setForeground(new java.awt.Color(51, 51, 51));

        CINCR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CINCR.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CINCR, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomPrenomR, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom5)
                    .addComponent(NUMCOMPR, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom3)
                    .addComponent(nom1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NUMCOMPR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CINCR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(nom5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomPrenomR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        nom2.setBackground(new java.awt.Color(51, 51, 51));
        nom2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom2.setForeground(new java.awt.Color(51, 51, 51));
        nom2.setText("Numero du compte");

        NumCompte1.setEditable(false);
        NumCompte1.setBackground(new java.awt.Color(255, 255, 255));
        NumCompte1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NumCompte1.setForeground(new java.awt.Color(51, 51, 51));

        nom4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom4.setForeground(new java.awt.Color(51, 51, 51));
        nom4.setText("CIN");

        nom6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom6.setForeground(new java.awt.Color(51, 51, 51));
        nom6.setText("Nom prénom");

        NomPrenom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomPrenom1.setForeground(new java.awt.Color(51, 51, 51));

        CinClient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CinClient.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NumCompte1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom2))
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom4)
                    .addComponent(CinClient, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NomPrenom1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom6))
                .addGap(46, 46, 46))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NumCompte1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(nom4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(nom6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomPrenom1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CinClient, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        soldeCom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soldeCom1.setForeground(new java.awt.Color(51, 51, 51));
        soldeCom1.setText("Montant");

        montant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        montant.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soldeCom1))
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(soldeCom1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Effectuer.setBackground(new java.awt.Color(38, 194, 129));
        Effectuer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Effectuer.setForeground(new java.awt.Color(255, 255, 255));
        Effectuer.setText("Effectuer ");
        Effectuer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EffectuerActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Annuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Effectuer, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Effectuer)
                    .addComponent(Annuler))
                .addGap(58, 58, 58))
        );

        jPanel8.getAccessibleContext().setAccessibleName("Client");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NUMCOMPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUMCOMPRActionPerformed

        String x= NUMCOMPR.getSelectedItem().toString();
        
        VirementQuery vq = new VirementQuery();
        String cin = vq.chercherCin(x);
        String nom = vq.chercherNom(cin);
        
        CINCR.setText(cin);
        NomPrenomR.setText(nom);
    }//GEN-LAST:event_NUMCOMPRActionPerformed

    private void EffectuerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EffectuerActionPerformed
          VirementQuery vq = new VirementQuery();
          int numCompte = Integer.valueOf(NumCompte1.getText());
          int montant = Integer.valueOf(this.montant.getText());
          int numCompteR = Integer.valueOf(NUMCOMPR.getSelectedItem().toString());
          
          
          boolean verif = vq.verifMontant(numCompte,montant);
          if (verif){
              
              SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
              String date= dateFormat.format(new Date());
              
              virement vir = new virement(numCompte, numCompteR, date, montant);
                if (vq.virementClient(numCompte, montant)){
                    boolean verifUpdate = vq.Effectuer(numCompteR, montant);

                    if(verifUpdate){
                      boolean verifInsert = vq.insertVirement(vir);
                      if (verifInsert){
                          JOptionPane.showMessageDialog(null, "L'opération effectuée avec succès ");
                      }
                }}
          }
          this.dispose();
    }//GEN-LAST:event_EffectuerActionPerformed

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
            java.util.logging.Logger.getLogger(VirementModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VirementModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VirementModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VirementModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VirementModel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JTextField CINCR;
    public javax.swing.JTextField CinClient;
    private javax.swing.JButton Effectuer;
    private javax.swing.JComboBox<String> NUMCOMPR;
    public javax.swing.JTextField NomPrenom1;
    private javax.swing.JTextField NomPrenomR;
    public javax.swing.JTextField NumCompte1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField montant;
    private javax.swing.JLabel nom1;
    private javax.swing.JLabel nom2;
    private javax.swing.JLabel nom3;
    private javax.swing.JLabel nom4;
    private javax.swing.JLabel nom5;
    private javax.swing.JLabel nom6;
    private javax.swing.JLabel soldeCom1;
    // End of variables declaration//GEN-END:variables
}
