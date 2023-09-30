/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.AnalyticSintax;
import DAO.Files;
import DAO.Instructions;
import DAO.Methods;
import DTO.BCP;
import DTO.CPU;
import DTO.Cell;
import DTO.Document;
import DTO.ErrorFail;
import DTO.Memory;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chuck.a
 */
public class Principal extends javax.swing.JFrame {
    
    Memory RAM;
    Memory SSD;
    CPU cpu = new CPU();
    int ramSize = 256;
    int ssdSize = 512;
    List<String> routes = null;
    List<Document> document;
    Methods methods = new Methods();
    Instructions executer = new Instructions();
    
    List<BCP> bcps = new ArrayList<>();
    List<Map> processTable;
    boolean press = false;
    Files files = new Files();
    /**
     * Creates new form Principal
     * @throws java.lang.InterruptedException
     */
    public Principal() throws InterruptedException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        String console = "ALC TERMINAL\nCopyright (C) ALC Software. Todos los derechos reservados.\n>>>";
        jTextPane1.setText(console);
        //jTextPane1.disable();

        jTextPane1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER & !press) {
                    
                    String[] valores = jTextPane1.getText().split(">>>");
                    String num = valores[valores.length-1];
                    BCP actual = cpu.getActual();
                    actual.getProgramRegisters().setRegister(executer.int09h(cpu.getActual().getProgramRegisters().getRegister(), num));
                    System.out.println("Enter presionado:"+num);
                    cpu.setWait(false);
                    press =true;
                    showBCP();
                }
            }
        });
        showSettings();
        
 
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
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        SSDTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setName("FrameRoot"); // NOI18N
        setSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setFocusable(false);
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setName("Actions_Panel"); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Load Programs");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadProgramsButton(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clean");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Auto Mode");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Execute");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Status");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SSD RM");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RAM RM");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("LOAD = 2\nSTORE = 2\nMOV = 1\nADD = 3\nSUB = 3\nINC = 1\nDEC = 1\nSWAP = 1\nINT 20H = 2\nINT 09H = USER INT\nINT 21H = 5\nJMP = 2\nCMP = 2\nJE/JNE = 2\nPARAM = 3\nPUSH = 1\nPOP = 1\n\n");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextArea1.setEnabled(false);
        jTextArea1.setFocusable(false);
        jScrollPane7.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SSDTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null));
        SSDTable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        SSDTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDEX", "VALUES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SSDTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        SSDTable.setGridColor(new java.awt.Color(0, 204, 204));
        SSDTable.setRowHeight(25);
        SSDTable.setRowMargin(2);
        SSDTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        SSDTable.setShowGrid(true);
        SSDTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(SSDTable);

        jTable2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INDEX", "VALUES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable2.setGridColor(new java.awt.Color(0, 204, 204));
        jTable2.setRowHeight(25);
        jTable2.setRowMargin(2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jTextPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTextPane1.setBorder(new javax.swing.border.MatteBorder(null));
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTextPane1.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jTextPane1);

        jTable3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "VALUES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setGridColor(new java.awt.Color(0, 204, 204));
        jTable3.setRowHeight(25);
        jTable3.setRowMargin(2);
        jTable3.setShowGrid(true);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable3);

        jTable4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "STATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable4.setGridColor(new java.awt.Color(0, 204, 204));
        jTable4.setRowHeight(25);
        jTable4.setRowMargin(2);
        jTable4.setShowGrid(true);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable4);

        jScrollPane6.setBorder(null);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"P1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CPU", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setShowHorizontalLines(true);
        jTable5.setShowVerticalLines(true);
        jScrollPane6.setViewportView(jTable5);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SSD: 512kb");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RAM: 256kb");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BCP");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PROCESS QUEUE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(193, 193, 193)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(93, 93, 93))))
            .addComponent(jScrollPane6)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    /**
     * Load Programs Button
     * @param evt 
     */
    private void loadProgramsButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadProgramsButton
        try {
            if (routes == null) {
                routes = files.openFiles();
                if (!routes.isEmpty()) setMemory();
            }
            else {
                String message = "YA SE HAN CARGADO PROGRAMAS!";
                JOptionPane.showMessageDialog(new JFrame(), message, "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadProgramsButton

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if (cpu.getActual() != null) {
            if (!cpu.isWait()) {
                int weight = cpu.getWeight();
                if (weight-1 == 0) {
                    methods.execute(cpu, executer, jTextPane1, SSD);
                    methods.setIRPC(cpu.getActual());
                    System.out.println(SSD.getCellsReserved());
                    
                    try {
                        refreshSSD();
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    cpu.setWeight(--weight);
                }
                if (cpu.isChangeContext()) {
                    String message = "CAMBIO DE CONTEXTO!";
                    JOptionPane.showMessageDialog(new JFrame(), message, "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
                if (!cpu.isChangeContext()) {
                    drawCPU();
                    int cantClics = cpu.getActual().getCantClics();
                    cpu.getActual().setCantClics(++cantClics);
                }
                cpu.setChangeContext(false);

                showBCP(); 
            }
            else {
                System.out.println("No tira");
                String message = "ESPERANDO ENTRADA DEL USUARIO!";
                JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            String message = "AVISO! NO HAY PROGRAMAS PARA EJECUTAR";
            JOptionPane.showMessageDialog(new JFrame(), message, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }      
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Principal().setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    /**
     * 
     * @throws Exception 
     */
    public void setMemory() throws Exception {
       document = new ArrayList<>();
       methods.loadFile(routes, document);
       SSD = methods.loadMemoryReserved(ssdSize/8,ssdSize,document);
       showSSD(SSD);
    }
    
    /**
     * 
     * @param memory 
     * @throws java.lang.Exception 
     */
    public void showSSD(Memory memory) throws Exception
    {
       SSDTable.getColumnModel().getColumn(1).setPreferredWidth(20);
       DefaultTableModel model = (DefaultTableModel) SSDTable.getModel();
       String [][] data = methods.getSSDTable(SSD);
       String[] cols = {"INDEX", "VALUES"};

       model.setDataVector(data, cols);
       showProcessTable();
    }
    
    public void refreshSSD() throws Exception
    {
       DefaultTableModel model = (DefaultTableModel) SSDTable.getModel();
       String [][] data = methods.getSSDTable(SSD);
       String[] cols = {"INDEX", "VALUES"};

       model.setDataVector(data, cols);
    }
    
    /**
     * 
     */
    private void showSettings() {
        Settings dialog = new Settings(this);
        dialog.setVisible(true);

        String ssdValue = dialog.getSSDValue();
        String ramValue = dialog.getRAMValue();

        if (!ssdValue.equals("")) {
            ramSize = Integer.parseInt(ramValue);
        }
        if (!ramValue.equals("")) {
            ssdSize = Integer.parseInt(ssdValue);
        }
        jLabel1.setText("SSD: "+Integer.toString(ssdSize)+"kb");
        jLabel2.setText("RAM: "+Integer.toString(ramSize)+"kb");
        jLabel5.setText("SSD RM 0 => "+ssdSize/8+"kb");
        jLabel6.setText("RAM RM 0 => "+ramSize/8+"kb");
                
      
    }
    
    /**
     * 
     * @throws java.lang.Exception
     */
    public void showProcessTable() throws Exception {
        processTable = methods.getProcessTable(SSD);
        int size = processTable.size();
        String[] cols = {"INDEX", "STATE"};
        String[][] data = new String[size][cols.length];
        //System.out.println(processTable);
        
        for (int i=0;i<size;i++) {
            data[i][0] = (String) processTable.get(i).get("Name");
            data[i][1] = (String) processTable.get(i).get("State");
        }
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setDataVector(data, cols);
        setMemoryRAM();
        
    }
    
    /**
     * 
     */
    public void getBCP() throws Exception {
        List<Cell> programs = RAM.getCellsNoReserved();
        int nextBCP;
        for (int i = 0;i<programs.size();i++) {
            
            if (i+1 == programs.size()) {
                nextBCP = 0;
            }
            else {
                nextBCP = programs.get(i+1).getStartingAddress();
            }
            BCP bcp = methods.createBCP(programs.get(i), i, nextBCP);
            bcps.add(bcp);
        }
        System.out.println(bcps);
        setBCPS();
        
        
    }
    
    public void setMemoryRAM() throws Exception {
        int reservedMemSize = ramSize/8 - processTable.size();
        RAM = methods.loadMemoryPrincipal(reservedMemSize, ramSize, SSD);
        getBCP();
        
    }
    
    public void setBCPS() {
        List<Cell> cells = new ArrayList<>();
        int reservedMemSize = RAM.getReservedMemSize();
        System.out.println(reservedMemSize);
        for (int i=0;i<bcps.size();i++) {
            BCP actual = bcps.get(i);
            //System.out.println(actual.getSize());
            if (actual.getSize()<reservedMemSize) {
                actual.setPosition(i);
                Cell cell = new Cell();
                cell.setBcp(bcps.get(i));
                cells.add(cell);
                reservedMemSize-=actual.getSize();
                //System.out.println("celda"+cell);
            }
        }
        
        RAM.setCellsReserved(cells);
        //System.out.println(RAM);
        showRAM();
    }
    
    public void showRAM() {
       System.out.println(RAM);
       DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
       String [][] data = methods.getRAMTable(RAM);
       String[] cols = {"INDEX", "VALUES"};
       
       model.setDataVector(data, cols);
       loadCPU();
    }
    
    public void loadCPU() {
        cpu.setLoadedBCPS(RAM.getCellsReserved());
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        String [][] data = methods.getCPUTable(cpu);
        cpu.setProcess(data);
        String[] cols = {"CPU","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","21","22","23","24","25"};
        model.setDataVector(data, cols);
        cpu.setFirstBCP();
        int actualIns = cpu.getActual().getActualInstruction();
        int weight = cpu.getActual().getInstructions().get(actualIns).getWeight();
        cpu.setWeight(weight);
        methods.setIRPC(cpu.getActual());
        showBCP();
        //System.out.println(cpu);
    }
    
    public void showBCP() {
       cpu.getActual().setState("Ejecucion");
       DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
       String[][] verticalData = {
            {"Name", "State", "PC", "IR", "AC","AX", "BX", "CX", "DX", "SIZE" },
            {cpu.getActual().getProgramName(), cpu.getActual().getState(),
                cpu.getActual().getProgramRegisters().getRegister().get("PC"),
                cpu.getActual().getProgramRegisters().getRegister().get("IR"),
                cpu.getActual().getProgramRegisters().getRegister().get("AC"),
                cpu.getActual().getProgramRegisters().getRegister().get("AX"),
                cpu.getActual().getProgramRegisters().getRegister().get("BX"),
                cpu.getActual().getProgramRegisters().getRegister().get("CX"),
                cpu.getActual().getProgramRegisters().getRegister().get("DX"),
                Integer.toString(cpu.getActual().getProgramSize())
            }
        };

        // Convierte los datos a forma horizontal (columnas)
        int rowCount = verticalData.length;
        int colCount = verticalData[0].length;
        String[][] horizontalData = new String[colCount][rowCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                horizontalData[j][i] = verticalData[i][j];
            }
        }

        // Nombres de las columnas
        String[] columnNames = {"ID", "VALUES"};
       
       model.setDataVector(horizontalData, columnNames);
    }
    
    public void drawCPU() {
        String [][] data = cpu.getProcess();
        String[] cols = {"CPU","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","21","22","23","24","25"};
        int i = cpu.getActual().getPosition();
        int j = 0;
        if (cpu.getActual()!=null) {
            j = cpu.getActual().getCantClics();
        }

        data[i][j] = "X";
        
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setDataVector(data, cols);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SSDTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
