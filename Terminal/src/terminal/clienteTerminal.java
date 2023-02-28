/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import chatRoom.Room;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Master
 */
public class clienteTerminal extends Thread {

    private Socket socket;
    private DataOutputStream Salida;
    private DataInputStream Entrada;
    private Properties config;
    private JFrame ui;
    private JLabel label;
    private terminalCliente cliente;
    private Room chatVersatil;
    private SimpleDateFormat format;

    public clienteTerminal(JFrame ui, JLabel label) {
        config = new propiedades().loadPrope();
        format = new SimpleDateFormat("HH:mm");
        this.ui = ui;
        this.label = label;
    }

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        @SuppressWarnings("UnusedAssignment")
        String respuesta;
        @SuppressWarnings("UnusedAssignment")
        boolean comprobar;
        while (true) {
            try {
                conectar();
                ui.setVisible(true);
                comprobar = true;
                while (comprobar) {
                    try {
                        respuesta = Entrada.readUTF();
                        comandos(respuesta);
                    } catch (IOException e) {
                        comprobar = false;
                    }
                }
                sleep(1000);
            } catch (InterruptedException | IOException ex) {
                if (ui.isVisible()) {
                    ui.setVisible(false);
                    if (cliente != null) {
                        cliente.dispose();
                    }
                } else {
                    if (cliente != null) {
                        cliente.dispose();
                    }
                }
            }
        }
    }

    private void conectar() throws IOException {
        if (config != null) {
            label.setText(config.getProperty("ORDENADOR"));
            socket = new Socket(config.getProperty("SERVIDOR"), Integer.parseInt(config.getProperty("PUERTO")));
        } else {
            socket = new Socket("MASTER-PC", 5000);
        }
        Salida = new DataOutputStream(socket.getOutputStream());
        Entrada = new DataInputStream(socket.getInputStream());
        chatVersatil = new Room(Salida);
        Salida.writeUTF(label.getText());
        Salida.writeUTF("$cmd/Encender");
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void comandos(String respuesta) throws IOException {
        
        switch (respuesta) {
            case "$cmd/Usar":
                ui.setVisible(false);
                cliente = new terminalCliente(label.getText());
                break;
            case "$cmd/Reusar":
                ui.setVisible(false);
                respuesta = Entrada.readUTF();
                cliente = new terminalCliente(label.getText(), respuesta);
                break;
            case "$cmd/Extra":
                respuesta = Entrada.readUTF();
                cliente.insertExtra(Double.parseDouble(respuesta));
                break;
            case "$cmd/Bloquear":
                cliente.dispose();
                limpiarChat();
                ui.setVisible(true);
                break;
            case "$cmd/Apagar":
                ui.dispose();
                cliente.dispose();
                System.exit(0);
                break;
            default:
                if (!chatVersatil.isVisible()) {
                    chatVersatil.setVisible(true);
                } else {
                    chatVersatil.toFront();
                }
                receptor(respuesta);
                break;
        }
    }


    private void receptor(String textIngresar) {
        textIngresar = buscarEmoticon(textIngresar);
        String HTML = chatVersatil.getjTextPane2().getText();
        int ini, fin;
        ini = HTML.indexOf("<body>") + 6;
        fin = HTML.lastIndexOf("</body>");
        String textIni = HTML.substring(0, ini);
        String textfin = HTML.substring(fin);
        String text = HTML.substring(ini, fin);
        text += createHTML(textIngresar);
        textIni += text + textfin;
        chatVersatil.getjTextPane2().setText(textIni);
    }

    private String buscarEmoticon(String part2) {
        String[] emoji = {":)", ":(", ":P", ":D", ":O"};
        String part1;
        int t;
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

    private String createHTML(String textIngresar) {
        String stylesheet
                = "background-color:#d9edc2;"
                + "border:1px solid #bfd7a4;"
                + "padding:1px 5px 1px 5px;";

        return "<table><tr><td align:top><img src='" + getClass().getResource("/chatRoom/Ico/admin1.png") + "'></td><td>"
                + "<div style ='" + stylesheet + "'><table><tr><td><font face='verdana' size=3>"
                + textIngresar + "</font></td></tr><tr><td><font face='verdana' size=1 color='gray'>"
                + format.format(new Date()) + "</font></td></tr></table></div></td></tr></table>\n";
    }

    private void limpiarChat() {
        chatVersatil.getjTextPane2().setText("<html>\n  <head>\n\n  </head>\n  <body>\n\n  </body>\n</html>\n");
    }

}
