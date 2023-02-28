/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatRoom;



import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextPane;

/**
 *
 * @author Master
 */
public class Room extends javax.swing.JFrame {

    public JTextPane getjTextPane2() {
        return jTextPane2;
    }

    /**
     * Creates new form Room
     */
    private DataOutputStream enviarText;
    private SimpleDateFormat format;
    
    @SuppressWarnings({"OverridableMethodCallInConstructor", "CallToThreadStartDuringObjectConstruction"})
    public Room(DataOutputStream enviarText) {
        initComponents();
        format = new SimpleDateFormat("HH:mm");
        this.enviarText = enviarText;
        setLocationRelativeTo(null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setTitle("Servidor");
        setResizable(false);

        jTextPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 1, 1));
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPane1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );

        jTextPane2.setEditable(false);
        jTextPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jTextPane2.setContentType("text/html"); // NOI18N
        jTextPane2.setText("<html>\n  <head>\n\n  </head>\n  <body>\n\n  </body>\n</html>\n");
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextPane1.getText().equals("")) {
            try {
                enviarText.writeUTF(jTextPane1.getText());
                jTextPane2.setText(insertM(jTextPane1.getText()));
            } catch (IOException ex) {
                dispose();
            }
//            receptor(jTextPane1.getText(), "Room 2");
            jTextPane1.setText("");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextPane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyReleased
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            jTextPane1.setText("");
        }
    }//GEN-LAST:event_jTextPane1KeyReleased

    private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (!jTextPane1.getText().equals("")) {
                
                try {
                    enviarText.writeUTF(jTextPane1.getText());
                    jTextPane2.setText(insertM(jTextPane1.getText()));
                } catch (IOException ex) {
                    dispose();
                }

//                receptor(jTextPane1.getText(), "Room 2");
                jTextPane1.setText("");
            }
        }
    }//GEN-LAST:event_jTextPane1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables

    private String insertM(String textIngresar) {
        String HTML = jTextPane2.getText();
        textIngresar=buscarEmoticon(textIngresar);
        int ini, fin;
        ini = HTML.indexOf("<body>") + 6;
        fin = HTML.lastIndexOf("</body>");

        String textIni = HTML.substring(0, ini);
        String textfin = HTML.substring(fin);
        String text = HTML.substring(ini, fin);
        String stylesheet
                = "background-color:#d8ecf7;"
                + "border:1px solid #afcde3;"
                + "padding:1px 5px 1px 5px;"
                + "text-align: right;";
        text += "<table align='right'><tr><td><div style ='" + stylesheet + "'><table><tr><td><font face='verdana' size=3>"
                +textIngresar + "</font></td></tr><tr><td style='text-align: right;'><font face='verdana' size=1 color='gray'>" 
                + format.format(new Date()) + "</font></td></tr></table></div></td></tr></table>";
        textIni += text+ textfin;
        return textIni;
//        jTextPane2.setText(textIni);
    }

    @SuppressWarnings("UnusedAssignment")
    private String buscarEmoticon(String part2) {
        String[] emoji = {":)", ":(", ":P", ":D", ":O"};
        String part1;
        int t = 0;
        for (int i = 0; i < emoji.length; i++) {
            t = part2.indexOf(emoji[i]);
            if (t != -1) {
                part1 = "";
                while (t > -1) {
                    part1 += part2.substring(0, t);
                    part2 = part2.substring(t + 2);
                    part1 += "<img src='" + getClass().getResource("/chatRoom/Emoji/" + i + ".png") + "'>";
                    t = part2.indexOf(emoji[i]);
                }
                part2 = part1 + part2;
            }
        }
        return part2;
    }
}
