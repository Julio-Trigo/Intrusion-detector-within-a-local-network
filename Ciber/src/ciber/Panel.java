/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciber;

import Componente.Boton;
import ListenSocket.Listen;
import TableComponents.IconCellRenderer;
import TalkSocket.Talk;
import chatRoom.Room;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Master
 */
public class Panel extends javax.swing.JFrame {

    /**
     * Creates new form Panel
     */
    private DefaultTableModel tabla;
    private Socket[] multisocket;
    private Room [] chatRoom;
    private Listen [] listen;
    private JLabel etiqueta;
    private Boton boton;
    private int fila;
    

    public Panel() {
        initComponents();
        try {
            jTable1.setDefaultRenderer(Object.class, new IconCellRenderer());
            tabla = (DefaultTableModel) jTable1.getModel();
            preparedOrdenador();
            multisocket = new Socket[jTable1.getRowCount()];
            chatRoom = new Room[jTable1.getRowCount()];
            listen = new Listen[jTable1.getRowCount()];
            setLocationRelativeTo(null);
            favicon();
            setVisible(true);
            esperarTerminal();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de Ciber ");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Command:");

        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordenador", "Inicio", "Contador", "Estado", "Tiempo", "Extra", "Nota", "Mensaje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(70);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/Startupfolder_5943.png"))); // NOI18N
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/caja.png"))); // NOI18N
        jMenu2.setText("Cuenta");
        jMenu2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/impresora.png"))); // NOI18N
        jMenu3.setText("Impresora");
        jMenu3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int column = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());
        int Row = jTable1.getSelectedRow();

        if (column >= 0 && column < jTable1.getColumnCount()) {
            Object value = jTable1.getValueAt(Row, column);
            if (value instanceof Boton) {
                if (multisocket[Row] != null) {
                    ((Boton) value).jButtonActionPerformed(multisocket[Row]);
                } else {
                    ((Boton) value).jButtonActionPerformed();
                }

            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("Convert2Lambda")
    private void preparedOrdenador() {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(140);
        Object[] t;
        for (int i = 1; i <= 6; i++) {
            t = new Object[8];
            fila = i - 1;
            boton = new Boton("Libre", jTable1, fila);
            etiqueta = new JLabel();
            etiqueta.setName("Apagado");
            etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/computer.png")));
            etiqueta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
            etiqueta.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
            etiqueta.setIconTextGap(10);
            etiqueta.setText("Ordenador " + i);
            for (int j = 0; j < t.length; j++) {
                t[j] = "";
            }
            t[0] = etiqueta;
            t[3] = boton;
            tabla.addRow(t);
        }
        tabla.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent evento) {
                updatePerformed(evento);
            }
        });

    }

    private void favicon() {
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("/Ico/favicon.png"));
        Image Image = ImageIcon.getImage();
        setIconImage(Image);
    }

    private void esperarTerminal() {
        DataInputStream dis;
        ServerSocket socketServer;
        try {
            socketServer = new ServerSocket(5000);
            while (true) {
                Socket socket;
                socket = socketServer.accept();
                dis = new DataInputStream(socket.getInputStream());
                fila = Integer.parseInt(dis.readUTF()) - 1;
                multisocket[fila] = socket;
                chatRoom[fila]= new Room(socket);
                chatRoom[fila].setTitle("Ordenador "+(fila+1));
                listen[fila] = new Listen(socket, jTable1,fila,chatRoom[fila].getTextPane());
                listen[fila].start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void updatePerformed(TableModelEvent evento) {
        if (evento.getType() == TableModelEvent.UPDATE) {
            int FirstRow = evento.getFirstRow();
            int Firstcolumna = evento.getColumn();
            try {

                String value = (String) tabla.getValueAt(FirstRow, Firstcolumna);
                Talk talk = new Talk(multisocket[FirstRow]);
                if (Firstcolumna == 5) {
                    if (!value.equals("")) {
                        try {
                            Double.parseDouble(value);
                            if (multisocket[FirstRow] != null) {
                                
                                talk.sendMessage("$cmd/Extra");
                                talk.sendMessage(value);
                            } else {
                                tabla.setValueAt("", FirstRow, Firstcolumna);
                            }
                        } catch (NumberFormatException ex) {
                            tabla.setValueAt("", FirstRow, Firstcolumna);
                        }
                    }
                }
                if (Firstcolumna == 7) {
                    if (!value.equals("")) {
                        if (multisocket[FirstRow] != null) {
                            chatRoom[FirstRow].setVisible(true);
                            chatRoom[FirstRow].sendMessage(value);
                            talk.sendMessage(value);
                            tabla.setValueAt("", FirstRow, Firstcolumna);
                        } else {
                            tabla.setValueAt("", FirstRow, Firstcolumna);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

}