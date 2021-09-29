package mib;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;

//Authors: Lukas, Daniel, Jonathan
public class AdminAgenter extends javax.swing.JFrame {
    
    public AdminAgenter() {
        initComponents();
        setTableModel();
    }
    
    //Sätter labeln för agentnamn till värdet av den inloggade agentens namn
    public void setAgentNamn(String agent)
    {
        lblAgentNamn.setText(agent);
    }
    
    //Skapar en tabell över alla agenter i databasen
    public void skapaListaAlla()
    {
        try
        {
            DefaultTableModel model = setTableModel();
            tblAgent.setModel(model);
            String fraga = "SELECT * FROM Agent";
            ArrayList<HashMap<String, String>> lista = DataBaseConnection.getDB().fetchRows(fraga);

            for(HashMap<String, String> map : lista)
            {
                String agentID = "";
                String namn = "";
                String telefon = "";
                String anstallningsdatum = "";
                String administrator = "";
                String position = "";
                String omrade = "";
                String omradeKonverterad = "";
                
                for(String key : map.keySet())
                {
                    if(key.equals("AGENT_ID"))
                    {
                        agentID = map.get(key);            
                    }
                    else if(key.equals("NAMN")) 
                    {
                        namn = map.get(key);
                    }
                    else if(key.equals("TELEFON"))
                    {
                        telefon = map.get(key);
                    }
                    else if(key.equals("ANSTALLNINGSDATUM"))
                    {
                        anstallningsdatum = map.get(key);
                    }
                    else if(key.equals("ADMINISTRATOR"))
                    {
                        administrator = map.get(key);
                    }
                    else if(key.equals("OMRADE"))
                    {
                        omrade = map.get(key);
                        String fragaOmrade = "SELECT BENAMNING FROM OMRADE WHERE OMRADES_ID = " + omrade;
                        omradeKonverterad = DataBaseConnection.getDB().fetchSingle(fragaOmrade);
                    }
                }
                String [] positionen = {"FALTAGENT", "KONTORSCHEF", "OMRADESCHEF"};
                    for(String enStrang : positionen)
                    {
                        String antiBreakage = "SELECT COUNT(*) AS ROWCOUNT FROM " + enStrang;
                        String svar = DataBaseConnection.getDB().fetchSingle(antiBreakage);
                        int svar2 = Integer.parseInt(svar);
                        
                        if( svar2 == 0)
                        {
                            continue;
                        }
                        
                        String positionFraga = "SELECT AGENT_ID FROM " + enStrang + "";
                        ArrayList<HashMap<String, String>> listan = DataBaseConnection.getDB().fetchRows(positionFraga);
                        
                        for(HashMap<String, String> map2 : listan)
                        {
                            for(String strangen : map2.keySet())                               
                            {
                                if(map2.get(strangen).equals(agentID))                               
                                {
                                    position = enStrang;
                                    System.out.println(position);
                                }
                            }
                        }  
                    }
                    System.out.println(agentID + " " + namn + " " + telefon);
                
                model.addRow(new Object[] {agentID, namn, telefon, anstallningsdatum, administrator, position, omradeKonverterad});
                
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
    //Tömmer alla textrutor
    private void clearBoxes()
    {
        txtAgentID.setText("");
        txtNamn.setText("");
        txtTelefon.setText("");
        txtAnstallningsdatum.setText("");
        txtOmrade.setText("");
        chkOmradesChef.setSelected(false);
        chkKontorsChef.setSelected(false);
        chkAdmin.setSelected(false);
        txtAgentID.setEditable(true);
    }
    
    //Skapar en table model med oredigerbara celler som används i de metoder som instansierar tabeller
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
        
        tableModel.addColumn("Agent ID");
        tableModel.addColumn("Namn");
        tableModel.addColumn("Telefon");
        tableModel.addColumn("Anställningsdatum");
        tableModel.addColumn("Administratör");
        tableModel.addColumn("Position");
        tableModel.addColumn("Område");
        
        return tableModel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox7 = new javax.swing.JCheckBox();
        pnlFonster = new javax.swing.JPanel();
        pnlBorderTop = new javax.swing.JPanel();
        lblRubrik = new javax.swing.JLabel();
        lblAgentIkon = new javax.swing.JLabel();
        lblAgentNamn = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        pnlBorderBottom = new javax.swing.JPanel();
        lblValjAlien = new javax.swing.JLabel();
        btnSok = new javax.swing.JButton();
        lblAgentID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblPlats = new javax.swing.JLabel();
        lblAnsvarigAgent = new javax.swing.JLabel();
        txtAgentID = new javax.swing.JTextField();
        txtNamn = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtAnstallningsdatum = new javax.swing.JTextField();
        txtOmrade = new javax.swing.JTextField();
        txtSokAgent = new javax.swing.JTextField();
        btnRegistreraAgent = new javax.swing.JButton();
        btnRaderaAgent = new javax.swing.JButton();
        btnAndraAgent = new javax.swing.JButton();
        btnTomFalt = new javax.swing.JButton();
        btnListaAlla = new javax.swing.JButton();
        lblInstruktioner = new javax.swing.JLabel();
        chkOmradesChef = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        chkAdmin = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chkKontorsChef = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        lstAgent = new javax.swing.JScrollPane();
        tblAgent = new javax.swing.JTable();

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCheckBox7.setContentAreaFilled(false);
        jCheckBox7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox7.setMaximumSize(new java.awt.Dimension(26, 26));
        jCheckBox7.setMinimumSize(new java.awt.Dimension(26, 26));
        jCheckBox7.setPreferredSize(new java.awt.Dimension(26, 26));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        pnlFonster.setBackground(new java.awt.Color(255, 255, 255));
        pnlFonster.setMaximumSize(new java.awt.Dimension(1000, 600));
        pnlFonster.setMinimumSize(new java.awt.Dimension(1000, 600));
        pnlFonster.setPreferredSize(new java.awt.Dimension(1000, 600));

        pnlBorderTop.setBackground(new java.awt.Color(220, 220, 220));
        pnlBorderTop.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pnlBorderTop.setMaximumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setMinimumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setPreferredSize(new java.awt.Dimension(1000, 80));

        lblRubrik.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        lblRubrik.setText("Agent");

        lblAgentIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/spy.png"))); // NOI18N

        lblAgentNamn.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lblAgentNamn.setText("Agent K");

        lblAdmin.setFont(new java.awt.Font("Open Sans", 3, 10)); // NOI18N
        lblAdmin.setText("Admin");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRubrik)
                .addGap(320, 320, 320)
                .addComponent(lblAgentIkon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgentNamn)
                    .addComponent(lblAdmin))
                .addGap(15, 15, 15))
        );
        pnlBorderTopLayout.setVerticalGroup(
            pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBorderTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                                .addComponent(lblAgentNamn)
                                .addGap(0, 0, 0)
                                .addComponent(lblAdmin))
                            .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAgentIkon))))
                    .addGroup(pnlBorderTopLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblRubrik)))
                .addContainerGap(3, Short.MAX_VALUE))
        );

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

        lblValjAlien.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        lblValjAlien.setText("Välj Agent:");

        btnSok.setBackground(new java.awt.Color(255, 255, 255));
        btnSok.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        btnSok.setText("Sök");
        btnSok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSok.setContentAreaFilled(false);
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        lblAgentID.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblAgentID.setText("Agent ID:");

        lblNamn.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblNamn.setText("Namn:");

        lblTelefon.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblTelefon.setText("Telefonnummer:");

        lblPlats.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblPlats.setText("Anställningsdatum:");

        lblAnsvarigAgent.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblAnsvarigAgent.setText("Område:");

        txtAgentID.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtAgentID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNamn.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtNamn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTelefon.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtTelefon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAnstallningsdatum.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtAnstallningsdatum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtOmrade.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtOmrade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSokAgent.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtSokAgent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRegistreraAgent.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistreraAgent.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnRegistreraAgent.setText("Registrera ny Agent");
        btnRegistreraAgent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRegistreraAgent.setContentAreaFilled(false);
        btnRegistreraAgent.setMaximumSize(new java.awt.Dimension(75, 30));
        btnRegistreraAgent.setMinimumSize(new java.awt.Dimension(75, 30));
        btnRegistreraAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreraAgentActionPerformed(evt);
            }
        });

        btnRaderaAgent.setBackground(new java.awt.Color(255, 255, 255));
        btnRaderaAgent.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnRaderaAgent.setText("Radera Agent");
        btnRaderaAgent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRaderaAgent.setContentAreaFilled(false);
        btnRaderaAgent.setMaximumSize(new java.awt.Dimension(75, 30));
        btnRaderaAgent.setMinimumSize(new java.awt.Dimension(75, 30));
        btnRaderaAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaderaAgentActionPerformed(evt);
            }
        });

        btnAndraAgent.setBackground(new java.awt.Color(255, 255, 255));
        btnAndraAgent.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        btnAndraAgent.setText("Ändra");
        btnAndraAgent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAndraAgent.setContentAreaFilled(false);
        btnAndraAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraAgentActionPerformed(evt);
            }
        });

        btnTomFalt.setBackground(new java.awt.Color(255, 255, 255));
        btnTomFalt.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        btnTomFalt.setText("Töm fält");
        btnTomFalt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnTomFalt.setContentAreaFilled(false);
        btnTomFalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomFaltActionPerformed(evt);
            }
        });

        btnListaAlla.setBackground(new java.awt.Color(255, 255, 255));
        btnListaAlla.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnListaAlla.setText("Lista alla Agenter");
        btnListaAlla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnListaAlla.setContentAreaFilled(false);
        btnListaAlla.setMaximumSize(new java.awt.Dimension(75, 30));
        btnListaAlla.setMinimumSize(new java.awt.Dimension(75, 30));
        btnListaAlla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaAllaActionPerformed(evt);
            }
        });

        lblInstruktioner.setFont(new java.awt.Font("Open Sans Semibold", 2, 12)); // NOI18N
        lblInstruktioner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstruktioner.setText("Ändra eller lägg till en Agent");
        lblInstruktioner.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        chkOmradesChef.setBackground(new java.awt.Color(255, 255, 255));
        chkOmradesChef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        chkOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOmradesChefActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Områdeschef");

        chkAdmin.setBackground(new java.awt.Color(255, 255, 255));
        chkAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Administratör");

        jLabel3.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Kontorschef");

        chkKontorsChef.setBackground(new java.awt.Color(255, 255, 255));
        chkKontorsChef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        chkKontorsChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkKontorsChefActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        tblAgent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblAgent.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        tblAgent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAgent.setSelectionBackground(new java.awt.Color(220, 220, 220));
        tblAgent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgentMouseClicked(evt);
            }
        });
        lstAgent.setViewportView(tblAgent);

        javax.swing.GroupLayout pnlFonsterLayout = new javax.swing.GroupLayout(pnlFonster);
        pnlFonster.setLayout(pnlFonsterLayout);
        pnlFonsterLayout.setHorizontalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFonsterLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentID)
                            .addComponent(lblNamn)
                            .addComponent(lblTelefon)
                            .addComponent(lblAnsvarigAgent)
                            .addComponent(lblPlats))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAndraAgent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkOmradesChef)
                                    .addComponent(chkAdmin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addComponent(btnTomFalt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistreraAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAgentID)
                    .addComponent(txtNamn)
                    .addComponent(txtTelefon)
                    .addComponent(txtAnstallningsdatum)
                    .addComponent(txtOmrade)
                    .addComponent(lblInstruktioner, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addComponent(chkKontorsChef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFonsterLayout.createSequentialGroup()
                                .addComponent(lblValjAlien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSokAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lstAgent))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnRaderaAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnListaAlla, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBorderBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBorderTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFonsterLayout.setVerticalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addComponent(pnlBorderTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValjAlien)
                    .addComponent(txtSokAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSok)
                    .addComponent(lblInstruktioner))
                .addGap(18, 18, 18)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFonsterLayout.createSequentialGroup()
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAgentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAgentID))
                                .addGap(24, 24, 24)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNamn))
                                .addGap(24, 24, 24)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefon))
                                .addGap(24, 24, 24)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAnstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPlats))
                                .addGap(24, 24, 24)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAnsvarigAgent))
                                .addGap(10, 10, 10)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkOmradesChef)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkKontorsChef, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkAdmin)))
                    .addComponent(lstAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAndraAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTomFalt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnListaAlla, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRaderaAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegistreraAgent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79)
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

    //Skapar en tabell över agenter vars namn matchar söktermen i sökrutan.
    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        clearBoxes();
        if(Validation.isNotEmpty(txtSokAgent))
        {
        try
        {
            DefaultTableModel model = setTableModel();
            tblAgent.setModel(model);
            String sokOrd = txtSokAgent.getText().toLowerCase();
            String fraga = "SELECT * FROM Agent";
            ArrayList<HashMap<String, String>> lista = DataBaseConnection.getDB().fetchRows(fraga);
            
            for(HashMap<String, String> map : lista)
            {
                String agentID = "";
                String namn = "";
                String telefon = "";
                String anstallningsdatum = "";
                String administrator = "";
                String position = "";
                String omrade = "";
                String omradeKonverterad = "";
                
                for(String key : map.keySet())
                {
                    if(key.equals("AGENT_ID"))
                    {
                        agentID = map.get(key);            
                    }
                    else if(key.equals("NAMN")) 
                    {
                        namn = map.get(key);
                    }
                    else if(key.equals("TELEFON"))
                    {
                        telefon = map.get(key);
                    }
                    else if(key.equals("ANSTALLNINGSDATUM"))
                    {
                        anstallningsdatum = map.get(key);
                    }
                    else if(key.equals("ADMINISTRATOR"))
                    {
                        administrator = map.get(key);
                    }
                    else if(key.equals("OMRADE"))
                    {
                        omrade = map.get(key);
                        String fragaOmrade = "SELECT BENAMNING FROM OMRADE WHERE OMRADES_ID = " + omrade;
                        omradeKonverterad = DataBaseConnection.getDB().fetchSingle(fragaOmrade);
                    }
                }
                
                String [] positionen = {"FALTAGENT", "KONTORSCHEF", "OMRADESCHEF"};
                    for(String enStrang : positionen)
                    {
                        String antiBreakage = "SELECT COUNT(*) AS ROWCOUNT FROM " + enStrang;
                        String svar = DataBaseConnection.getDB().fetchSingle(antiBreakage);
                        int svar2 = Integer.parseInt(svar);
                        
                        if( svar2 == 0)
                        {
                            continue;
                        }
                        
                        String positionFraga = "SELECT AGENT_ID FROM " + enStrang + "";
                        ArrayList<HashMap<String, String>> listan = DataBaseConnection.getDB().fetchRows(positionFraga);
                        
                        for(HashMap<String, String> map2 : listan)
                        {
                            for(String strangen : map2.keySet())                               
                            {
                                if(map2.get(strangen).equals(agentID))                               
                                {
                                    position = enStrang;
                                }
                            }
                        }  
                    }
                String namnet = namn.toLowerCase();
                if(namnet.contains(sokOrd) || agentID.contains(sokOrd))
                {
                    model.addRow(new Object[] {agentID, namn, telefon, anstallningsdatum, administrator, position, omradeKonverterad});
                }
            }
        }
        catch(Exception e)
        {
            
        }
        }
    }//GEN-LAST:event_btnSokActionPerformed

    //Registrerar en ny agent.
    private void btnRegistreraAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreraAgentActionPerformed
        if(Validation.isNotEmpty(txtAgentID) && Validation.isNotEmpty(txtNamn) && Validation.isNotEmpty(txtOmrade) && Validation.isNotEmpty(txtTelefon) && Validation.isNotEmpty(txtAnstallningsdatum) && Validation.isHeltal(txtAgentID) && Validation.isOmrade(txtOmrade) && Validation.isTelefon(txtTelefon) && Validation.isCorrectDateFormat(txtAnstallningsdatum)&& !Validation.existingID(txtAgentID, "agent"))
        {    
        try{
        
            int nyttID = Integer.parseInt(txtAgentID.getText());
        
            String namnUpperCase = txtNamn.getText().substring(0,1).toUpperCase();
            String namnLowerCase = txtNamn.getText().substring(1);
            String namn = namnUpperCase + namnLowerCase;
        
            String telefon = txtTelefon.getText();
        
            String anstallningsDatum = txtAnstallningsdatum.getText();
        
            String omradeFraga = "SELECT OMRADES_ID FROM OMRADE WHERE BENAMNING = '" + txtOmrade.getText() + "'";
            String omrade = DataBaseConnection.getDB().fetchSingle(omradeFraga);
       
            String admin = "";
            InfDB databas = DataBaseConnection.getDB();
            if(chkOmradesChef.isSelected())
            {
                String omradesChefFraga = "INSERT INTO OMRADESCHEF VALUES (" + txtAgentID.getText() + "," + omrade + ")";
                databas.insert(omradesChefFraga);
                String faltAgentFraga = "INSERT INTO FALTAGENT VALUES (" + txtAgentID.getText() + ")";
                databas.insert(faltAgentFraga);
            }
            if(chkKontorsChef.isSelected())
            {
                String kontorsChefFraga = "INSERT INTO KONTORSCHEF VALUES (" + txtAgentID.getText() + "," + omrade + ")";
                databas.insert(kontorsChefFraga);
                String faltAgentFraga = "INSERT INTO FALTAGENT VALUES (" + txtAgentID.getText() + ")";
                databas.insert(faltAgentFraga);
            }
            if(!chkKontorsChef.isSelected() && !chkOmradesChef.isSelected())
            {
                String faltAgentFraga = "INSERT INTO FALTAGENT VALUES (" + txtAgentID.getText() + ")";
                databas.insert(faltAgentFraga);
            }
            if(chkAdmin.isSelected())
            {
                admin = admin + "J";
            }
            else
            {
                admin = admin + "N";
            }
        
            String password = "agent";
        
            String fraga = "INSERT INTO AGENT VALUES (" + nyttID + ", '" + namn + "','" + telefon + "','" + anstallningsDatum + "','"+ admin + "','" + password + "'," + omrade + ")";
            
            databas.insert(fraga);
            JOptionPane.showMessageDialog(null, "Agenten har lagts till! Lösenord: agent");
            clearBoxes();
            skapaListaAlla();
 
            }
        catch(InfException e)
        {
       
        }
        }
    }//GEN-LAST:event_btnRegistreraAgentActionPerformed

    //Raderar den valda agenten i tabellen från databasen
    private void btnRaderaAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaderaAgentActionPerformed
        int optionPane = JOptionPane.showConfirmDialog(null, "Vill du radera agenten?", "Radera agent" , JOptionPane.YES_NO_OPTION);
        if(optionPane == JOptionPane.YES_OPTION)
        {
        int selectedRow = tblAgent.getSelectedRow();
        String strang = "" + tblAgent.getValueAt(selectedRow, 0);
        int index = Integer.parseInt(strang);
        if(Validation.isNotSelectedjTable(tblAgent) && Validation.isSame(index))   
            try
            {    
                InfDB databas = DataBaseConnection.getDB();
                
                if(tblAgent.getValueAt(selectedRow, 5).equals("OMRADESCHEF") || tblAgent.getValueAt(selectedRow, 5).equals("KONTORSCHEF"))
                {
                    String fragan2 = "DELETE FROM " + tblAgent.getValueAt(selectedRow, 5) + " WHERE AGENT_ID = " + tblAgent.getValueAt(selectedRow, 0);
                    databas.delete(fragan2);
                    
                }
                String fraga3 = "DELETE FROM FALTAGENT WHERE AGENT_ID = " + tblAgent.getValueAt(selectedRow, 0);
                databas.delete(fraga3);
                String fragaAlien = "SELECT ANSVARIG_AGENT FROM ALIEN";
                ArrayList<HashMap<String, String>> svarAlien = databas.fetchRows(fragaAlien);
                for(HashMap<String, String> map : svarAlien)
                {
                    for(String enStrang : map.keySet())
                    {
                        System.out.println("Rowcount " + tblAgent.getRowCount());
                        System.out.println("SelectedRow " + selectedRow);
                        System.out.println("SelectedRow + 1 " + (selectedRow + 1));
                        if(map.get(enStrang).equals(tblAgent.getValueAt(selectedRow, 0)))
                        {
                            if((selectedRow + 2) <= tblAgent.getRowCount())
                            {   
                                String alienFraga = "UPDATE ALIEN SET ANSVARIG_AGENT = " + tblAgent.getValueAt((selectedRow + 1),0) + " WHERE ANSVARIG_AGENT = " + tblAgent.getValueAt(selectedRow, 0);
                                databas.update(alienFraga);
                                
                            }
                            else
                            {
                                String alienFraga = "UPDATE ALIEN SET ANSVARIG_AGENT = " + tblAgent.getValueAt((selectedRow - 1),0) + " WHERE ANSVARIG_AGENT = " + tblAgent.getValueAt(selectedRow, 0);
                                databas.update(alienFraga);
                            }
                                                       
                        }
                    }
                    
                }
                String utrustningFraga = "DELETE FROM INNEHAR_UTRUSTNING WHERE AGENT_ID = " + tblAgent.getValueAt(selectedRow, 0);
                databas.delete(utrustningFraga); 
                String fragan = "";
                fragan = "DELETE FROM AGENT WHERE AGENT_ID = " + tblAgent.getValueAt(selectedRow, 0);
                databas.delete(fragan);
                JOptionPane.showMessageDialog(null, "Agenten har raderats!");
                clearBoxes();
                skapaListaAlla();   
            }
   
            catch(InfException e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnRaderaAgentActionPerformed

    //Ändrar värdena i databasen för den valda agenten i tabellen
    private void btnAndraAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraAgentActionPerformed
        
        if(Validation.isNotEmpty(txtAgentID) && Validation.isNotEmpty(txtNamn) && Validation.isNotEmpty(txtOmrade) && Validation.isNotEmpty(txtTelefon) && Validation.isNotEmpty(txtAnstallningsdatum) && Validation.isHeltal(txtAgentID) && Validation.isOmrade(txtOmrade) && Validation.isTelefon(txtTelefon) && Validation.isCorrectDateFormat(txtAnstallningsdatum))
        {
            try
            {
                InfDB databas = DataBaseConnection.getDB();
                String isAdmin = "";
                String omradeFraga = "SELECT OMRADES_ID FROM OMRADE WHERE BENAMNING = '" + txtOmrade.getText() + "'";
                String omrade = DataBaseConnection.getDB().fetchSingle(omradeFraga);
                if(chkOmradesChef.isSelected())
                {
                    String omradesChefFraga = "INSERT INTO OMRADESCHEF VALUES (" + txtAgentID.getText() + "," + omrade + ")";
                    databas.insert(omradesChefFraga);
                    String faltAgentFraga = "DELETE FROM FALTAGENT WHERE AGENT_ID = " + txtAgentID.getText();
                    databas.delete(faltAgentFraga);
                }
                else if(!chkOmradesChef.isSelected())
                {
                    String omradesChefFraga = "DELETE FROM OMRADESCHEF WHERE AGENT_ID = " + txtAgentID.getText() + "";
                    databas.delete(omradesChefFraga);
                }
                if(chkKontorsChef.isSelected())
                {
                    String kontorsChefFraga = "INSERT INTO KONTORSCHEF VALUES (" + txtAgentID.getText() + "," + omrade + ")";
                    databas.insert(kontorsChefFraga);
                    String faltAgentFraga = "DELETE FROM FALTAGENT WHERE AGENT_ID = " + txtAgentID.getText();
                    databas.delete(faltAgentFraga);
                }
                else if(!chkKontorsChef.isSelected())
                {
                    String kontorsChefFraga = "DELETE FROM KONTORSCHEF WHERE AGENT_ID = " + txtAgentID.getText() + "";
                    databas.delete(kontorsChefFraga);
                }
                if(chkAdmin.isSelected())
                {
                    isAdmin = isAdmin + ",administrator = 'J'";
                }
                else
                {
                    isAdmin = isAdmin + ",administrator = 'N'";
                }
                String fraga = "update agent set namn = '" + txtNamn.getText() + "', telefon = '" + txtTelefon.getText() + "'" + isAdmin + ", anstallningsdatum = '" + txtAnstallningsdatum.getText() + "', omrade = " + omrade + " where agent_id = '" + txtAgentID.getText() + "'";
                databas.update(fraga);
                JOptionPane.showMessageDialog(null, "Agenten har ändrats!");
                clearBoxes();
                skapaListaAlla();
            }
            catch(Exception e)
            {
                
            }
        }
    }//GEN-LAST:event_btnAndraAgentActionPerformed

    //Tömmer alla textrutor
    private void btnTomFaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomFaltActionPerformed
        clearBoxes();
    }//GEN-LAST:event_btnTomFaltActionPerformed

    //Skapar en tabell med alla agenter i databasen
    private void btnListaAllaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAllaActionPerformed
        clearBoxes();
        skapaListaAlla();
    }//GEN-LAST:event_btnListaAllaActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        AdminHome obj = new AdminHome();
        obj.setVisible(true);
        obj.setLocationRelativeTo(this);
        obj.setRubrikAgent(Inloggad.getNameInloggad());
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    //Fyller textrutorna med värdena i databasen för den agent som är vald i tabellen
    private void tblAgentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgentMouseClicked
        clearBoxes();
        String svar = "";
        int selectedRow = tblAgent.getSelectedRow();
        int tal = tblAgent.getColumnCount();
        int [] selectedColumns = tblAgent.getSelectedColumns();
        for(int i = 0; i< tal; i++)
        {
            if(i==0)
            {
                txtAgentID.setText(tblAgent.getValueAt(selectedRow, i).toString());
                txtAgentID.setEditable(false);
            }
            else if(i==1)
            {
                txtNamn.setText(tblAgent.getValueAt(selectedRow, i).toString());
            }
            else if(i==2)
            {
                txtTelefon.setText(tblAgent.getValueAt(selectedRow, i).toString());
            }
            else if(i==3)
            {
                txtAnstallningsdatum.setText(tblAgent.getValueAt(selectedRow, i).toString());
            }
            else if(i==4 && tblAgent.getValueAt(selectedRow, i).toString().equals("J"))
            {
                boolean klickad = true;
                chkAdmin.setSelected(klickad);
            }
            else if(i==5 && tblAgent.getValueAt(selectedRow, i).toString().equals("OMRADESCHEF"))
            {
                boolean klickad = true;
                chkOmradesChef.setSelected(klickad);
            }
            else if(i==5 && tblAgent.getValueAt(selectedRow, i).toString().equals("KONTORSCHEF"))
            {
                boolean klickad = true;
                chkKontorsChef.setSelected(klickad);
            }
            else if(i==6)
            {
                txtOmrade.setText(tblAgent.getValueAt(selectedRow, i).toString());
            }
        }

    }//GEN-LAST:event_tblAgentMouseClicked

    private void chkOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOmradesChefActionPerformed
        chkKontorsChef.setSelected(false);
    }//GEN-LAST:event_chkOmradesChefActionPerformed

    private void chkKontorsChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkKontorsChefActionPerformed
        chkOmradesChef.setSelected(false);
    }//GEN-LAST:event_chkKontorsChefActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraAgent;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnListaAlla;
    private javax.swing.JButton btnRaderaAgent;
    private javax.swing.JButton btnRegistreraAgent;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTomFalt;
    private javax.swing.JCheckBox chkAdmin;
    private javax.swing.JCheckBox chkKontorsChef;
    private javax.swing.JCheckBox chkOmradesChef;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAgentID;
    private javax.swing.JLabel lblAgentIkon;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JLabel lblAnsvarigAgent;
    private javax.swing.JLabel lblInstruktioner;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPlats;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblValjAlien;
    private javax.swing.JScrollPane lstAgent;
    private javax.swing.JPanel pnlBorderBottom;
    private javax.swing.JPanel pnlBorderTop;
    private javax.swing.JPanel pnlFonster;
    private javax.swing.JTable tblAgent;
    private javax.swing.JTextField txtAgentID;
    private javax.swing.JTextField txtAnstallningsdatum;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtOmrade;
    private javax.swing.JTextField txtSokAgent;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
