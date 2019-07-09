/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.communication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DatabaseConnection {
    
    private Connection dbConnection;

    public DatabaseConnection() {
	
/*	final String dbURL = "jdbc:mysql://db4free.net:3306/forum_db_213";
	final String dbUsername = "adkiller007";
	final String dbPassword = "Athang213";
*/	
	final String dbURL = "jdbc:mysql://127.0.0.1:3306/db2";
	final String dbUsername = "athang213";
	final String dbPassword = "One1Two2Three3";
	

	try {
	    this.dbConnection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
	} catch (SQLException ex) {
	    Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    System.out.println("Connected");
	}
    }

    public Connection getConnection() {
	return dbConnection;
    }

    public void close() {
	try {
	    dbConnection.close();
	} catch (SQLException ex) {
	    Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    
}
