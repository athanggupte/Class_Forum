/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.communication.DatabaseConnection;
import core.data.User;
import core.gui.windows.DashboardWindow;
import core.gui.windows.LauncherWindow;
import core.gui.windows.LoadingDialog;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Launcher {
    
    //static DatabaseConnection dbConnection;
    
    public static void main(String[] args) {
	
	//dbConnection = new DatabaseConnection();
	
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    new LauncherWindow(new DatabaseConnection()).setVisible(true);
		//    new DashboardWindow(new User("athang213", "athang213@gmail.com", "TE", "CS", new java.sql.Date(2019,07,07))).setVisible(true);
		} catch (Exception ex) {
		    Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	});
    }
    
}
