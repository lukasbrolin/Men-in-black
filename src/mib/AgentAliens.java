package mib;


import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;


public class AgentAliens extends javax.swing.JFrame {
    
private static String valdRas;

   
    public AgentAliens() {
        initComponents();
        valdRas = "";
        fillBoxPlats();
        fillBoxRas();
    }
    
    //Ger en label värdet av den inloggade agentens namn
    public void setAgentNamn(String agent)
    {
        lblAgentNamn.setText(agent);
    }
    
    //Den här metoden lagrar vilken kombination av filtrerings-checkrutor som är ikryssade i en String och returnerar den Stringen.
     private String iTryckta()
    {
        String index = "";
        if(chkDatum.isSelected()) 
        {
            index = index + "A";
        }
        if(chkRas.isSelected())
        {
            index = index + "B";
        }
        if(chkPlats.isSelected())
        {
            index = index + "C";
        }
        if(index.isEmpty())
        {
            index = index + 0;
        }
        
        return index;    
    }
    
     //Tömmer alla textfält och gör textrutan för Alien ID editable.
    private void clearBoxes()
    {
        txtAlienID.setText("");
        txtAnsvarigAgent.setText("");
        txtPlats.setText("");
        txtRas.setText("");
        txtNamn.setText("");
        txtTelefon.setText("");
        txtRegistrering.setText("");
        chkDatum.setSelected(false);
        chkDatum2.setSelected(false);
        chkPlats.setSelected(false);
        chkRas.setSelected(false);
        txtAlienID.setEditable(true);
    }
    
    //Instansierar ett nytt tabellobjekt med celler som inte går att ändra
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
        
        tableModel.addColumn("Alien ID");
        tableModel.addColumn("Namn");
        tableModel.addColumn("Telefon");
        tableModel.addColumn("Plats");
        tableModel.addColumn("Agent");
        tableModel.addColumn("Ras");
        tableModel.addColumn("Registrering");
        
        return tableModel;

    }
    
    //Skapar en tabell över alla Aliens
    private void skapaListaAlla()
    {       
        try
        {
            DefaultTableModel model = setTableModel();
            tblAliens.setModel(model);
            String fraga = "SELECT * FROM ALIEN";
            InfDB databas = DataBaseConnection.getDB();
            ArrayList<HashMap<String, String>> lista = DataBaseConnection.getDB().fetchRows(fraga);
            
            for(HashMap<String, String> map : lista)
            {
                String alienID = "";
                String namn = "";
                String telefon = "";
                String plats = "";
                String agent = "";
                String ras = "";
                String registrering = "";
                String platsKonverterad = "";
                String agentKonverterad = "";
                
                for(String key : map.keySet())
                {
                    if(key.equals("ALIEN_ID"))
                    {
                        alienID = map.get(key);            
                    }
                    else if(key.equals("NAMN")) 
                    {
                        namn = map.get(key);
                    }
                    else if(key.equals("TELEFON"))
                    {
                        telefon = map.get(key);
                    }
                    else if(key.equals("PLATS"))
                    {
                        plats = map.get(key);
                        String fragaPlats = "SELECT BENAMNING FROM PLATS WHERE PLATS_ID = " + plats;
                        platsKonverterad = databas.fetchSingle(fragaPlats);
                    }
                    else if(key.equals("ANSVARIG_AGENT"))
                    {
                        agent = map.get(key);
                        String fragaAgent = "SELECT NAMN FROM AGENT WHERE AGENT_ID = " + agent;
                        agentKonverterad = databas.fetchSingle(fragaAgent);
                    }
                    else if(key.equals("REGISTRERINGSDATUM"))
                    {
                        registrering = map.get(key);
                    }      
                }
                
                String [] rasen = {"BOGLODITE", "SQUID", "WORM"};
                for(String enStrang : rasen)
                {
                    String antiBreakage = "SELECT COUNT(*) AS ROWCOUNT FROM " + enStrang;
                    String svar = databas.fetchSingle(antiBreakage);
                    int svar2 = Integer.parseInt(svar);
                        
                    if( svar2 == 0)
                    {
                        break;
                    }
                                
                    String rasFraga = "SELECT ALIEN_ID FROM " + enStrang + "";
                    ArrayList<HashMap<String, String>> listan = DataBaseConnection.getDB().fetchRows(rasFraga);
                                                
                    for(HashMap<String, String> map2 : listan)
                    {
                        for(String strangen : map2.keySet())
                        {
                            if(map2.get(strangen).equals(alienID))
                            {
                                ras = enStrang;
                            }
                        }
                    }
                }
                    
                model.addRow(new Object[] {alienID, namn, telefon, platsKonverterad, agentKonverterad, ras, registrering});
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
    //Skapar en tabell utifrån den fråga som switchen på Lista Aliens-knappen formulerat.
    private void skapaLista(String q)
    {       
        try
        {
            DefaultTableModel model = setTableModel();
            tblAliens.setModel(model);
            String fraga = q;
            InfDB databas = DataBaseConnection.getDB();
            ArrayList<HashMap<String, String>> lista = DataBaseConnection.getDB().fetchRows(fraga);
                     
            for(HashMap<String, String> map : lista)
            {
                String alienID = "";
                String namn = "";
                String telefon = "";
                String plats = "";
                String agent = "";
                String ras = "";
                String registrering = "";
                String platsKonverterad = "";
                String agentKonverterad = "";
                
                for(String key : map.keySet())
                {
                    if(key.equals("ALIEN_ID"))
                    {
                        alienID = map.get(key);            
                    }
                    else if(key.equals("NAMN")) 
                    {
                        namn = map.get(key);
                    }
                    else if(key.equals("TELEFON"))
                    {
                        telefon = map.get(key);
                    }
                    else if(key.equals("PLATS"))
                    {
                        plats = map.get(key);
                        String fragaPlats = "SELECT BENAMNING FROM PLATS WHERE PLATS_ID = " + plats;
                        platsKonverterad = databas.fetchSingle(fragaPlats);
                    }
                    else if(key.equals("ANSVARIG_AGENT"))
                    {
                        agent = map.get(key);
                        String fragaAgent = "SELECT NAMN FROM AGENT WHERE AGENT_ID = " + agent;
                        agentKonverterad = databas.fetchSingle(fragaAgent);
                    }
                    else if(key.equals("REGISTRERINGSDATUM"))
                    {
                        registrering = map.get(key);
                    }
                        
                    }   
                    String [] rasen = {"BOGLODITE", "SQUID", "WORM"};
                    for(String enStrang : rasen)
                    {
                        String antiBreakage = "SELECT COUNT(*) AS ROWCOUNT FROM " + enStrang;
                        String svar = databas.fetchSingle(antiBreakage);
                        int svar2 = Integer.parseInt(svar);
                        
                        if(svar2 == 0)
                        {
                            break;
                        }
                                                    
                        String rasFraga = "SELECT ALIEN_ID FROM " + enStrang + "";
                        ArrayList<HashMap<String, String>> listan = DataBaseConnection.getDB().fetchRows(rasFraga);
                        
                        for(HashMap<String, String> map2 : listan)
                        {
                            for(String strangen : map2.keySet())
                            {
                                if(map2.get(strangen).equals(alienID))
                                {
                                    ras = enStrang;
                                }
                            }
                        }
                    }
                    
                model.addRow(new Object[] {alienID, namn, telefon, platsKonverterad, agentKonverterad, ras, registrering});
                
            }
        }
        catch(Exception e)
        {
            
        }
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
        btnHome = new javax.swing.JButton();
        pnlBorderBottom = new javax.swing.JPanel();
        lblValjAlien = new javax.swing.JLabel();
        btnSok = new javax.swing.JButton();
        lblAlienID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblPlats = new javax.swing.JLabel();
        lblAnsvarigAgent = new javax.swing.JLabel();
        lblRas = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        txtPlats = new javax.swing.JTextField();
        txtAnsvarigAgent = new javax.swing.JTextField();
        txtRas = new javax.swing.JTextField();
        btnRegistreraAlien = new javax.swing.JButton();
        btnAndraAlien = new javax.swing.JButton();
        btnTomFalt = new javax.swing.JButton();
        chkPlats = new javax.swing.JCheckBox();
        chkRas = new javax.swing.JCheckBox();
        chkDatum = new javax.swing.JCheckBox();
        cmbPLats = new javax.swing.JComboBox<>();
        cmbRas = new javax.swing.JComboBox<>();
        btnListaAlla = new javax.swing.JButton();
        lblInstruktioner = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAliens = new javax.swing.JTable();
        txtRegistrering = new javax.swing.JTextField();
        lblRegistrering = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        txtAlienID = new javax.swing.JTextField();
        txtSokAlien = new javax.swing.JTextField();
        txtDat1 = new javax.swing.JTextField();
        txtDat2 = new javax.swing.JTextField();
        chkDatum2 = new javax.swing.JCheckBox();

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
        setSize(new java.awt.Dimension(1000, 600));

        pnlFonster.setBackground(new java.awt.Color(255, 255, 255));
        pnlFonster.setMaximumSize(new java.awt.Dimension(1000, 600));
        pnlFonster.setMinimumSize(new java.awt.Dimension(1000, 600));

        pnlBorderTop.setBackground(new java.awt.Color(220, 220, 220));
        pnlBorderTop.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        pnlBorderTop.setMaximumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setMinimumSize(new java.awt.Dimension(1000, 80));
        pnlBorderTop.setPreferredSize(new java.awt.Dimension(1000, 80));

        lblRubrik.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        lblRubrik.setText("Aliens");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(lblRubrik)
                .addGap(322, 322, 322)
                .addComponent(lblAgentIkon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgentNamn)
                .addGap(15, 15, 15))
        );
        pnlBorderTopLayout.setVerticalGroup(
            pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderTopLayout.createSequentialGroup()
                .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlBorderTopLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAgentNamn)
                        .addGap(14, 14, 14))
                    .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBorderTopLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(lblRubrik))
                        .addGroup(pnlBorderTopLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(pnlBorderTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAgentIkon)))))
                .addContainerGap(7, Short.MAX_VALUE))
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
        lblValjAlien.setText("Välj Alien:");

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

        lblAlienID.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblAlienID.setText("Alien ID:");

        lblNamn.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblNamn.setText("Namn:");

        lblTelefon.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblTelefon.setText("Telefonnummer:");

        lblPlats.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblPlats.setText("Plats:");

        lblAnsvarigAgent.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblAnsvarigAgent.setText("Ansvarig Agent:");

        lblRas.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblRas.setText("Ras:");

        txtTelefon.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtTelefon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPlats.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtPlats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAnsvarigAgent.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtAnsvarigAgent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtRas.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtRas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRegistreraAlien.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistreraAlien.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnRegistreraAlien.setText("Registrera ny Alien");
        btnRegistreraAlien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRegistreraAlien.setContentAreaFilled(false);
        btnRegistreraAlien.setMaximumSize(new java.awt.Dimension(75, 30));
        btnRegistreraAlien.setMinimumSize(new java.awt.Dimension(75, 30));
        btnRegistreraAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreraAlienActionPerformed(evt);
            }
        });

        btnAndraAlien.setBackground(new java.awt.Color(255, 255, 255));
        btnAndraAlien.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        btnAndraAlien.setText("Ändra");
        btnAndraAlien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAndraAlien.setContentAreaFilled(false);
        btnAndraAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraAlienActionPerformed(evt);
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

        chkPlats.setBackground(new java.awt.Color(255, 255, 255));
        chkPlats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        chkRas.setBackground(new java.awt.Color(255, 255, 255));
        chkRas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        chkDatum.setBackground(new java.awt.Color(255, 255, 255));
        chkDatum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        chkDatum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkDatumMouseClicked(evt);
            }
        });

        cmbPLats.setToolTipText("");
        cmbPLats.setBorder(null);
        cmbPLats.setPreferredSize(new java.awt.Dimension(64, 29));

        cmbRas.setBorder(null);
        cmbRas.setMinimumSize(new java.awt.Dimension(64, 29));
        cmbRas.setPreferredSize(new java.awt.Dimension(64, 29));

        btnListaAlla.setBackground(new java.awt.Color(255, 255, 255));
        btnListaAlla.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        btnListaAlla.setText("Lista alla Aliens");
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
        lblInstruktioner.setText("Ändra eller lägg till en Alien");
        lblInstruktioner.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tblAliens.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblAliens.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        tblAliens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alien ID", "Namn", "Telefon", "Plats", "Agent", "Ras", "Registrering"
            }
        ));
        tblAliens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAliensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAliens);

        txtRegistrering.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtRegistrering.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRegistrering.setFont(new java.awt.Font("Open Sans Semibold", 0, 14)); // NOI18N
        lblRegistrering.setText("Registrering:");

        txtNamn.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtNamn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtAlienID.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtAlienID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSokAlien.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        txtSokAlien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDat1.setText("YYYY-MM-DD");
        txtDat1.setPreferredSize(new java.awt.Dimension(64, 29));
        txtDat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDat1MouseClicked(evt);
            }
        });

        txtDat2.setText("YYYY-MM-DD");
        txtDat2.setPreferredSize(new java.awt.Dimension(64, 29));
        txtDat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDat2MouseClicked(evt);
            }
        });

        chkDatum2.setBackground(new java.awt.Color(255, 255, 255));
        chkDatum2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        chkDatum2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkDatum2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlFonsterLayout = new javax.swing.GroupLayout(pnlFonster);
        pnlFonster.setLayout(pnlFonsterLayout);
        pnlFonsterLayout.setHorizontalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAlienID)
                        .addComponent(lblNamn)
                        .addComponent(lblTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPlats)
                        .addComponent(lblAnsvarigAgent)
                        .addComponent(lblRas)
                        .addComponent(btnAndraAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTomFalt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblRegistrering))
                .addGap(30, 30, 30)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistreraAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefon)
                    .addComponent(txtPlats)
                    .addComponent(txtAnsvarigAgent)
                    .addComponent(txtRas)
                    .addComponent(lblInstruktioner, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(txtRegistrering)
                    .addComponent(txtNamn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAlienID, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListaAlla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                        .addComponent(chkDatum2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDat2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                        .addComponent(lblValjAlien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSokAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlFonsterLayout.createSequentialGroup()
                            .addComponent(chkPlats)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbPLats, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlFonsterLayout.createSequentialGroup()
                            .addComponent(chkRas)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbRas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlFonsterLayout.createSequentialGroup()
                            .addComponent(chkDatum)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDat1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBorderTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBorderBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFonsterLayout.setVerticalGroup(
            pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFonsterLayout.createSequentialGroup()
                .addComponent(pnlBorderTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValjAlien)
                    .addComponent(btnSok)
                    .addComponent(lblInstruktioner)
                    .addComponent(txtSokAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFonsterLayout.createSequentialGroup()
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAlienID)
                            .addComponent(txtAlienID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamn)
                            .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefon))
                        .addGap(20, 20, 20)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlats, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlats))
                        .addGap(20, 20, 20)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnsvarigAgent))
                        .addGap(20, 20, 20)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRegistrering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRegistrering)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFonsterLayout.createSequentialGroup()
                                .addComponent(btnTomFalt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAndraAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addGroup(pnlFonsterLayout.createSequentialGroup()
                                .addComponent(btnRegistreraAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFonsterLayout.createSequentialGroup()
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPLats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkPlats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbRas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkRas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnListaAlla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFonsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDat1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDat2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkDatum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkDatum2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)))
                .addComponent(pnlBorderBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFonster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFonster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Hämtar allt från alien-tabellen, konverterar de IDn som finns till benämningar och hämtar rätt ras för varje alien.
    //Sen jämför metoden sökningen med alla hämtade aliennamn och lägger till de rader som matchar
    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        clearBoxes();
        if(Validation.isNotEmpty(txtSokAlien))
        {
            try
            {
                DefaultTableModel model = setTableModel();
                tblAliens.setModel(model);
                String sokOrd = txtSokAlien.getText().toLowerCase();
                String fraga = "SELECT * FROM ALIEN";
                InfDB databas = DataBaseConnection.getDB();
                ArrayList<HashMap<String, String>> lista = DataBaseConnection.getDB().fetchRows(fraga);
            
                for(HashMap<String, String> map : lista)
                {
                    String alienID = "";
                    String namn = "";
                    String telefon = "";
                    String plats = "";
                    String agent = "";
                    String ras = "";
                    String registrering = "";
                    String platsKonverterad = "";
                    String agentKonverterad = "";
                
                    for(String key : map.keySet())
                    {
                        if(key.equals("ALIEN_ID"))
                        {
                            alienID = map.get(key);            
                        }
                        else if(key.equals("NAMN")) 
                        {
                            namn = map.get(key);
                        }
                        else if(key.equals("TELEFON"))
                        {
                            telefon = map.get(key);
                        }
                        else if(key.equals("PLATS"))
                        {
                            plats = map.get(key);
                            String fragaPlats = "SELECT BENAMNING FROM PLATS WHERE PLATS_ID = " + plats;
                            platsKonverterad = databas.fetchSingle(fragaPlats);
                        }
                        else if(key.equals("ANSVARIG_AGENT"))
                        {
                            agent = map.get(key);
                            String fragaAgent = "SELECT NAMN FROM AGENT WHERE AGENT_ID = " + agent;
                            agentKonverterad = databas.fetchSingle(fragaAgent);
                        }
                        else if(key.equals("REGISTRERINGSDATUM"))
                        {
                            registrering = map.get(key);
                        }
                    
                    }
                
                    String [] rasen = {"BOGLODITE", "SQUID", "WORM"};
                    for(String enStrang : rasen)
                    {
                        String antiBreakage = "SELECT COUNT(*) AS ROWCOUNT FROM " + enStrang;
                        String svar = databas.fetchSingle(antiBreakage);
                        int svar2 = Integer.parseInt(svar);
                        
                        if( svar2 == 0)
                        {
                            break;
                        }
                                
                        String rasFraga = "SELECT ALIEN_ID FROM " + enStrang + "";
                        ArrayList<HashMap<String, String>> listan = DataBaseConnection.getDB().fetchRows(rasFraga);
                        
                        for(HashMap<String, String> map2 : listan)
                        {
                            for(String strangen : map2.keySet())    
                            {
                                if(map2.get(strangen).equals(alienID))                                   
                                {
                                    ras = enStrang;
                                }
                            }
                        }
                    }
                    
                    String namnet = namn.toLowerCase();
                    if(namnet.contains(sokOrd) || alienID.contains(sokOrd))
                    {
                        model.addRow(new Object[] {alienID, namn, telefon, platsKonverterad, agentKonverterad, ras, registrering});
                    }
                }
            }
            catch(Exception e)
            {
            
            }
        }
    }//GEN-LAST:event_btnSokActionPerformed

    //Metoden hämtar värdena från alla textfält, jämför texten från rasrutan med de raser som finns i systemet och lägger in det nya Alien-idt i rätt rastabell. 
    //Plats och agentbenämningar konverteras till IDn och alla värden lagras i alientabellen som en ny alien, sen skapas en ny uppdaterad tabell.
    private void btnRegistreraAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreraAlienActionPerformed
        if(Validation.isNotEmpty(txtAlienID) && Validation.isNotEmpty(txtAnsvarigAgent) && Validation.isNotEmpty(txtNamn) && Validation.isNotEmpty(txtPlats) && Validation.isNotEmpty(txtRas) && Validation.isNotEmpty(txtRegistrering) && Validation.isNotEmpty(txtTelefon) && !Validation.existingID(txtAlienID, "alien") && Validation.isCorrectDateFormat(txtRegistrering) && Validation.isPlats(txtPlats) && Validation.isRas(txtRas) && Validation.isHeltal(txtAlienID) && Validation.isAgent(txtAnsvarigAgent) && Validation.isTelefon(txtTelefon))
        {    
            try
            {        
                String nyttID = txtAlienID.getText();
                String nyPlats = txtPlats.getText();
                String nyttNamn = txtNamn.getText();
                String nyTelefon = txtTelefon.getText();
                String nyRegistrering = txtRegistrering.getText();
                String ras = txtRas.getText().toLowerCase();
                InfDB databas = DataBaseConnection.getDB();
                
                if(ras.equals("boglodite"))
                {
                    String bogFraga = "INSERT INTO BOGLODITE VALUES (" + nyttID + ", null)";
                    databas.insert(bogFraga);
                }
                else if(ras.equals("worm"))
                {
                    String wormFraga = "INSERT INTO WORM VALUES (" + nyttID + ")";
                    databas.insert(wormFraga);
                    System.out.println(wormFraga);
                }
                else if(ras.equals("squid"))
                {
                    String squidFraga = "INSERT INTO SQUID VALUES (" + nyttID + ", null)";
                    databas.insert(squidFraga);
                }
       
                String fragaPlats = "SELECT PLATS_ID FROM PLATS WHERE BENAMNING = '" + txtPlats.getText() + "'";
                String platsKonverterad = databas.fetchSingle(fragaPlats);
        
                String fragaAgent = "SELECT AGENT_ID FROM AGENT WHERE NAMN = '" + txtAnsvarigAgent.getText() + "'";
                String agentKonverterad = databas.fetchSingle(fragaAgent);
        
                String fraga = "INSERT INTO ALIEN VALUES (" + nyttID + ", '" + nyRegistrering + "', 'alien', '" + nyttNamn + "', '" + nyTelefon + "', " + platsKonverterad + ", " + agentKonverterad + ")";
                System.out.println(fraga);
          
                databas.insert(fraga);
                JOptionPane.showMessageDialog(null, "En ny Alien har lagts till! Lösenord: alien");
                skapaListaAlla();
                clearBoxes();
            }
    
            catch(InfException e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnRegistreraAlienActionPerformed

    //Metoden hämtar den valda alienens ras och lösenord och tar bort alienIDt ur rastabellen. Sen registreras den angivna rasen på nytt i tillhörande rastabell.
    //Plats och agentnamn i textrutorna konverteras till rätt IDn och den valda alienen uppdateras i tabellen Aliens.
    private void btnAndraAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraAlienActionPerformed
        if(Validation.isNotEmpty(txtAlienID) && Validation.isNotEmpty(txtAnsvarigAgent) && Validation.isNotEmpty(txtNamn) && Validation.isNotEmpty(txtPlats) && Validation.isNotEmpty(txtRas) && Validation.isNotEmpty(txtRegistrering) && Validation.isNotEmpty(txtTelefon) && Validation.isHeltal(txtAlienID) && Validation.isCorrectDateFormat(txtRegistrering) && Validation.isPlats(txtPlats) && Validation.isRas(txtRas) && Validation.isAgent(txtAnsvarigAgent) && Validation.isTelefon(txtTelefon))
        {    
            try
            {
                String losen = "";
                String nyttID = txtAlienID.getText();
                String nyPlats = txtPlats.getText();
                String nyttNamn = txtNamn.getText();
                String nyTelefon = txtTelefon.getText();
                String nyRegistrering = txtRegistrering.getText();
                String ras = txtRas.getText().toLowerCase();
                InfDB databas = DataBaseConnection.getDB();
        
                String losenFraga = "SELECT LOSENORD FROM ALIEN WHERE ALIEN_ID = " + nyttID;
                losen = databas.fetchSingle(losenFraga);
        
                String rasReset = "DELETE FROM " + valdRas + " WHERE ALIEN_ID = " + nyttID;
                databas.delete(rasReset);
        
                if(ras.equals("boglodite"))
                {
                    String bogFraga = "INSERT INTO BOGLODITE VALUES (" + nyttID + ", null)";
                    databas.insert(bogFraga);
                }
                else if(ras.equals("worm"))
                {
                    String wormFraga = "INSERT INTO WORM VALUES (" + nyttID + ")";
                    databas.insert(wormFraga);
                }
                else if(ras.equals("squid"))
                {
                    String squidFraga = "INSERT INTO SQUID VALUES (" + nyttID + ", null)";
                    databas.insert(squidFraga);
                }
                   
                String fragaPlats = "SELECT PLATS_ID FROM PLATS WHERE BENAMNING = '" + txtPlats.getText() + "'";
                String platsKonverterad = databas.fetchSingle(fragaPlats);
        
                String fragaAgent = "SELECT AGENT_ID FROM AGENT WHERE NAMN = '" + txtAnsvarigAgent.getText() + "'";
                String agentKonverterad = databas.fetchSingle(fragaAgent);
        
                String fraga = "UPDATE ALIEN SET REGISTRERINGSDATUM = '" + nyRegistrering + "', LOSENORD = '" + losen + "', NAMN = '" + nyttNamn + "', TELEFON = '" + nyTelefon + "', PLATS = " + platsKonverterad + ", ANSVARIG_AGENT = " + agentKonverterad + " WHERE ALIEN_ID = " + nyttID;
                  
                databas.update(fraga);
                JOptionPane.showMessageDialog(null, "En Alien har ändrats!"); 
                skapaListaAlla();
                clearBoxes();
            }
    
            catch(InfException e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnAndraAlienActionPerformed

    private void btnTomFaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomFaltActionPerformed
        clearBoxes();
    }//GEN-LAST:event_btnTomFaltActionPerformed
    
    //Switchen använder sig av bokstavskoden från metoden iTryckta och skapar en sql-fråga baserat på vilka checkboxes som är iklickade och det valda värdet i den tillhörande comboboxen .
    //Sql-frågan stoppas in i metoden skapaLista som tar in frågan som en parameter och skapar tabellen.
    //Om inga checkboxes är valda körs case 0 som kör metoden skapaListaAlla.
    private void btnListaAllaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaAllaActionPerformed
       switch(iTryckta()){
            case "0":
            {
                skapaListaAlla();
            }
            break;
            case "ABC":
            { 
                if(Validation.isCorrectDateFormat(txtDat1) || Validation.isCorrectDateFormat(txtDat2))
                {
                try
                {
                    String location = cmbPLats.getSelectedItem().toString();
                    String dat1 = txtDat1.getText();
                    String dat2 = txtDat2.getText();
                    String race = cmbRas.getSelectedItem().toString();
                    String fraga2 = "SELECT ALIEN_ID FROM " + race ;
                    ArrayList<HashMap<String,String>> lista = DataBaseConnection.getDB().fetchRows(fraga2);
                    String rasen = "(";
                    int i = 1;
                    for(HashMap<String, String> map : lista)
                    {
               
                        for(String enStrang : map.keySet())
                        {
                   
                            if(i < lista.size())
                            {
                                rasen = rasen + map.get(enStrang) + ",";
                                i++;
                            }
                            else
                            {
                                rasen = rasen + map.get(enStrang);
                            }
                        }
                    }
                    rasen = rasen + ")";
                    String fraga = "select * from ALIEN where PLATS in (select PLATS_ID from PLATS where BENAMNING = '" + location + "') and ALIEN_ID in " + rasen + " and REGISTRERINGSDATUM between '" + dat1 + "' and '" + dat2 + "'";
                    skapaLista(fraga);
                }
                catch(Exception e)
                {
                    
                }
                }
            }
            break;
            case "A":
            {
                if(Validation.isCorrectDateFormat(txtDat1) || Validation.isCorrectDateFormat(txtDat2))
                {
                    String dat1 = txtDat1.getText();
                    String dat2 = txtDat2.getText();
                    String fraga = "select * from ALIEN where REGISTRERINGSDATUM between '" + dat1 + "' and '" + dat2 + "'";
                    skapaLista(fraga);
                }
            }
            break;
            case "B":
            try
            {
                String race = cmbRas.getSelectedItem().toString();
                String fraga2 = "SELECT ALIEN_ID FROM " + race ;
                ArrayList<HashMap<String,String>> lista = DataBaseConnection.getDB().fetchRows(fraga2);
                String rasen = "(";
                int i = 1;
                for(HashMap<String, String> map : lista)
                {
               
                    for(String enStrang : map.keySet())
                    {
                   
                        if(i < lista.size())
                        {
                            rasen = rasen + map.get(enStrang) + ",";
                            i++;
                        }
                        else
                        {
                            rasen = rasen + map.get(enStrang);
                        }
                    }
                }
                rasen = rasen + ")";
           
                String fraga = "select * from ALIEN where ALIEN_ID IN" + rasen + "";
                skapaLista(fraga);
            }
            catch(Exception e)
            {
               
            }
            break;
            case "C":
            {
                String location = cmbPLats.getSelectedItem().toString();
                String fraga = "select * from ALIEN where PLATS = (select PLATS_ID from PLATS where BENAMNING = '" + location + "')";
                skapaLista(fraga);
            }
            break;
            case "AB":
            {
                if(Validation.isCorrectDateFormat(txtDat1) || Validation.isCorrectDateFormat(txtDat2))
                {
                try
                {
                    String dat1 = txtDat1.getText();
                    String dat2 = txtDat2.getText();
                    String race = cmbRas.getSelectedItem().toString();

                    String fraga2 = "SELECT ALIEN_ID FROM " + race ;
                    ArrayList<HashMap<String,String>> lista = DataBaseConnection.getDB().fetchRows(fraga2);
                    String rasen = "(";
                    int i = 1;
                    for(HashMap<String, String> map : lista)
                    {
               
                        for(String enStrang : map.keySet())
                        {
                   
                            if(i < lista.size())
                            {
                                rasen = rasen + map.get(enStrang) + ",";
                                i++;
                            }
                            else
                            {
                                rasen = rasen + map.get(enStrang);
                            }
                    }
                }
                    rasen = rasen + ")";
                    
                    String fraga = "select * from ALIEN where REGISTRERINGSDATUM between '" + dat1 + "' and '" + dat2 + "' and ALIEN_ID IN " + rasen;
                    skapaLista(fraga);
                }
                catch(Exception e)
                {
                    
                }
                }
            }
            break;
            case "BC":
            {
            try
            {
                String location = cmbPLats.getSelectedItem().toString();
                String race = cmbRas.getSelectedItem().toString();
                String fraga2 = "SELECT ALIEN_ID FROM " + race ;
                ArrayList<HashMap<String,String>> lista = DataBaseConnection.getDB().fetchRows(fraga2);
                String rasen = "(";
                int i = 1;
                for(HashMap<String, String> map : lista)
                {
               
                    for(String enStrang : map.keySet())
                    {
                   
                        if(i < lista.size())
                        {
                            rasen = rasen + map.get(enStrang) + ",";
                            i++;
                        }
                        else
                        {
                            rasen = rasen + map.get(enStrang);
                        }
                    }
                }
                rasen = rasen + ")";
                String fraga = "select * from ALIEN where ALIEN_ID in " + rasen + " and PLATS in (select PLATS_ID from PLATS where BENAMNING = '" + location + "')";
                skapaLista(fraga);
            }
            catch(Exception e)
                    {
                        
                    }
            }
            break;
            case "AC":
            {
                
                if(Validation.isCorrectDateFormat(txtDat1) || Validation.isCorrectDateFormat(txtDat2))
                {
                String location = cmbPLats.getSelectedItem().toString();
                String dat1 = txtDat1.getText();
                String dat2 = txtDat2.getText();
                String fraga = "select * from ALIEN where PLATS in (select PLATS_ID from PLATS where BENAMNING = '" + location + "') and REGISTRERINGSDATUM between '" + dat1 + "' and '" + dat2 + "'";
                skapaLista(fraga);
                }
            }       
            break;
        }

    
    }//GEN-LAST:event_btnListaAllaActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        AgentHome obj = new AgentHome();
        obj.setVisible(true);
        obj.setLocationRelativeTo(this);
        obj.setRubrikAgent(Inloggad.getNameInloggad());
        this.dispose(); 
    }//GEN-LAST:event_btnHomeActionPerformed

    //Metoden körs när en alien väljs i tabellen. Den valda raden lagras i selectedRow.
    //Metoden loopar igenom alla kolumner för den valda raden, tilldelar alla textrutor värdena från kolumnerna och sätter textrutan för AlienID till nonEditable.
    //Rasen som fanns i tabellen när raden valdes sparas i fältet String valdRas för att användas i metoder där den behövs.
    private void tblAliensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAliensMouseClicked
        clearBoxes();
        int selectedRow = tblAliens.getSelectedRow();
        int tal = tblAliens.getColumnCount();
        int [] selectedColumns = tblAliens.getSelectedColumns();
        for(int i = 0; i< tal; i++)
        {
            if(i==0)
            {
                txtAlienID.setText(tblAliens.getValueAt(selectedRow, i).toString());
                txtAlienID.setEditable(false);
            }
            else if(i==1)
            {
                txtNamn.setText(tblAliens.getValueAt(selectedRow, i).toString());
            }
            else if(i==2)
            {
                txtTelefon.setText(tblAliens.getValueAt(selectedRow, i).toString());
            }
            else if(i==3)
            {
                txtPlats.setText(tblAliens.getValueAt(selectedRow, i).toString());
            }
            else if(i==4)
            {
                txtAnsvarigAgent.setText(tblAliens.getValueAt(selectedRow, i).toString());
            }
            else if(i==5)
            {
                txtRas.setText(tblAliens.getValueAt(selectedRow, i).toString());
                valdRas = txtRas.getText().toLowerCase();

            }
            else if(i==6)
            {
                txtRegistrering.setText(tblAliens.getValueAt(selectedRow, i).toString());
            }
        }
    }//GEN-LAST:event_tblAliensMouseClicked

    private void txtDat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDat1MouseClicked
        txtDat1.setText("");
    }//GEN-LAST:event_txtDat1MouseClicked

    private void txtDat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDat2MouseClicked
        txtDat2.setText("");
    }//GEN-LAST:event_txtDat2MouseClicked

    //Metoden klickar i checkboxen chkDatum2 om chkDatum klickas i.
    private void chkDatumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkDatumMouseClicked
        boolean check = false;
        if (chkDatum.isSelected())
        {
            chkDatum2.setSelected(true);
            check = true;
        }
        else if (check == false)
        {
            chkDatum2.setSelected(false);
        }
    }//GEN-LAST:event_chkDatumMouseClicked

    //Metoden klickar i checkboxen chkDatum om chkDatum2 klickas i
    private void chkDatum2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkDatum2MouseClicked
        boolean check = false;
        if (chkDatum2.isSelected())
        {
            chkDatum.setSelected(true);
            check= true;
        }
        else if (check == false)
        {
            chkDatum.setSelected(false);
        }
    }//GEN-LAST:event_chkDatum2MouseClicked
    //Fyller comboboxen för Plats med de platser som finns lagrade i databasen.
    private void fillBoxPlats()
    {
        try
        {
            String fraga = "select benamning from plats";
            ArrayList<String> svar = DataBaseConnection.getDB().fetchColumn(fraga);
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            cmbPLats.setModel(model);
        
            for(String enStrang : svar)
            {
                model.addElement(enStrang);
            }
        }
        catch(Exception e)
        {
            
        }
    }
    
    //Fyller comboboxen för Ras med de raser som finns lagrade i databasen.
    private void fillBoxRas()
    {
        String ras1 = "BOGLODITE";
        String ras2 = "SQUID";
        String ras3 = "WORM";
        cmbRas.addItem(ras1);
        cmbRas.addItem(ras2);
        cmbRas.addItem(ras3);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraAlien;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnListaAlla;
    private javax.swing.JButton btnRegistreraAlien;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTomFalt;
    private javax.swing.JCheckBox chkDatum;
    private javax.swing.JCheckBox chkDatum2;
    private javax.swing.JCheckBox chkPlats;
    private javax.swing.JCheckBox chkRas;
    private javax.swing.JComboBox<String> cmbPLats;
    private javax.swing.JComboBox<String> cmbRas;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgentIkon;
    private javax.swing.JLabel lblAgentNamn;
    private javax.swing.JLabel lblAlienID;
    private javax.swing.JLabel lblAnsvarigAgent;
    private javax.swing.JLabel lblInstruktioner;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPlats;
    private javax.swing.JLabel lblRas;
    private javax.swing.JLabel lblRegistrering;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblValjAlien;
    private javax.swing.JPanel pnlBorderBottom;
    private javax.swing.JPanel pnlBorderTop;
    private javax.swing.JPanel pnlFonster;
    private javax.swing.JTable tblAliens;
    private javax.swing.JTextField txtAlienID;
    private javax.swing.JTextField txtAnsvarigAgent;
    private javax.swing.JTextField txtDat1;
    private javax.swing.JTextField txtDat2;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtPlats;
    private javax.swing.JTextField txtRas;
    private javax.swing.JTextField txtRegistrering;
    private javax.swing.JTextField txtSokAlien;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
