package mib;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.*;

//Authors: Lukas, Daniel, Jonathan

public class AdminHome extends javax.swing.JFrame {

private static InfDB idb;
   
    public AdminHome() {
        initComponents();
        skrivUtInformation();
    }
    
    private void setRubrik(String agent)
    {
        lblRubrik.setText("Välkommen " + agent);
    }
    
    public void setAgentNamn(String agent)
    {
        lblAgentNamn.setText(agent);
    }
    
    public void setRubrikAgent(String agent)
    {
        setRubrik(agent);
        setAgentNamn(agent);
    }
    
    private void skrivUtInformation()
    {
        try
        {
        DefaultListModel model = new DefaultListModel();
        lstStatistik.setModel(model);
        
        String fragaAntalAliens = "select count(Alien_ID) from alien";
        String svarAntalAliens = DataBaseConnection.getDB().fetchSingle(fragaAntalAliens);
        model.addElement("Antal Aliens: " + svarAntalAliens);
        
        String fragaAntalBoglodite = "select count(Alien_ID) from boglodite";
        String svarAntalBoglodite = DataBaseConnection.getDB().fetchSingle(fragaAntalBoglodite);
        model.addElement("Antal Boglodites: " + svarAntalBoglodite);
        
        String fragaAntalWorm = "select count(Alien_ID) from worm";
        String svarAntalWorm = DataBaseConnection.getDB().fetchSingle(fragaAntalWorm);
        model.addElement("Antal Worms: " + svarAntalWorm);
        
        String fragaAntalSquid = "select count(Alien_ID) from squid";
        String svarAntalSquid = DataBaseConnection.getDB().fetchSingle(fragaAntalSquid);
        model.addElement("Antal Squids: " + svarAntalSquid);
        
        String fragaAntalAgenter = "select count(agent_id) from agent";
        String svarAntalAgenter = DataBaseConnection.getDB().fetchSingle(fragaAntalAgenter);
        model.addElement("Antal Agenter: " + svarAntalAgenter);
        
        String fragaAntalFordon = "select count(fordons_id) from fordon";
        String svarAntalFordon = DataBaseConnection.getDB().fetchSingle(fragaAntalFordon);
        model.addElement("Antal Fordon: " + svarAntalFordon);
        
        String fragaAntalUtrustning = "select count(Utrustnings_id) from utrustning";
        String svarAntalUtrustning = DataBaseConnection.getDB().fetchSingle(fragaAntalUtrustning);
        model.addElement("Antal Utrustningar: " + svarAntalUtrustning);
        
        
        
        }
        catch(Exception e)
        {
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFonster = new javax.swing.JPanel();
        pnlBorderTop = new javax.swing.JPanel();
        lblRubrik = new javax.swing.JLabel();
        lblAgentNamn = new javax.swing.JLabel();
        lblAgentIkon = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        lblAdmin = new javax.swing.JLabel();
        pnlAliens = new javax.swing.JPanel();
        btnAdminAlien = new javax.swing.JButton();
        pnlAgenter = new javax.swing.JPanel();
        btnAdminAgenter = new javax.swing.JButton();
        pnlUtrustning = new javax.swing.JPanel();
        btnAdminUtrustning = new javax.swing.JButton();
        pnlLosenord = new javax.swing.JPanel();
        btnAdminBytLosenord = new javax.swing.JButton();
        btnAdminLoggaUt = new javax.swing.JButton();
        pnlBorderBottom = new javax.swing.JPanel();
        scpStatistik = new javax.swing.JScrollPane();
        lstStatistik = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        pnlFonster.setBackground(new java.awt.Color(255, 255, 255));
        pnlFonster.setMaximumSize(new java.awt.Dimension(1000, 640));
        pnlFonster.setMinimumSize(new java.awt.Dimension(1000, 640));
        pnlFonster.setName(""); // NOI18N
        pnlFonster.setPreferredSize(new java.awt.Dimension(1000, 640));

        pnlBorderTop.setBackground(new java.awt.Color(220, 220, 220));
        pnlBorderTop.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pnlBorderTop.setMaximumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setMinimumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setPreferredSize(new java.awt.Dimension(1000, 80));

        lblRubrik.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        lblRubrik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRubrik.setText("Välkommen Agent J!");

        lblAgentNamn.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lblAgentNamn.setText("Agent J");

        lblAgentIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/spy.png"))); // NOI18N

        btnHome.setBackground(new java.awt.Color(220, 220, 220));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/home.png"))); // NOI18N
        btnHome.setBorder(null);

        lblAdmin.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblAdmin.setText("Admin");

        javax.swing.GroupLayout pnlBorderTopLayout = new javax.swing.GroupLayout(pnlBorderTop);
        pnlBorderTop.setLayout(pnlBorderTopLayout);
        pnlBorderTopLayout.setHorizontalGroup(
            pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286)
                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(lblAgentIkon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgentNamn)
                    .addComponent(lblAdmin))
                .addGap(19, 19, 19))
        );
        pnlBorderTopLayout.setVerticalGroup(
            pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBorderTopLayout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBorderTopLayout.createSequentialGroup()
                        .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRubrik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlBorderTopLayout.createSequentialGroup()
                                        .addComponent(lblAgentNamn)
                                        .addGap(4, 4, 4)
                                        .addComponent(lblAdmin))
                                    .addComponent(lblAgentIkon))))
                        .addContainerGap())))
        );

        pnlAliens.setBackground(new java.awt.Color(255, 255, 255));
        pnlAliens.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlAliens.setMaximumSize(new java.awt.Dimension(200, 175));
        pnlAliens.setMinimumSize(new java.awt.Dimension(200, 175));

        btnAdminAlien.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminAlien.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnAdminAlien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/alien.png"))); // NOI18N
        btnAdminAlien.setText("Aliens");
        btnAdminAlien.setContentAreaFilled(false);
        btnAdminAlien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminAlien.setIconTextGap(8);
        btnAdminAlien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminAlienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAliensLayout = new javax.swing.GroupLayout(pnlAliens);
        pnlAliens.setLayout(pnlAliensLayout);
        pnlAliensLayout.setHorizontalGroup(
            pnlAliensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlAliensLayout.setVerticalGroup(
            pnlAliensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlAgenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlAgenter.setMaximumSize(new java.awt.Dimension(200, 175));
        pnlAgenter.setMinimumSize(new java.awt.Dimension(200, 175));

        btnAdminAgenter.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminAgenter.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnAdminAgenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/spy.png"))); // NOI18N
        btnAdminAgenter.setText("Agenter");
        btnAdminAgenter.setContentAreaFilled(false);
        btnAdminAgenter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminAgenter.setIconTextGap(8);
        btnAdminAgenter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminAgenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminAgenterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAgenterLayout = new javax.swing.GroupLayout(pnlAgenter);
        pnlAgenter.setLayout(pnlAgenterLayout);
        pnlAgenterLayout.setHorizontalGroup(
            pnlAgenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlAgenterLayout.setVerticalGroup(
            pnlAgenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlUtrustning.setBackground(new java.awt.Color(255, 255, 255));
        pnlUtrustning.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlUtrustning.setMaximumSize(new java.awt.Dimension(200, 175));
        pnlUtrustning.setMinimumSize(new java.awt.Dimension(200, 175));

        btnAdminUtrustning.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminUtrustning.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnAdminUtrustning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/binoculars.png"))); // NOI18N
        btnAdminUtrustning.setText("Utrustning");
        btnAdminUtrustning.setContentAreaFilled(false);
        btnAdminUtrustning.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminUtrustning.setIconTextGap(8);
        btnAdminUtrustning.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminUtrustningActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUtrustningLayout = new javax.swing.GroupLayout(pnlUtrustning);
        pnlUtrustning.setLayout(pnlUtrustningLayout);
        pnlUtrustningLayout.setHorizontalGroup(
            pnlUtrustningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlUtrustningLayout.setVerticalGroup(
            pnlUtrustningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlLosenord.setBackground(new java.awt.Color(255, 255, 255));
        pnlLosenord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlLosenord.setMaximumSize(new java.awt.Dimension(200, 175));
        pnlLosenord.setMinimumSize(new java.awt.Dimension(200, 175));

        btnAdminBytLosenord.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminBytLosenord.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnAdminBytLosenord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/password(2).png"))); // NOI18N
        btnAdminBytLosenord.setText("Byt lösenord");
        btnAdminBytLosenord.setContentAreaFilled(false);
        btnAdminBytLosenord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminBytLosenord.setIconTextGap(8);
        btnAdminBytLosenord.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminBytLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminBytLosenordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLosenordLayout = new javax.swing.GroupLayout(pnlLosenord);
        pnlLosenord.setLayout(pnlLosenordLayout);
        pnlLosenordLayout.setHorizontalGroup(
            pnlLosenordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminBytLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlLosenordLayout.setVerticalGroup(
            pnlLosenordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminBytLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnAdminLoggaUt.setBackground(new java.awt.Color(255, 255, 255));
        btnAdminLoggaUt.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnAdminLoggaUt.setText("Logga ut");
        btnAdminLoggaUt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAdminLoggaUt.setContentAreaFilled(false);
        btnAdminLoggaUt.setMaximumSize(new java.awt.Dimension(75, 30));
        btnAdminLoggaUt.setMinimumSize(new java.awt.Dimension(75, 30));
        btnAdminLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoggaUtActionPerformed(evt);
            }
        });

        pnlBorderBottom.setBackground(new java.awt.Color(220, 220, 220));
        pnlBorderBottom.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlBorderBottom.setMaximumSize(new java.awt.Dimension(1000, 40));
        pnlBorderBottom.setMinimumSize(new java.awt.Dimension(1000, 40));

        javax.swing.GroupLayout pnlBorderBottomLayout = new javax.swing.GroupLayout(pnlBorderBottom);
        pnlBorderBottom.setLayout(pnlBorderBottomLayout);
        pnlBorderBottomLayout.setHorizontalGroup(
            pnlBorderBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        pnlBorderBottomLayout.setVerticalGroup(
            pnlBorderBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        lstStatistik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        scpStatistik.setViewportView(lstStatistik);

        javax.swing.GroupLayout pnlFonsterLayout = new javax.swing.GroupLayout(pnlFonster);
        pnlFonster.setLayout(pnlFonsterLayout);
        pnlFonsterLayout.setHorizontalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBorderTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBorderBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(pnlAliens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdminLoggaUt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(scpStatistik, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFonsterLayout.setVerticalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addComponent(pnlBorderTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdminLoggaUt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scpStatistik)
                            .addGroup(pnlFonsterLayout.createSequentialGroup()
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlAliens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pnlBorderBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFonster, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminBytLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminBytLosenordActionPerformed
        BytaLosenord byta = new BytaLosenord();
        byta.setVisible(true);
        byta.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnAdminBytLosenordActionPerformed

    private void btnAdminAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminAlienActionPerformed
        AdminAliens obj = new AdminAliens();
        obj.setVisible(true);
        obj.setLocationRelativeTo(this);
        obj.setAgentNamn(Inloggad.getNameInloggad());
        this.dispose();           
    }//GEN-LAST:event_btnAdminAlienActionPerformed

    private void btnAdminAgenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminAgenterActionPerformed
        AdminAgenter obj = new AdminAgenter();
        obj.setVisible(true);
        obj.setLocationRelativeTo(this);
        obj.setAgentNamn(Inloggad.getNameInloggad());
        this.dispose(); 
    }//GEN-LAST:event_btnAdminAgenterActionPerformed

    private void btnAdminUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminUtrustningActionPerformed
        AdminUtrustning obj = new AdminUtrustning();
        obj.setVisible(true);
        obj.setLocationRelativeTo(this);
        obj.setAgentNamn(Inloggad.getNameInloggad());
        this.dispose();
    }//GEN-LAST:event_btnAdminUtrustningActionPerformed

    private void btnAdminLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoggaUtActionPerformed
        int optionPane = JOptionPane.showConfirmDialog(null, "Vill du logga ut?", "Logga ut" , JOptionPane.YES_NO_OPTION);
        if(optionPane == JOptionPane.YES_OPTION)
        {
            mib.Start.main(null);
            this.dispose();
        }
        else
        {     
        }
    }//GEN-LAST:event_btnAdminLoggaUtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminAgenter;
    private javax.swing.JButton btnAdminAlien;
    private javax.swing.JButton btnAdminBytLosenord;
    private javax.swing.JButton btnAdminLoggaUt;
    private javax.swing.JButton btnAdminUtrustning;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAgentIkon;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JList<String> lstStatistik;
    private javax.swing.JPanel pnlAgenter;
    private javax.swing.JPanel pnlAliens;
    private javax.swing.JPanel pnlBorderBottom;
    private javax.swing.JPanel pnlBorderTop;
    private javax.swing.JPanel pnlFonster;
    private javax.swing.JPanel pnlLosenord;
    private javax.swing.JPanel pnlUtrustning;
    private javax.swing.JScrollPane scpStatistik;
    // End of variables declaration//GEN-END:variables
}
