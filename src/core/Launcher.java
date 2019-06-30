/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.communication.DatabaseHandler;
import core.gui.windows.LauncherWindow;

/**
 *
 * @author ADMIN
 */
public class Launcher {
    
    static volatile DatabaseHandler databaseThread;
    
    public static void main(String[] args) {
	
	databaseThread = new DatabaseHandler();
	
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		new LauncherWindow(databaseThread).setVisible(true);
	    }
	});
    }
    
}
