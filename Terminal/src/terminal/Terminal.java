/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminal;

import com.alee.laf.WebLookAndFeel;

/**
 *
 * @author Master
 */
public class Terminal {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {
        WebLookAndFeel.install();
        new TerminalBloquet();
    }

    
    
}
