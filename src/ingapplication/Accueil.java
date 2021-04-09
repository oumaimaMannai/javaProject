package ingapplication;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    public Accueil() {
        initComponents();
        
        populateJtable();
        
        jTable11.setShowGrid(true);
        jTable11.setGridColor(Color.gray);
        
        JTableHeader th = jTable11.getTableHeader();
        th.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        cinBox();
        NumCompte.setText(String.valueOf(Compte.getNumCompte()+1));
        
        jLabelDECONXION.setVisible(false);
        matricule.setVisible(false);
        OBcin.setVisible(false);
        OBmessage.setVisible(false);
        OBnom.setVisible(false);
        OBnum.setVisible(false);
        OBsolde.setVisible(false);
        
    }
    
/******************************************************************************************************/    
    public void refreshJtable(){
        jTable11.setModel(new DefaultTableModel());
        populateJtable();
    }   
/******************************************************************************************************/    
    public void clearFields(){
        
        CINCOMP.setSelectedIndex(0);
        NomPrenom.setText("");
        montant.setText("");
        numCarte.setText("");
        codeCarte.setText("");
        
        OBcin.setVisible(false);
        OBmessage.setVisible(false);
        OBnom.setVisible(false);
        OBnum.setVisible(false);
        OBsolde.setVisible(false);
        
        serch.setText("Cliquez ici pour rechercher ...");
    }
/******************************************************************************************************/     
    private void cinBox(){
        PreparedStatement st;
        ResultSet rs;       
        
        String query= "SELECT `CIN` FROM `client`";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            rs = st.executeQuery();
                CINCOMP.addItem("");
            while (rs.next()){
                CINCOMP.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/******************************************************************************************************/
     private boolean chercherCompte(int num){
     
        PreparedStatement st;
        ResultSet rs; 
        boolean verif = false;
        
        String query= "SELECT * FROM `compte` WHERE `numCompte` = ?";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setString(1, String.valueOf(num));
            rs = st.executeQuery();
            
                if (rs.next()){
                   verif = true;
                }            
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verif;
    }    
/*******************************************************************************************************/  
 private String chercherCin(String cin){
     
        PreparedStatement st;
        ResultSet rs; 
        String nom ="";
        
        String query= "SELECT `nomC`,`prenomC` FROM `client` WHERE `CIN`=?";
        
        try {            
            st = ConnectBD.connecterBD().prepareStatement(query);
            st.setString(1, cin);
            rs = st.executeQuery();
                if ((rs.next())&& !CINCOMP.equals("")){
                   nom = rs.getString(1)+" "+rs.getString(2);
                }            
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nom;
    }    
/*******************************************************************************************************/    
 public void populateJtable(){
     
        CompteQuery cq = new CompteQuery();
        ArrayList<Compte> clList = cq.compteList();
        String[] colNames = {"Numero Compte","CIN","Nom et Prenom","Solde", "Carte"};
        Object[][] rows = new Object[clList.size()][9];
        
        for (int i =0; i< clList.size(); i++){
            rows[i][0] = clList.get(i).getNum();
            rows[i][1] = clList.get(i).getCin();
            rows[i][2] = chercherCin(clList.get(i).getCin());
            rows[i][3] = clList.get(i).getSolde();
            rows[i][4] = clList.get(i).getNumCarte();
        }
        MyModelCompte mmc = new MyModelCompte(colNames,rows);
        jTable11.setModel(mmc);
        jTable11.setRowHeight(30);
        jTable11.getColumnModel().getColumn(2).setPreferredWidth(120);       
    } 
    
/******************************************************************************************************/    
    
     public boolean varifData()
     {        
        if (( montant.getText().equals(""))&& (NomPrenom.getText().equals(""))){
            
            return false;
        }
        else{
            return true;
        }   
    }
/*************************************************************************************************************/    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        mdp = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        jTextNomU = new javax.swing.JTextField();
        jPasswordMP = new javax.swing.JPasswordField();
        connecter = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        LoginForm = new javax.swing.JLabel();
        jLabelClose1 = new javax.swing.JLabel();
        jLabelMin1 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        jTextNomU1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        soldeCom2 = new javax.swing.JLabel();
        SoldeC2 = new javax.swing.JTextField();
        AjouterClient2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNomU = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelDECONXION = new javax.swing.JLabel();
        jLabelCompte = new javax.swing.JLabel();
        matricule = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        nom1 = new javax.swing.JLabel();
        NumCompte = new javax.swing.JTextField();
        nom3 = new javax.swing.JLabel();
        CINCOMP = new javax.swing.JComboBox<>();
        nom5 = new javax.swing.JLabel();
        NomPrenom = new javax.swing.JTextField();
        OBnum = new javax.swing.JLabel();
        OBcin = new javax.swing.JLabel();
        OBnom = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        soldeCom1 = new javax.swing.JLabel();
        montant = new javax.swing.JTextField();
        retirer = new javax.swing.JButton();
        deposer = new javax.swing.JButton();
        OBsolde = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        soldeCom = new javax.swing.JLabel();
        numCarte = new javax.swing.JTextField();
        codeCarte = new javax.swing.JTextField();
        soldeCom3 = new javax.swing.JLabel();
        Ajoutercarte = new javax.swing.JButton();
        jButtondesactiver = new javax.swing.JButton();
        ouvrirCompte = new javax.swing.JButton();
        fermerCompte = new javax.swing.JButton();
        operations = new javax.swing.JButton();
        jButtonVirement = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        serch = new javax.swing.JTextField();
        OBmessage = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        mdp.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        mdp.setForeground(new java.awt.Color(236, 240, 241));
        mdp.setText("Mot de passe :");

        nom.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        nom.setForeground(new java.awt.Color(236, 240, 241));
        nom.setText("Matricule");

        jTextNomU.setBackground(new java.awt.Color(108, 122, 137));
        jTextNomU.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextNomU.setForeground(new java.awt.Color(228, 241, 254));

        jPasswordMP.setBackground(new java.awt.Color(108, 122, 137));
        jPasswordMP.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPasswordMP.setForeground(new java.awt.Color(228, 241, 254));

        connecter.setBackground(new java.awt.Color(24, 167, 240));
        connecter.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        connecter.setForeground(new java.awt.Color(255, 255, 255));
        connecter.setText("Connecter");
        connecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connecterMouseClicked(evt);
            }
        });
        connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connecterActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(44, 62, 80));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("afficher mot de passe ");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nom)
                        .addComponent(jTextNomU)
                        .addComponent(mdp)
                        .addComponent(jPasswordMP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(connecter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTextNomU, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mdp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordMP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LoginForm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginForm.setForeground(new java.awt.Color(255, 255, 255));
        LoginForm.setText("Login Form");

        jLabelClose1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelClose1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose1.setText("X");
        jLabelClose1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClose1MouseClicked(evt);
            }
        });

        jLabelMin1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMin1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin1.setText("-");
        jLabelMin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMin1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LoginForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClose1)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginForm)
                    .addComponent(jLabelClose1)
                    .addComponent(jLabelMin1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTextNomU1.setBackground(new java.awt.Color(108, 122, 137));
        jTextNomU1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextNomU1.setForeground(new java.awt.Color(228, 241, 254));

        jPanel7.setBackground(new java.awt.Color(44, 62, 80));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solde", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        soldeCom2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soldeCom2.setForeground(new java.awt.Color(236, 240, 241));
        soldeCom2.setText("Montant");

        SoldeC2.setBackground(new java.awt.Color(108, 122, 137));
        SoldeC2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SoldeC2.setForeground(new java.awt.Color(228, 241, 254));
        SoldeC2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SoldeC2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SoldeC2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SoldeC2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soldeCom2))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(soldeCom2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SoldeC2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        AjouterClient2.setBackground(new java.awt.Color(38, 194, 129));
        AjouterClient2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AjouterClient2.setForeground(new java.awt.Color(255, 255, 255));
        AjouterClient2.setText("Ajouter");
        AjouterClient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterClient2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accueil");

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        jPanel2.setBackground(new java.awt.Color(248, 148, 6));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabelNomU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNomU.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNomU.setText("Nom Utilisateur");
        jLabelNomU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNomUMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clients");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Personnels");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabelDECONXION.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDECONXION.setForeground(new java.awt.Color(236, 240, 241));
        jLabelDECONXION.setText("D�connexion");
        jLabelDECONXION.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDECONXION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDECONXIONMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDECONXIONMouseEntered(evt);
            }
        });

        jLabelCompte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCompte.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompte.setText("Comptes");
        jLabelCompte.setToolTipText("");
        jLabelCompte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCompte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCompteMouseClicked(evt);
            }
        });

        matricule.setForeground(new java.awt.Color(255, 255, 255));
        matricule.setText("matricule");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNomU, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDECONXION)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(matricule)
                .addGap(150, 150, 150)
                .addComponent(jLabelCompte)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomU)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabelDECONXION)
                    .addComponent(jLabelCompte))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matricule)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable11MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable11);

        jPanel9.setBackground(new java.awt.Color(44, 62, 80));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel8.setBackground(new java.awt.Color(44, 62, 80));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Compte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        nom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom1.setForeground(new java.awt.Color(236, 240, 241));
        nom1.setText("Numero du compte");

        NumCompte.setEditable(false);
        NumCompte.setBackground(new java.awt.Color(44, 62, 80));
        NumCompte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NumCompte.setForeground(new java.awt.Color(228, 241, 254));
        NumCompte.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        NumCompte.setOpaque(false);
        NumCompte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NumCompteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NumCompteMouseExited(evt);
            }
        });

        nom3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom3.setForeground(new java.awt.Color(236, 240, 241));
        nom3.setText("CIN");

        CINCOMP.setBackground(new java.awt.Color(108, 122, 137));
        CINCOMP.setEditable(true);
        CINCOMP.setForeground(new java.awt.Color(228, 241, 254));
        CINCOMP.setOpaque(false);
        CINCOMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CINCOMPActionPerformed(evt);
            }
        });

        nom5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom5.setForeground(new java.awt.Color(236, 240, 241));
        nom5.setText("Nom pr�nom");

        NomPrenom.setEditable(false);
        NomPrenom.setBackground(new java.awt.Color(44, 62, 80));
        NomPrenom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomPrenom.setForeground(new java.awt.Color(228, 241, 254));
        NomPrenom.setOpaque(false);

        OBnum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBnum.setForeground(new java.awt.Color(255, 0, 0));
        OBnum.setText("*");

        OBcin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBcin.setForeground(new java.awt.Color(255, 0, 0));
        OBcin.setText("*");

        OBnom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBnom.setForeground(new java.awt.Color(255, 0, 0));
        OBnom.setText("*");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(NomPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OBnom))
                    .addComponent(nom5)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(CINCOMP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OBcin))
                    .addComponent(nom3)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(NumCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OBnum))
                    .addComponent(nom1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OBnum, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CINCOMP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OBcin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OBnom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(44, 62, 80));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solde", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        soldeCom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soldeCom1.setForeground(new java.awt.Color(236, 240, 241));
        soldeCom1.setText("Solde");

        montant.setBackground(new java.awt.Color(44, 62, 80));
        montant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        montant.setForeground(new java.awt.Color(228, 241, 254));
        montant.setOpaque(false);

        retirer.setBackground(new java.awt.Color(38, 194, 129));
        retirer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        retirer.setForeground(new java.awt.Color(255, 255, 255));
        retirer.setText("Retirer");
        retirer.setEnabled(false);
        retirer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirerActionPerformed(evt);
            }
        });

        deposer.setBackground(new java.awt.Color(38, 194, 129));
        deposer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deposer.setForeground(new java.awt.Color(255, 255, 255));
        deposer.setText("D�poser");
        deposer.setEnabled(false);
        deposer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deposerActionPerformed(evt);
            }
        });

        OBsolde.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBsolde.setForeground(new java.awt.Color(255, 0, 0));
        OBsolde.setText("*");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(deposer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(retirer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(soldeCom1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OBsolde)
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(soldeCom1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OBsolde, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retirer)
                    .addComponent(deposer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(44, 62, 80));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        soldeCom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soldeCom.setForeground(new java.awt.Color(236, 240, 241));
        soldeCom.setText("Numero du carte");

        numCarte.setBackground(new java.awt.Color(44, 62, 80));
        numCarte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numCarte.setForeground(new java.awt.Color(228, 241, 254));
        numCarte.setOpaque(false);

        codeCarte.setBackground(new java.awt.Color(44, 62, 80));
        codeCarte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codeCarte.setForeground(new java.awt.Color(228, 241, 254));
        codeCarte.setOpaque(false);

        soldeCom3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soldeCom3.setForeground(new java.awt.Color(236, 240, 241));
        soldeCom3.setText("Code du carte");

        Ajoutercarte.setBackground(new java.awt.Color(38, 194, 129));
        Ajoutercarte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ajoutercarte.setForeground(new java.awt.Color(255, 255, 255));
        Ajoutercarte.setText("Ajouter");
        Ajoutercarte.setEnabled(false);
        Ajoutercarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutercarteActionPerformed(evt);
            }
        });

        jButtondesactiver.setText("D�sactiver la carte");
        jButtondesactiver.setEnabled(false);
        jButtondesactiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondesactiverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtondesactiver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ajoutercarte, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(codeCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(soldeCom3)
                        .addComponent(numCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(soldeCom)))
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(soldeCom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soldeCom3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codeCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ajoutercarte)
                    .addComponent(jButtondesactiver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61))
        );

        ouvrirCompte.setBackground(new java.awt.Color(38, 194, 129));
        ouvrirCompte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ouvrirCompte.setForeground(new java.awt.Color(255, 255, 255));
        ouvrirCompte.setText("Ouvrir Compte");
        ouvrirCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirCompteActionPerformed(evt);
            }
        });

        fermerCompte.setBackground(new java.awt.Color(242, 38, 19));
        fermerCompte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fermerCompte.setForeground(new java.awt.Color(255, 255, 255));
        fermerCompte.setText("Fermer Compte");
        fermerCompte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerCompteActionPerformed(evt);
            }
        });

        operations.setBackground(new java.awt.Color(24, 167, 240));
        operations.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        operations.setForeground(new java.awt.Color(255, 255, 255));
        operations.setText("Op�rations");
        operations.setEnabled(false);
        operations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opérationsActionPerformed(evt);
            }
        });

        jButtonVirement.setText("Virement");
        jButtonVirement.setEnabled(false);
        jButtonVirement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVirementActionPerformed(evt);
            }
        });

        jButton2.setText("Actualiser ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        serch.setBackground(new java.awt.Color(44, 62, 80));
        serch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        serch.setForeground(new java.awt.Color(255, 255, 255));
        serch.setText("Cliquez ici pour rechercher ...");
        serch.setToolTipText("");
        serch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        serch.setOpaque(false);
        serch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serchMouseClicked(evt);
            }
        });
        serch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                serchKeyTyped(evt);
            }
        });

        OBmessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OBmessage.setForeground(new java.awt.Color(255, 0, 0));
        OBmessage.setText("Des champs obligatoires");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(OBmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fermerCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ouvrirCompte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(operations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVirement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OBmessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ouvrirCompte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fermerCompte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVirement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(operations)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connecterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connecterMouseClicked

    }//GEN-LAST:event_connecterMouseClicked

    private void connecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connecterActionPerformed


    }//GEN-LAST:event_connecterActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
      
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jLabelClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelClose1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelClose1MouseClicked

    private void jLabelMin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMin1MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMin1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //show a new form
        AjoutClient form = new AjoutClient();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        
        form.jLabelNomU.setText(this.jLabelNomU.getText());
        form.matricule.setText(this.matricule.getText());
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        //show a new form
        PersonnetForm form = new PersonnetForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        
        form.jLabelNomU.setText(this.jLabelNomU.getText());
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void NumCompteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NumCompteMouseClicked
        
    }//GEN-LAST:event_NumCompteMouseClicked

    private void NumCompteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NumCompteMouseExited
      
    }//GEN-LAST:event_NumCompteMouseExited

    private void jLabelDECONXIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDECONXIONMouseClicked
        //show a new form
        Login form = new Login();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_jLabelDECONXIONMouseClicked

    private void jLabelNomUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNomUMouseEntered
        jLabelDECONXION.setVisible(true);
    }//GEN-LAST:event_jLabelNomUMouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jLabelDECONXION.setVisible(false);
    }//GEN-LAST:event_jPanel2MouseExited

    private void jLabelDECONXIONMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDECONXIONMouseEntered
       jLabelDECONXION.setVisible(true);
    }//GEN-LAST:event_jLabelDECONXIONMouseEntered

    private void ouvrirCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouvrirCompteActionPerformed
        
        if (varifData()){
           
            String cin = CINCOMP.getSelectedItem().toString();
            //String numcompte = NumCompte.getText();
            String TypeOperation = "Ajout";
            int solde = Integer.valueOf(montant.getText());
            String matricule = Accueil.matricule.getText();
            String numCarte = this.numCarte.getText();
            String codeCarte = this.codeCarte.getText();
            
            if (!numCarte.equals("")){
                if (codeCarte.equals("")){
                    JOptionPane.showMessageDialog(null, "Remplir le champ code carte ");
                }
            }
            
            if (numCarte.equals("") && codeCarte.equals("")){
                numCarte = "0";
                codeCarte = "0";
            }
                        
            Compte compte = new Compte(solde, cin, numCarte, codeCarte);
                        
            CompteQuery comq = new CompteQuery();
            boolean b = comq.ouvrirCompte(compte, TypeOperation,0,matricule);
            refreshJtable();     
            clearFields();                
                
        }else{
            OBcin.setVisible(true);
            OBmessage.setVisible(true);
            OBnom.setVisible(true);
            OBnum.setVisible(true);
            OBsolde.setVisible(true);
        }
    }//GEN-LAST:event_ouvrirCompteActionPerformed

    private void jLabelCompteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCompteMouseClicked
        //show a new form
        Accueil form = new Accueil();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        form.jLabelNomU.setText(this.jLabelNomU.getText());
        this.dispose();
    }//GEN-LAST:event_jLabelCompteMouseClicked

    
    private void CINCOMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CINCOMPActionPerformed

       String x= CINCOMP.getSelectedItem().toString();
       String nom = chercherCin(x);
       NomPrenom.setText(nom);
    }//GEN-LAST:event_CINCOMPActionPerformed

    private void SoldeC2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SoldeC2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SoldeC2MouseClicked

    private void SoldeC2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SoldeC2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_SoldeC2MouseExited

    private void AjouterClient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterClient2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AjouterClient2ActionPerformed

    private void fermerCompteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerCompteActionPerformed

        int num = Integer.valueOf(NumCompte.getText());
        String matrl= matricule.getText();
        boolean verif = chercherCompte(num);
        
        if (verif){
            String y ="voulez vous fermé le compte "+NumCompte.getText();
            int yesOrNo = JOptionPane.showConfirmDialog(null, y ,"",JOptionPane.OK_CANCEL_OPTION, 0 );
      
            if (yesOrNo == 0){
            CompteQuery cq = new CompteQuery();
            boolean v = cq.fermerCompte(num, matrl);
            if (v){
                JOptionPane.showMessageDialog(null, "L'opération effectuée avec succès ");
            }
            }else{
                 JOptionPane.showMessageDialog(null, "Sélectionnez un compte dans la table ");
             }
        }  
        refreshJtable();     
        clearFields(); 
        
    }//GEN-LAST:event_fermerCompteActionPerformed

    private void jTable11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseClicked
        
        int rowIndex = jTable11.getSelectedRow();

        NumCompte.setText((jTable11.getValueAt(rowIndex, 0)).toString());        
        CINCOMP.setSelectedItem((jTable11.getValueAt(rowIndex, 1)).toString());        
        montant.setText((jTable11.getValueAt(rowIndex, 3)).toString());
        String s =(jTable11.getValueAt(rowIndex, 4)).toString();
        
        numCarte.setText("");
        if (!s.equals("0")){
           numCarte.setText(s);
           jButtondesactiver.setEnabled(true);
        }          
        
        Ajoutercarte.setEnabled(true);
        deposer.setEnabled(true);
        retirer.setEnabled(true);
        jButtonVirement.setEnabled(true);
        operations.setEnabled(true);
        jButtondesactiver.setEnabled(true);
    }//GEN-LAST:event_jTable11MouseClicked

    private void AjoutercarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutercarteActionPerformed
      
        int num = Integer.valueOf(NumCompte.getText());
        String numcarte = numCarte.getText();
        String code = codeCarte.getText();
        
        Compte compte = new Compte(num, numcarte, code);
        CompteQuery cq = new CompteQuery();
        
        boolean verif = cq.carte(compte);
        
        refreshJtable();     
        clearFields(); 
        
    }//GEN-LAST:event_AjoutercarteActionPerformed

    private void retirerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirerActionPerformed
        
        RetirerArgent form = new RetirerArgent();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

       String numCompte = NumCompte.getText();
       form.jLabelNumC.setText(numCompte);
      
    }//GEN-LAST:event_retirerActionPerformed

    private void deposerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deposerActionPerformed
        
        DeposerArgent form = new DeposerArgent();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

       String numCompte = NumCompte.getText();
       form.jLabelNumC.setText(numCompte);
    }//GEN-LAST:event_deposerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTable11.getSelectionModel().clearSelection();
        refreshJtable();
        clearFields();
        NumCompte.setText(String.valueOf(Compte.numCompte+1));
        
        Ajoutercarte.setEnabled(false);
        deposer.setEnabled(false);
        retirer.setEnabled(false);
        jButtonVirement.setEnabled(false);
        operations.setEnabled(false);
        jButtondesactiver.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtondesactiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondesactiverActionPerformed
        
        int num = Integer.valueOf(NumCompte.getText());
        
        String y ="voulez vous désactiver la carte "+NumCompte.getText();
            int yesOrNo = JOptionPane.showConfirmDialog(null, y ,"",JOptionPane.OK_CANCEL_OPTION, 0 );
            
            if (yesOrNo == 0){
                CompteQuery cq = new CompteQuery();
                 boolean verif = cq.desactiverCarte(num);
                if (verif){
                    JOptionPane.showMessageDialog(null, "L'opération effectuée avec succès ");
                }
            }
        refreshJtable();     
        clearFields(); 
    }//GEN-LAST:event_jButtondesactiverActionPerformed

    private void jButtonVirementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVirementActionPerformed
       
        VirementModel form = new VirementModel();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        String numCompte = NumCompte.getText();
        String cin = CINCOMP.getSelectedItem().toString();
        String nom = NomPrenom.getText();

        form.NumCompte1.setText(numCompte);
        form.CinClient.setText(cin);
        form.NomPrenom1.setText(nom);
    }//GEN-LAST:event_jButtonVirementActionPerformed
    
    private void opérationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opérationsActionPerformed
       
        Operations form = new Operations();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        String numC = NumCompte.getText();
        String cin = CINCOMP.getSelectedItem().toString();
        String nom = NomPrenom.getText();
        String solde = montant.getText();
       
        form.NumCompte2.setText(numC);
        form.CinClient2.setText(cin);
        form.NomPrenom2.setText(nom);
        form.Solde2.setText(solde);
      
        form.populateJtable();
    }//GEN-LAST:event_opérationsActionPerformed

    private void serchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchKeyTyped
        
        MyModelCompte model = (MyModelCompte) jTable11.getModel();
        String search = serch.getText().toLowerCase();
        TableRowSorter<MyModelCompte> tr = new TableRowSorter<MyModelCompte>(model);
        jTable11.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
        
    }//GEN-LAST:event_serchKeyTyped

    private void serchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serchMouseClicked
        serch.setText("");
    }//GEN-LAST:event_serchMouseClicked

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AjouterClient2;
    private javax.swing.JButton Ajoutercarte;
    public javax.swing.JComboBox<String> CINCOMP;
    private javax.swing.JLabel LoginForm;
    public javax.swing.JTextField NomPrenom;
    public javax.swing.JTextField NumCompte;
    private javax.swing.JLabel OBcin;
    private javax.swing.JLabel OBmessage;
    private javax.swing.JLabel OBnom;
    private javax.swing.JLabel OBnum;
    private javax.swing.JLabel OBsolde;
    private javax.swing.JTextField SoldeC2;
    private javax.swing.JTextField codeCarte;
    private javax.swing.JButton connecter;
    private javax.swing.JButton deposer;
    private javax.swing.JButton fermerCompte;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonVirement;
    private javax.swing.JButton jButtondesactiver;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelClose1;
    private javax.swing.JLabel jLabelCompte;
    private javax.swing.JLabel jLabelDECONXION;
    private javax.swing.JLabel jLabelMin1;
    public javax.swing.JLabel jLabelNomU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordMP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable11;
    private javax.swing.JTextField jTextNomU;
    private javax.swing.JTextField jTextNomU1;
    public static javax.swing.JLabel matricule;
    private javax.swing.JLabel mdp;
    private javax.swing.JTextField montant;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel nom1;
    private javax.swing.JLabel nom3;
    private javax.swing.JLabel nom5;
    private javax.swing.JTextField numCarte;
    private javax.swing.JButton operations;
    private javax.swing.JButton ouvrirCompte;
    private javax.swing.JButton retirer;
    private javax.swing.JTextField serch;
    private javax.swing.JLabel soldeCom;
    private javax.swing.JLabel soldeCom1;
    private javax.swing.JLabel soldeCom2;
    private javax.swing.JLabel soldeCom3;
    // End of variables declaration//GEN-END:variables
}
