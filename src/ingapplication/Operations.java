/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingapplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omaima
 */
public class Operations extends javax.swing.JFrame {

    /**
     * Creates new form Operations
     */
    public Operations() {
        initComponents();
       // populateJtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        nom2 = new javax.swing.JLabel();
        NumCompte2 = new javax.swing.JTextField();
        nom4 = new javax.swing.JLabel();
        nom6 = new javax.swing.JLabel();
        NomPrenom2 = new javax.swing.JTextField();
        CinClient2 = new javax.swing.JTextField();
        nom7 = new javax.swing.JLabel();
        Solde2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOperation = new javax.swing.JTable();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Op�rations\n");
        setUndecorated(true);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        nom2.setBackground(new java.awt.Color(51, 51, 51));
        nom2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom2.setForeground(new java.awt.Color(51, 51, 51));
        nom2.setText("Numero du compte");

        NumCompte2.setEditable(false);
        NumCompte2.setBackground(new java.awt.Color(255, 255, 255));
        NumCompte2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NumCompte2.setForeground(new java.awt.Color(51, 51, 51));

        nom4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom4.setForeground(new java.awt.Color(51, 51, 51));
        nom4.setText("CIN");

        nom6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom6.setForeground(new java.awt.Color(51, 51, 51));
        nom6.setText("Solde");

        NomPrenom2.setEditable(false);
        NomPrenom2.setBackground(new java.awt.Color(255, 255, 255));
        NomPrenom2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomPrenom2.setForeground(new java.awt.Color(51, 51, 51));

        CinClient2.setEditable(false);
        CinClient2.setBackground(new java.awt.Color(255, 255, 255));
        CinClient2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CinClient2.setForeground(new java.awt.Color(51, 51, 51));

        nom7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom7.setForeground(new java.awt.Color(51, 51, 51));
        nom7.setText("Nom pr�nom");

        Solde2.setEditable(false);
        Solde2.setBackground(new java.awt.Color(255, 255, 255));
        Solde2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Solde2.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nom6)
                    .addComponent(nom4)
                    .addComponent(nom2)
                    .addComponent(nom7)
                    .addComponent(NomPrenom2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(NumCompte2)
                    .addComponent(CinClient2)
                    .addComponent(Solde2))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumCompte2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(nom4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CinClient2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomPrenom2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Solde2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTableOperation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableOperation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOperationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOperation);

        cancel.setBackground(new java.awt.Color(192, 57, 43));
        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Quitter");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cancel)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableOperationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOperationMouseClicked
            
    }//GEN-LAST:event_jTableOperationMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
         this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

/***************************************************************************************************************/  
 private String chercherPers(String matricule){
     
        PreparedStatement st;
        ResultSet rs; 
        String nom ="";
        
        String query= "SELECT `nom`, `prenom`FROM `personnel` WHERE `Matricule` = ?";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setString(1, matricule);
            rs = st.executeQuery();
                if (rs.next()){
                   nom = rs.getString(1)+" "+rs.getString(2);
                }            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nom;
    } 
/******************************************************************************************************************/
 public ArrayList<comptepersonnel> SelectionOperation(String numCompte){
        
        ArrayList<comptepersonnel> cpList = new ArrayList<>(); 
        
        PreparedStatement st;
        ResultSet rs; 
        int i = 0;
        
        String query= "SELECT `id`, `Matricule`, `Date`, `typeOperation`, `Montant` FROM `comptepersonnel` WHERE `numCompte` = ?  and `typeOperation` <> 'Ajout' order by `Date` DESC";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setString(1, numCompte);
            rs = st.executeQuery();
            
            comptepersonnel per;
            while ((rs.next())&&(i<3)) {
                per = new comptepersonnel(rs.getString("Matricule"),
                                    Integer.valueOf(numCompte),
                                    rs.getString("Date"), 
                                    rs.getString("typeOperation"), 
                                    rs.getInt("Montant"));                
                cpList.add(per);
                i++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VirementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    return  cpList;
}
    
/******************************************************************************************************************/
     public void populateJtable(){
     
        int num = Integer.valueOf(NumCompte2.getText());
        ArrayList<comptepersonnel> clList = SelectionOperation(String.valueOf(num));
        
        String[] colNames = {"Type op�ration","Date","Montant", "Matricule", "Nom Personnel"};
        Object[][] rows = new Object[clList.size()][9];
        
        for (int i =0; i< clList.size(); i++){
//            rows[i][0] = clList.get(i).getNumCompte();
            rows[i][0] = clList.get(i).getTypeOperation();
            rows[i][1] = clList.get(i).getDate();
            rows[i][2] = clList.get(i).getMontant();
            rows[i][3] = clList.get(i).getMatricule();
            rows[i][4] = chercherPers(clList.get(i).getMatricule());
        }
        MyModelOperation mmc = new MyModelOperation(colNames,rows);
        jTableOperation.setModel(mmc);
        jTableOperation.setRowHeight(30);
        jTableOperation.getColumnModel().getColumn(0).setPreferredWidth(100);       
    } 
    
    
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
            java.util.logging.Logger.getLogger(Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Operations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField CinClient2;
    public javax.swing.JTextField NomPrenom2;
    public javax.swing.JTextField NumCompte2;
    public javax.swing.JTextField Solde2;
    private javax.swing.JButton cancel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableOperation;
    private javax.swing.JLabel nom2;
    private javax.swing.JLabel nom4;
    private javax.swing.JLabel nom6;
    private javax.swing.JLabel nom7;
    // End of variables declaration//GEN-END:variables
}