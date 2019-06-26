/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.database.DatabaseHandler;
import core.gui.LauncherWindow;

/**
 *
 * @author ADMIN
 */
public class Launcher {
    
    public static void main(String[] args) {
	
	final DatabaseHandler dbHandler = new DatabaseHandler();
	
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new LauncherWindow(dbHandler).setVisible(true);
	    }
	});
    }
    
}
