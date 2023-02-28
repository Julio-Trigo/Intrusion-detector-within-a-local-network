/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class propiedades {

    /**
     * Creates a new instance of MiAplicacion
     */
    Properties config;
    InputStream configInput;

    public propiedades() {
        config = new Properties();
        configInput = null;
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public Properties loadPrope() {
        try {
            File af = new File(urlPath("Config.properties"));
            if (af.exists()) {
                configInput = new FileInputStream(urlPath("Config.properties"));

                config.load(configInput);
                System.out.println(config.getProperty("PUERTO"));
                System.out.println(config.getProperty("SERVIDOR"));
                System.out.println(config.getProperty("ORDENADOR"));
            }else{
                new Instal().setVisible(true);
                config = null;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return config;
    }

    private String urlPath(String r) {
        String ruta = getClass().getResource("").toString();
        for (int i = 0; i < 3; i++) {
            ruta = ruta.substring(0, ruta.lastIndexOf("/"));
        }
        ruta += "/" + r;
        ruta = ruta.substring(ruta.indexOf("/") + 1);
        int posicion;
        for (int i = 0; i < ruta.length(); i++) {
            posicion = ruta.indexOf("%20");
            if (posicion > -1) {
                ruta = ruta.substring(0, posicion) + " " + ruta.substring(posicion + 3);
            } else {
                break;
            }
        }
        return ruta;
    }

}
