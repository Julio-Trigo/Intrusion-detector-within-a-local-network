/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Master
 */
public class ObservableC extends Thread {

    private boolean valid;
    terminalCliente cliente;
    DecimalFormat formato;
    double extra;
    double internet;
    Date tiempoInicial;

    ObservableC(Date inicial, terminalCliente cliente) {
        formato = new DecimalFormat("$ #,###.00");
        this.cliente = cliente;
        tiempoInicial = inicial;
        System.out.println(tiempoInicial);
        valid = true;
        internet = 0;
        extra = 0;
        cliente.setExtra(formato.format(extra));
    }

    @SuppressWarnings({"SleepWhileInLoop", "UnusedAssignment"})
    @Override
    public void run() {
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss a");
        
        Date tiempoActual;
        //hora de inicio
        cliente.insertTimeinicoms(hora.format(tiempoInicial));
//        paquete[0].setText();
        while (valid) {
            try {
                //tiempo transcurrido
                tiempoActual = new Date();
                cliente.setRuntime(tiempoGenerado(tiempoInicial, tiempoActual));
                //agrega el gasto del tiempo
                cliente.insertInternet(cargarInternet(tiempoGenerado(tiempoInicial, tiempoActual)));
                //agrega el toal
                cliente.insertTotal(totalizar());
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ObservableC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String tiempoGenerado(Date tiempoInicial, Date tiempoRelativo) {
        @SuppressWarnings("UnusedAssignment")
        String tiempo = "";
        Long second = (tiempoRelativo.getTime() - tiempoInicial.getTime()) / 1000;
        String horas, segundos, minutos;
        int minute = (int) (second / 60);
        int hour = (int) (minute / 60);
        
        for (int i = 0; i < minute; i++) {
            second = second - 60;
        }
        for (int i = 0; i < hour; i++) {
            minute = minute - 60;
        }
        if (hour < 10) {
            horas = "0" + hour;
        } else {
            horas = "" + hour;
        }
        if (second < 10) {
            segundos = "0" + second;
        } else {
            segundos = "" + second;
        }
        if (minute < 10) {
            minutos = "0" + minute;
        } else {
            minutos = "" + minute;
        }
        tiempo = horas + ":" + minutos + ":" + segundos;
        return tiempo;
    }

    private String cargarInternet(String tiempo) {
        String hour = tiempo.substring(0, tiempo.indexOf(":"));
        String minute = tiempo.substring(tiempo.indexOf(":") + 1, tiempo.lastIndexOf(":"));
        double total=0;
        if (Integer.parseInt(minute) <= 30 && Integer.parseInt(minute) >= 0) {
            total += 4;
        }
        if (Integer.parseInt(minute) > 30) {
            total += 8;
        }
        if (Integer.parseInt(hour) > 0) {
            for (int i = 0; i < Integer.parseInt(hour); i++) {
                total += 8;
            }
        }
        internet=total;
        return formato.format(total);
    }

    public void Romper() {
        valid = false;
    }
    
    public void setExtra(double extra) {
        this.extra = extra;
        cliente.setExtra(formato.format(extra));
    }

    private String totalizar() {
        return formato.format((extra + internet));
    }
}
