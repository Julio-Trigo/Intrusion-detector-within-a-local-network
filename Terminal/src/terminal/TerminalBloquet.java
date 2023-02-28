/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Master
 */
public class TerminalBloquet extends javax.swing.JFrame {

    /**
     * Creates new form Blocked
     */
    

    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public TerminalBloquet() {
        initComponents();
        fondo();
        setAlwaysOnTop(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        new jBlocked(this).block();
        new clienteTerminal(this, jLabel1).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 10, 110, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 60, 110, 30);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(30, 40, 210, 25);

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(30, 90, 210, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 263, 153);

        jLabel1.setFont(new java.awt.Font("Bungee Inline", 0, 120)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("6");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 50));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(273, 0, 262, 153);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jLabel1.setLocation(getWidth() - jLabel1.getWidth(), 0);
    }//GEN-LAST:event_formComponentResized

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            loguerit();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            loguerit();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void fondo() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ((javax.swing.JPanel) getContentPane()).setOpaque(false);
        javax.swing.ImageIcon uno = new javax.swing.ImageIcon(this.getClass().getResource("/Ico/fondo3.png"));
        int d = screenSize.width - uno.getIconWidth();
        //Icon ico = new ImageIcon(uno.getImage().getScaledInstance(screenSize.width, uno.getIconHeight() + d, Image.SCALE_DEFAULT));

        javax.swing.JLabel background = new javax.swing.JLabel();
        background.setIcon(uno);
        getLayeredPane().add(background, javax.swing.JLayeredPane.FRAME_CONTENT_LAYER);
        background.setBounds(0, 0, screenSize.width, screenSize.height);
    }

    private void loguerit() {

        if (jTextField1.getText().equals("admin")) {
            if (new String(jPasswordField1.getPassword()).equals("javiercito")) {
                dispose();
            }
        }
    }

    

}
