/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import oru.inf.*;
/**
 *
 * @author Lukas
 */
public class AgentOmrade extends javax.swing.JFrame {

    /**
     * Creates new form AgentAlien
     */
    public AgentOmrade() {
        initComponents();
        fillCmb();
        
    }
    
    private DefaultTableModel setTableModel()
    {
        DefaultTableModel tableModel = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
                {
                    //all cells false
                    return false;
                }
        };
        
        tableModel.addColumn("Agent namn");
        tableModel.addColumn("Antal Aliens");
        
        return tableModel;

    }
    
    public void setAgentNamn(String agent)
    {
        lblAgentNamn.setText(agent);
    }
    
    public void fillCmb()
    {
        try
        {
        String fraga = "select benamning from omrade";
        ArrayList<String> svar = DataBaseConnection.getDB().fetchColumn(fraga);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        cmbOmrade.setModel(model);
        
        for(String enStrang : svar)
        {
            model.addElement(enStrang);
        }
        }
        catch(Exception e)
        {
            
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFonster = new javax.swing.JPanel();
        pnlBorderBottom = new javax.swing.JPanel();
        cmbOmrade = new javax.swing.JComboBox<>();
        lblValjOmrade = new javax.swing.JLabel();
        btnOmradeSok = new javax.swing.JButton();
        pnlMiddle = new javax.swing.JPanel();
        lblOmradeschef = new javax.swing.JLabel();
        txtOmradeschef = new javax.swing.JTextField();
        lblTopp3 = new javax.swing.JLabel();
        lstTopp3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlBorderTop = new javax.swing.JPanel();
        lblRubrik = new javax.swing.JLabel();
        lblAgentIkon = new javax.swing.JLabel();
        lblAgentNamn = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1010, 635));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        pnlFonster.setBackground(new java.awt.Color(255, 255, 255));
        pnlFonster.setMaximumSize(new java.awt.Dimension(1000, 600));
        pnlFonster.setMinimumSize(new java.awt.Dimension(1000, 600));
        pnlFonster.setPreferredSize(new java.awt.Dimension(1000, 600));

        pnlBorderBottom.setBackground(new java.awt.Color(220, 220, 220));
        pnlBorderBottom.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlBorderBottom.setMaximumSize(new java.awt.Dimension(1000, 40));
        pnlBorderBottom.setMinimumSize(new java.awt.Dimension(1000, 40));
        pnlBorderBottom.setPreferredSize(new java.awt.Dimension(1000, 40));

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

        cmbOmrade.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        cmbOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Omr�de" }));
        cmbOmrade.setToolTipText("");
        cmbOmrade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cmbOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOmradeActionPerformed(evt);
            }
        });

        lblValjOmrade.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        lblValjOmrade.setText("V�lj omr�de:");

        btnOmradeSok.setBackground(new java.awt.Color(255, 255, 255));
        btnOmradeSok.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnOmradeSok.setText("S�k");
        btnOmradeSok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnOmradeSok.setContentAreaFilled(false);
        btnOmradeSok.setMaximumSize(new java.awt.Dimension(75, 30));
        btnOmradeSok.setMinimumSize(new java.awt.Dimension(75, 30));
        btnOmradeSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmradeSokActionPerformed(evt);
            }
        });

        pnlMiddle.setBackground(new java.awt.Color(255, 255, 255));
        pnlMiddle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlMiddle.setPreferredSize(new java.awt.Dimension(321, 250));

        lblOmradeschef.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        lblOmradeschef.setText("Omr�deschef:");

        txtOmradeschef.setEditable(false);
        txtOmradeschef.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtOmradeschef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTopp3.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        lblTopp3.setText("Topp 3 agenter med flest aliens:");

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Namn", "Antal Aliens"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        lstTopp3.setViewportView(jTable1);

        javax.swing.GroupLayout pnlMiddleLayout = new javax.swing.GroupLayout(pnlMiddle);
        pnlMiddle.setLayout(pnlMiddleLayout);
        pnlMiddleLayout.setHorizontalGroup(
            pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lstTopp3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTopp3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMiddleLayout.createSequentialGroup()
                        .addGroup(pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOmradeschef)
                            .addComponent(lblOmradeschef, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMiddleLayout.setVerticalGroup(
            pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMiddleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOmradeschef)
                .addGap(5, 5, 5)
                .addComponent(txtOmradeschef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(lblTopp3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lstTopp3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlBorderTop.setBackground(new java.awt.Color(220, 220, 220));
        pnlBorderTop.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pnlBorderTop.setMaximumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setMinimumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setPreferredSize(new java.awt.Dimension(1000, 80));

        lblRubrik.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        lblRubrik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRubrik.setText("Omr�de");
        lblRubrik.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblAgentIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/spy.png"))); // NOI18N

        lblAgentNamn.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lblAgentNamn.setText("Agent K");

        btnHome.setBackground(new java.awt.Color(220, 220, 220));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/home.png"))); // NOI18N
        btnHome.setBorder(null);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBorderTopLayout = new javax.swing.GroupLayout(pnlBorderTop);
        pnlBorderTop.setLayout(pnlBorderTopLayout);
        pnlBorderTopLayout.setHorizontalGroup(
            pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223)
                .addComponent(lblAgentIkon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgentNamn)
                .addGap(15, 15, 15))
        );
        pnlBorderTopLayout.setVerticalGroup(
            pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBorderTopLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                                .addComponent(lblAgentNamn)
                                .addGap(14, 14, 14))
                            .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAgentIkon))))
                    .addGroup(pnlBorderTopLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblRubrik)))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout pnlFonsterLayout = new javax.swing.GroupLayout(pnlFonster);
        pnlFonster.setLayout(pnlFonsterLayout);
        pnlFonsterLayout.setHorizontalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addComponent(pnlBorderBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addComponent(lblValjOmrade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOmradeSok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(327, 327, 327))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                .addComponent(pnlBorderTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlFonsterLayout.setVerticalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addComponent(pnlBorderTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValjOmrade)
                    .addComponent(btnOmradeSok, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212)
                .addComponent(pnlBorderBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOmradeActionPerformed
        String selected = cmbOmrade.getSelectedItem().toString();
    }//GEN-LAST:event_cmbOmradeActionPerformed

    private void btnOmradeSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmradeSokActionPerformed
        try
        {
        String selected = cmbOmrade.getSelectedItem().toString();
        //String fraga = "select omrades_id from omrade where benamning = '" + selected + "';";
        String fraga = "select namn from agent inner join omradeschef on agent.agent_id = omradeschef.agent_id inner join omrade on omradeschef.omrade = omrade.omrades_id where omrade.benamning = '" +
                selected + "';";
        String svar = (DataBaseConnection.getDB().fetchSingle(fraga));
        
        txtOmradeschef.setText(svar);
        }
        catch(Exception e)
        {
            
        }
        try
        {
            DefaultTableModel model = setTableModel();
            jTable1.setModel(model);
            String selected = cmbOmrade.getSelectedItem().toString();
            String fraga = "select agent.namn, count(alien.alien_id) as aliencount from alien inner join agent on agent.agent_id = alien.ansvarig_agent inner join omrade on omrade.OMRADES_ID = agent.OMRADE where omrade.BENAMNING = '" + selected + "' group by agent.namn"; 
            ArrayList<HashMap<String, String>> lista = DataBaseConnection.getDB().fetchRows(fraga);
            
            
            for(HashMap<String, String> map : lista)
            {
                String namn = "";
                String antal = "";
                
                for(String key : map.keySet())
                {
                    if(key.equals("ALIENCOUNT"))
                    {
                        antal = map.get(key);
                      
                    }
                    else if(key.equals("NAMN")) //MÅSTE GÖRA KLART DENNA DEL
                    {
                        namn = map.get(key);
                    }
                }
                model.addRow(new Object[] {namn, antal});               
            }
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_btnOmradeSokActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        AgentHome obj = new AgentHome();
        obj.setVisible(true);
        obj.setLocationRelativeTo(this);
        obj.setRubrikAgent(Inloggad.getNameInloggad());
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(AgentOmrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgentOmrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgentOmrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgentOmrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgentOmrade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnOmradeSok;
    private javax.swing.JComboBox<String> cmbOmrade;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAgentIkon;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JLabel lblOmradeschef;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTopp3;
    private javax.swing.JLabel lblValjOmrade;
    private javax.swing.JScrollPane lstTopp3;
    private javax.swing.JPanel pnlBorderBottom;
    private javax.swing.JPanel pnlBorderTop;
    private javax.swing.JPanel pnlFonster;
    private javax.swing.JPanel pnlMiddle;
    private javax.swing.JTextField txtOmradeschef;
    // End of variables declaration//GEN-END:variables
}
