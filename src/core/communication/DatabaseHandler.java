/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.communication;

import java.sql.*;
import core.data.User;
import java.util.ArrayDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DatabaseHandler {
    
    /**
     * @param args the command line arguments
     */
    Connection dbConnection;
    //private static ArrayDeque dbQueryQueue;

    public DatabaseHandler() {

	final String dbURL = "jdbc:mysql://db4free.net:3306/forum_db_213";
	final String user = "adkiller007";
	final String password = "Athang213";
	
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    dbConnection = DriverManager.getConnection(dbURL, user, password);

	} catch (SQLException | ClassNotFoundException e) {
	    e.printStackTrace(); System.exit(1);
	} finally {
	    System.out.println("Connected");
	}

    }
    
    public void searchRecord(String fName) {
	
	try {
	    Statement statement = dbConnection.createStatement();
	    ResultSet rs = statement.executeQuery("SELECT * FROM subjects");
	    
	    while(rs.next()) {
		System.out.println(rs.getInt("sub_id") + "\t|\t" + rs.getString("sub_name"));
	    }
	    System.out.println("No. of records fetched : " + rs.getRow());
	    
	} catch (SQLException ex) {
	    Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
	}
	
    }
    
    public void insertRecord(User record) throws SQLException {

    }
    
}
