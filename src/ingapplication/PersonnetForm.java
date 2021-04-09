package ingapplication;


import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;


public class PersonnetForm extends javax.swing.JFrame {
    int pos = 0;
    
    /**
     * Creates new form PersonnetForm
     */
    public PersonnetForm() {
        initComponents();
        Ancien.setVisible(false);
        AMDP.setVisible(false);
        
        populateJtable();
        
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.gray);
        
        JTableHeader th = jTable1.getTableHeader();
       // th.setForeground(Color.blue);
        th.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.setLocationRelativeTo(null);// center form in the screen
        
        jLabelDECONXION.setVisible(false);
        OBcin.setVisible(false);
        OBmessage1.setVisible(false);
        OBnom.setVisible(false);
        OBnum.setVisible(false);
        OBsolde.setVisible(false);
        OBMP.setVisible(false);
        OBMP1.setVisible(false);
    }
/**************************************************************************************************/    
   private boolean VérifMDP(String matricule,String Amdp){
            boolean uExist= false;
            PreparedStatement st;
            ResultSet rs;
            
            //create a select query to check if the username and the password exist in the db
            String query = "SELECT * FROM `personnel` WHERE `Matricule` = ? and `motPasse` = ?";
        try {
            st = ConnectBD.connecterBD().prepareStatement(query);
        
            st.setString(1, matricule); 
            st.setString(2, Amdp);  
            rs = st.executeQuery();
            
            if (rs.next())
            {       
                uExist = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uExist;
   } 
/**************************************************************************************************/      
    public boolean varifData(){
        
        if (Matricule.getText().equals("") && NomP.getText().equals("")
                || PrenomP.getText().equals("")
                || String.valueOf(MDP.getPassword()).equals("")){            
            
            return false;
        }
        else if(!String.valueOf(MDP.getPassword()).equals(String.valueOf(VMDP.getPassword()))){
            JOptionPane.showMessageDialog(null, "Mot de passe incorrect ");
            return false;
        }
        else{
            return true;
        }   
    }
/**************************************************************************************************/      
    public boolean isUserNameExist(String un){
        
            boolean uExist= false;
            PreparedStatement st;
            ResultSet rs;
            
            //get the username & password
            String username = Matricule.getText();
            
            //create a select query to check if the username and the password exist in the db
            String query = "SELECT * FROM `personnel` WHERE `Matricule` = ?";
        try {
            st = ConnectBD.connecterBD().prepareStatement(query);
        
            st.setString(1, username);         
            rs = st.executeQuery();
            
            if (rs.next())
            {               
                uExist = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uExist;
        
    }
    
/******************************************************************************************************/    
    
    public void populateJtable(){
     
        PersonnelQuery cq = new PersonnelQuery();
        ArrayList<Personnel> clList = cq.personnelList();
        String[] colNames = {"Matricule","Nom","Prenom"};
        Object[][] rows = new Object[clList.size()][9];
        
        for (int i =0; i< clList.size(); i++){
            rows[i][0] = clList.get(i).getMatricule();
            rows[i][1] = clList.get(i).getNom();
            rows[i][2] = clList.get(i).getPrenom();
        }
        MyModelPersonnel mmc = new MyModelPersonnel(colNames,rows);
        jTable1.setModel(mmc);
        jTable1.setRowHeight(30);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);       
    } 
/******************************************************************************************************/    
    public void refreshJtable(){
        jTable1.setModel(new DefaultTableModel());
        populateJtable();
    }     
/******************************************************************************************************/    
    public void clearFields(){
        
        Matricule.setText("");
        NomP.setText("");
        PrenomP.setText("");
        MDP.setText("");
        VMDP.setText("");
        AMDP.setText("");
        
        OBcin.setVisible(false);
        OBmessage1.setVisible(false);
        OBnom.setVisible(false);
        OBnum.setVisible(false);
        OBsolde.setVisible(false);
        OBMP.setVisible(false);
        OBMP1.setVisible(false);
        
        serch.setText("Cliquez ici pour rechercher ...");
    }  
    

/*************************************************************************************************************/
    private void showData(int index){
        
        //get selected row index
        Matricule.setText((jTable1.getValueAt(index, 0)).toString());
        NomP.setText((jTable1.getValueAt(index, 1)).toString());        
        PrenomP.setText((jTable1.getValueAt(index, 2)).toString());
    }  
    
    
/**************************************************************************************************/  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextNomU1 = new javax.swing.JTextField();
        mdp1 = new javax.swing.JLabel();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        mdp5 = new javax.swing.JLabel();
        OBmessage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        mdp = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        PrenomP = new javax.swing.JTextField();
        Matricule = new javax.swing.JTextField();
        mdp2 = new javax.swing.JLabel();
        mdp3 = new javax.swing.JLabel();
        mdp4 = new javax.swing.JLabel();
        MDP = new javax.swing.JPasswordField();
        AMDP = new javax.swing.JPasswordField();
        NomP = new javax.swing.JTextField();
        AjouterPersonnel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelNomU = new javax.swing.JLabel();
        jLabelDECONXION = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCompte = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Ancien = new javax.swing.JLabel();
        VMDP = new javax.swing.JPasswordField();
        Modifier = new javax.swing.JButton();
        Supprimer = new javax.swing.JButton();
        serch = new javax.swing.JTextField();
        OBnum = new javax.swing.JLabel();
        OBcin = new javax.swing.JLabel();
        OBnom = new javax.swing.JLabel();
        OBsolde = new javax.swing.JLabel();
        OBmessage1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        OBMP1 = new javax.swing.JLabel();
        OBMP = new javax.swing.JLabel();

        jTextNomU1.setBackground(new java.awt.Color(108, 122, 137));
        jTextNomU1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextNomU1.setForeground(new java.awt.Color(228, 241, 254));

        mdp1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        mdp1.setForeground(new java.awt.Color(236, 240, 241));
        mdp1.setText("Mot de passe :");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        mdp5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mdp5.setForeground(new java.awt.Color(236, 240, 241));
        mdp5.setText("V�rifier mot de passe :");

        OBmessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OBmessage.setForeground(new java.awt.Color(255, 0, 0));
        OBmessage.setText("Des champs obligatoires");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personnel");
        setName("Personnel\n"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        mdp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mdp.setForeground(new java.awt.Color(236, 240, 241));
        mdp.setText("Nom");

        nom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom.setForeground(new java.awt.Color(236, 240, 241));
        nom.setText("Matricule (CIN)");

        PrenomP.setBackground(new java.awt.Color(108, 122, 137));
        PrenomP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PrenomP.setForeground(new java.awt.Color(228, 241, 254));

        Matricule.setBackground(new java.awt.Color(108, 122, 137));
        Matricule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Matricule.setForeground(new java.awt.Color(228, 241, 254));

        mdp2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mdp2.setForeground(new java.awt.Color(236, 240, 241));
        mdp2.setText("Mot de passe :");

        mdp3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mdp3.setForeground(new java.awt.Color(236, 240, 241));
        mdp3.setText("V�rifier mot de passe :");

        mdp4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mdp4.setForeground(new java.awt.Color(236, 240, 241));
        mdp4.setText("Pr�nom");

        MDP.setBackground(new java.awt.Color(108, 122, 137));
        MDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MDP.setForeground(new java.awt.Color(228, 241, 254));

        AMDP.setBackground(new java.awt.Color(108, 122, 137));
        AMDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AMDP.setForeground(new java.awt.Color(228, 241, 254));

        NomP.setBackground(new java.awt.Color(108, 122, 137));
        NomP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NomP.setForeground(new java.awt.Color(228, 241, 254));

        AjouterPersonnel.setBackground(new java.awt.Color(24, 167, 240));
        AjouterPersonnel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AjouterPersonnel.setForeground(new java.awt.Color(255, 255, 255));
        AjouterPersonnel.setText("Ajouter");
        AjouterPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterPersonnelActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(248, 148, 6));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabelNomU.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNomU.setForeground(new java.awt.Color(253, 227, 167));
        jLabelNomU.setText("Nom Utilisateur");
        jLabelNomU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNomUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelNomUMouseEntered(evt);
            }
        });

        jLabelDECONXION.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDECONXION.setForeground(new java.awt.Color(236, 240, 241));
        jLabelDECONXION.setText("D�connexion");
        jLabelDECONXION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDECONXIONMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDECONXIONMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Client");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Personnel");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabelCompte.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelCompte.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompte.setText("Compte");
        jLabelCompte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCompteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNomU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDECONXION)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCompte)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabelCompte))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNomU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDECONXION)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Ancien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ancien.setForeground(new java.awt.Color(236, 240, 241));
        Ancien.setText("Ancien mot de passe :");

        VMDP.setBackground(new java.awt.Color(108, 122, 137));
        VMDP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VMDP.setForeground(new java.awt.Color(228, 241, 254));

        Modifier.setBackground(new java.awt.Color(24, 167, 240));
        Modifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Modifier.setForeground(new java.awt.Color(255, 255, 255));
        Modifier.setText("Modifier");
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        Supprimer.setBackground(new java.awt.Color(242, 38, 19));
        Supprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Supprimer.setForeground(new java.awt.Color(255, 255, 255));
        Supprimer.setText("Supprimer");
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
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

        OBnum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBnum.setForeground(new java.awt.Color(255, 0, 0));
        OBnum.setText("*");

        OBcin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBcin.setForeground(new java.awt.Color(255, 0, 0));
        OBcin.setText("*");

        OBnom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBnom.setForeground(new java.awt.Color(255, 0, 0));
        OBnom.setText("*");

        OBsolde.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBsolde.setForeground(new java.awt.Color(255, 0, 0));
        OBsolde.setText("*");

        OBmessage1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OBmessage1.setForeground(new java.awt.Color(255, 0, 0));
        OBmessage1.setText("Des champs obligatoires");

        jButton2.setText("Actualiser ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        OBMP1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBMP1.setForeground(new java.awt.Color(255, 0, 0));
        OBMP1.setText("*");

        OBMP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OBMP.setForeground(new java.awt.Color(255, 0, 0));
        OBMP.setText("*");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(nom)
                                .addGap(222, 222, 222))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mdp4)
                                    .addComponent(mdp)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NomP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PrenomP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(OBnom)
                                            .addComponent(OBcin)
                                            .addComponent(OBnum))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(OBmessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AjouterPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mdp2)
                                    .addComponent(MDP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mdp3)
                                    .addComponent(Ancien)
                                    .addComponent(VMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OBsolde)
                            .addComponent(OBMP)
                            .addComponent(OBMP1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nom)
                            .addComponent(mdp2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MDP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OBnum, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OBMP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mdp)
                            .addComponent(mdp3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NomP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(OBcin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(VMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(OBMP1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(mdp4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PrenomP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(OBnom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Ancien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(OBsolde, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Supprimer)
                            .addComponent(Modifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AjouterPersonnel)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButton2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(OBmessage1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addComponent(serch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjouterPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterPersonnelActionPerformed

        if (varifData()){
            try {
                Connection con = ConnectBD.connecterBD();
                PreparedStatement ps;

                ps = con.prepareStatement("INSERT INTO `personnel`(`Matricule`, `nom`, `prenom`, `motPasse`) VALUES (?,?,?,?)");
                ps.setString(1, Matricule.getText());
                ps.setString(2, NomP.getText());
                ps.setString(3, PrenomP.getText());
                ps.setString(4, String.valueOf(MDP.getPassword()));

                if (isUserNameExist(Matricule.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Matricule d�ja existe ");
                    
                }else{
                    if (ps.executeUpdate() != 0){
                        JOptionPane.showMessageDialog(null, "Personnel ajout� avec succ�s ");
                        refreshJtable();
                        clearFields();
                    }else{
                        JOptionPane.showMessageDialog(null, "Erreur !");
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(PersonnetForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            OBcin.setVisible(true);
            OBmessage1.setVisible(true);
            OBnom.setVisible(true);
            OBnum.setVisible(true);
            OBMP.setVisible(true);
            OBMP1.setVisible(true);
        }
    }//GEN-LAST:event_AjouterPersonnelActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed

        if (varifData()){

            String matricule = Matricule.getText();
            String nomp = NomP.getText();
            String prenomp = PrenomP.getText();
            String mdp = String.valueOf(MDP.getPassword());
            String Amdp = String.valueOf(AMDP.getPassword());

             if (isUserNameExist(matricule))
                {
                    if (VérifMDP(matricule, Amdp)){
                        Personnel personnel = new Personnel(matricule, nomp, prenomp, mdp);
                        PersonnelQuery pq = new PersonnelQuery();
                        
                        boolean b = pq.updatePersonnel(personnel);
                        JOptionPane.showMessageDialog(null, "Personnel modifié ");
                        
                        refreshJtable();
                        clearFields();
                    }
                }
             else{
                 JOptionPane.showMessageDialog(null, "Personnel n'existe pas !");
             }
        }else{
            OBcin.setVisible(true);
            OBmessage1.setVisible(true);
            OBnom.setVisible(true);
            OBnum.setVisible(true);
            OBsolde.setVisible(true);
        }
        
    }//GEN-LAST:event_ModifierActionPerformed

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed

        String y ="voulez vous supprimé le personnel "+NomP.getText()+" "+PrenomP.getText();
        int yesOrNo = JOptionPane.showConfirmDialog(null, y ,"Suppression du personnel",JOptionPane.OK_CANCEL_OPTION, 0 );

            String mat = Matricule.getText();
            if (!mat.equals("")){
                if (yesOrNo == 0){
                    PersonnelQuery pq = new PersonnelQuery();
                    boolean x = pq.deletePersonnel(mat);
                    refreshJtable();
                    clearFields();
            }}
                else{
                JOptionPane.showMessageDialog(null, "S�lectionnez un personnel dans la table ");
            }
        
    }//GEN-LAST:event_SupprimerActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        Ancien.setVisible(true);
        AMDP.setVisible(true);
        
        int rowIndex = jTable1.getSelectedRow();
         //get selected row index
        Matricule.setText((jTable1.getValueAt(rowIndex, 0)).toString());
        NomP.setText((jTable1.getValueAt(rowIndex, 1)).toString());        
        PrenomP.setText((jTable1.getValueAt(rowIndex, 2)).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabelDECONXIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDECONXIONMouseClicked
        //show a new form
        Login form = new Login();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        this.dispose();
    }//GEN-LAST:event_jLabelDECONXIONMouseClicked

    private void jLabelDECONXIONMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDECONXIONMouseEntered
        jLabelDECONXION.setVisible(true);
    }//GEN-LAST:event_jLabelDECONXIONMouseEntered

    private void jLabelNomUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNomUMouseEntered
        jLabelDECONXION.setVisible(true);
    }//GEN-LAST:event_jLabelNomUMouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jLabelDECONXION.setVisible(false);
    }//GEN-LAST:event_jPanel2MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //show a new form
        AjoutClient form = new AjoutClient();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        form.jLabelNomU.setText(this.jLabelNomU.getText());
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

    private void jLabelCompteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCompteMouseClicked
        //show a new form
        Accueil form = new Accueil();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        form.jLabelNomU.setText(this.jLabelNomU.getText());
        this.dispose();
    }//GEN-LAST:event_jLabelCompteMouseClicked

    private void jLabelNomUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNomUMouseClicked
        //show a new form
        Accueil form = new Accueil();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);

        form.jLabelNomU.setText(this.jLabelNomU.getText());
        this.dispose();
    }//GEN-LAST:event_jLabelNomUMouseClicked

    private void serchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serchMouseClicked
        serch.setText("");
    }//GEN-LAST:event_serchMouseClicked

    private void serchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serchKeyTyped

        MyModelPersonnel model = (MyModelPersonnel) jTable1.getModel();
        String search = serch.getText().toLowerCase();
        TableRowSorter<MyModelPersonnel> tr = new TableRowSorter<MyModelPersonnel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_serchKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clearFields();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PersonnetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonnetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonnetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonnetForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonnetForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField AMDP;
    private javax.swing.JButton AjouterPersonnel;
    private javax.swing.JLabel Ancien;
    private javax.swing.JPasswordField MDP;
    private javax.swing.JTextField Matricule;
    private javax.swing.JButton Modifier;
    private javax.swing.JTextField NomP;
    private javax.swing.JLabel OBMP;
    private javax.swing.JLabel OBMP1;
    private javax.swing.JLabel OBcin;
    private javax.swing.JLabel OBmessage;
    private javax.swing.JLabel OBmessage1;
    private javax.swing.JLabel OBnom;
    private javax.swing.JLabel OBnum;
    private javax.swing.JLabel OBsolde;
    private javax.swing.JTextField PrenomP;
    private javax.swing.JButton Supprimer;
    private javax.swing.JPasswordField VMDP;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCompte;
    private javax.swing.JLabel jLabelDECONXION;
    public javax.swing.JLabel jLabelNomU;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextNomU1;
    private javax.swing.JLabel mdp;
    private javax.swing.JLabel mdp1;
    private javax.swing.JLabel mdp2;
    private javax.swing.JLabel mdp3;
    private javax.swing.JLabel mdp4;
    private javax.swing.JLabel mdp5;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField serch;
    // End of variables declaration//GEN-END:variables
}
