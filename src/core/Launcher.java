/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.communication.DatabaseConnection;
import core.gui.windows.LauncherWindow;

/**
 *
 * @author ADMIN
 */
public class Launcher {
    
    static DatabaseConnection dbConnection;
    
    public static void main(String[] args) {
	
	dbConnection = new DatabaseConnection();
	
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		new LauncherWindow(dbConnection).setVisible(true);
	    }
	});
    }
    
}
