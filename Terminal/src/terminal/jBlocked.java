/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class jBlocked {

    private JFrame jframe = null;

    public jBlocked(JFrame f) {
        this.jframe = f;
    }

    public void block() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                front();
            }
        }, 10, 10, TimeUnit.MILLISECONDS);
    }

    public void front() {
        if (jframe != null) {
            jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximizado
            jframe.toFront();
        }else{
            System.exit(0);
        }
    }

}

