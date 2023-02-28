/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Master
 */
public class terminalCliente extends javax.swing.JFrame {

    /**
     * Creates new form terminalCliente
     */
    
    private int x;
    private int y;
    public ObservableC task;
    @SuppressWarnings({"LeakingThisInConstructor", "CallToThreadStartDuringObjectConstruction"})
    public terminalCliente(String text) {
        initComponents();
        favicon();
        Fondo.setText("PC # "+ text);
        reposicionamiento();
        task = new ObservableC(new Date(),this);
        task.start();
    }
    
    @SuppressWarnings("CallToThreadStartDuringObjectConstruction")
    public terminalCliente(String text, String time) {
        initComponents();
        favicon();
        System.out.println(time);
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy hh:mm:ss a");
        Fondo.setText("PC # " + text);
        reposicionamiento();
        try {
            task = new ObservableC(format.parse(time), this);
            task.start();
        } catch (ParseException ex) {
            Logger.getLogger(terminalCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void favicon() {
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("/Ico/ico.png"));
        Image Image = ImageIcon.getImage();
        setIconImage(Image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Hora1 = new javax.swing.JLabel();
        Hora2 = new javax.swing.JLabel();
        Minuto1 = new javax.swing.JLabel();
        Minuto2 = new javax.swing.JLabel();
        Segundo1 = new javax.swing.JLabel();
        Segundo2 = new javax.swing.JLabel();
        Inicio = new javax.swing.JLabel();
        Internet = new javax.swing.JLabel();
        Extra = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        Inicio1 = new javax.swing.JLabel();
        Internet1 = new javax.swing.JLabel();
        Extra1 = new javax.swing.JLabel();
        Total1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ico/CloseNotify.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(274, 0, 20, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/terminal/barratitulo.png"))); // NOI18N
        jLabel1.setText("Net Master");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-6, 0, 300, 40);

        Hora1.setFont(new java.awt.Font("Cookie", 0, 48)); // NOI18N
        Hora1.setForeground(new java.awt.Color(255, 255, 255));
        Hora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Hora1.setText("0");
        jPanel1.add(Hora1);
        Hora1.setBounds(26, 65, 30, 40);

        Hora2.setFont(new java.awt.Font("Cookie", 0, 48)); // NOI18N
        Hora2.setForeground(new java.awt.Color(255, 255, 255));
        Hora2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Hora2.setText("0");
        jPanel1.add(Hora2);
        Hora2.setBounds(66, 65, 30, 40);

        Minuto1.setFont(new java.awt.Font("Cookie", 0, 48)); // NOI18N
        Minuto1.setForeground(new java.awt.Color(255, 255, 255));
        Minuto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minuto1.setText("0");
        jPanel1.add(Minuto1);
        Minuto1.setBounds(115, 65, 30, 40);

        Minuto2.setFont(new java.awt.Font("Cookie", 0, 48)); // NOI18N
        Minuto2.setForeground(new java.awt.Color(255, 255, 255));
        Minuto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minuto2.setText("0");
        jPanel1.add(Minuto2);
        Minuto2.setBounds(154, 65, 30, 40);

        Segundo1.setFont(new java.awt.Font("Cookie", 0, 48)); // NOI18N
        Segundo1.setForeground(new java.awt.Color(255, 255, 255));
        Segundo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Segundo1.setText("0");
        jPanel1.add(Segundo1);
        Segundo1.setBounds(204, 65, 30, 40);

        Segundo2.setFont(new java.awt.Font("Cookie", 0, 48)); // NOI18N
        Segundo2.setForeground(new java.awt.Color(255, 255, 255));
        Segundo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Segundo2.setText("0");
        jPanel1.add(Segundo2);
        Segundo2.setBounds(244, 65, 30, 40);

        Inicio.setBackground(new java.awt.Color(0, 0, 0));
        Inicio.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Inicio.setForeground(new java.awt.Color(255, 255, 255));
        Inicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Inicio.setText("a");
        Inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Inicio);
        Inicio.setBounds(140, 120, 140, 30);

        Internet.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Internet.setForeground(new java.awt.Color(255, 255, 255));
        Internet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Internet.setText("a");
        Internet.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Internet);
        Internet.setBounds(140, 150, 140, 30);

        Extra.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Extra.setForeground(new java.awt.Color(255, 255, 255));
        Extra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Extra.setText("a");
        Extra.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Extra);
        Extra.setBounds(140, 180, 140, 30);

        Total.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Total.setText("a");
        Total.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Total);
        Total.setBounds(140, 210, 140, 30);

        Inicio1.setBackground(new java.awt.Color(0, 0, 0));
        Inicio1.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Inicio1.setForeground(new java.awt.Color(255, 255, 255));
        Inicio1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Inicio1.setText("Hora de Inicio");
        Inicio1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Inicio1);
        Inicio1.setBounds(30, 120, 140, 30);

        Internet1.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Internet1.setForeground(new java.awt.Color(255, 255, 255));
        Internet1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Internet1.setText("Internet Precio");
        Internet1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Internet1);
        Internet1.setBounds(30, 150, 140, 30);

        Extra1.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Extra1.setForeground(new java.awt.Color(255, 255, 255));
        Extra1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Extra1.setText("Extra");
        Extra1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Extra1);
        Extra1.setBounds(30, 180, 140, 30);

        Total1.setFont(new java.awt.Font("Cookie", 0, 24)); // NOI18N
        Total1.setForeground(new java.awt.Color(255, 255, 255));
        Total1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Total1.setText("Total");
        Total1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jPanel1.add(Total1);
        Total1.setBounds(30, 210, 140, 30);

        Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/terminal/Reloj(2).png"))); // NOI18N
        Fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FondoMouseDragged(evt);
            }
        });
        Fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FondoMousePressed(evt);
            }
        });
        jPanel1.add(Fondo);
        Fondo.setBounds(0, 0, 316, 270);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondoMousePressed
        
    }//GEN-LAST:event_FondoMousePressed

    private void FondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondoMouseDragged
        
    }//GEN-LAST:event_FondoMouseDragged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        task.Romper();
    }//GEN-LAST:event_formWindowClosing

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Extra;
    private javax.swing.JLabel Extra1;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Hora1;
    private javax.swing.JLabel Hora2;
    private javax.swing.JLabel Inicio;
    private javax.swing.JLabel Inicio1;
    private javax.swing.JLabel Internet;
    private javax.swing.JLabel Internet1;
    private javax.swing.JLabel Minuto1;
    private javax.swing.JLabel Minuto2;
    private javax.swing.JLabel Segundo1;
    private javax.swing.JLabel Segundo2;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel Total1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void reposicionamiento() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(pantalla.width - getWidth(), 0);
        setVisible(true);
    }
    
    public void insertExtra(double extra){
        task.setExtra(extra);
    }
    
    public void setRuntime(String time){
        Hora1.setText(time.substring(0, 1));
        Hora2.setText(time.substring(1, 2));
        Minuto1.setText(time.substring(3, 4));
        Minuto2.setText(time.substring(4, 5));
        Segundo1.setText(time.substring(6, 7));
        Segundo2.setText(time.substring(7));
    }
    
    public void insertTimeinicoms(String time){
        Inicio.setText(time);
    }
    
    public void insertInternet(String precio){
        Internet.setText(precio);
    }
    
    public void insertTotal(String precio){
        Total.setText(precio);
    }

    public void setExtra(String format) {
        Extra.setText(format);
    }
}
