/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.communication;

import java.sql.*;
import core.data.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.PasswordView;

/**
 *
 * @author ADMIN
 */
public class DatabaseHandler {
    
    public static void searchRecord(Connection dbConnection, String username, String password) {
	
	synchronized(dbConnection) {
	    try {
		PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM users "
			+ "WHERE user_name=? AND user_pass=SHA2(?, 512);");
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet rs = statement.executeQuery();
	    
		while(rs.next()) {
		    System.out.println(rs.getInt("user_id")
			    + "\t|\t" + rs.getString("user_name")
			    + "\t|\t" + rs.getString("user_email")
			    + "\t|\t" + rs.getString("user_class")
			    + "\t|\t" + rs.getInt("user_div")
		    );
		}
		System.out.println("No. of records fetched : " + rs.getRow());
	    
	    } catch (SQLException ex) {
		Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
    }
    
    public static void insertRecord(Connection dbConnection, User record, String password) {
	
	synchronized(dbConnection) {
	    try {
		PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO "
			+ "users(user_name, user_email, user_pass, user_class, user_div, user_date, user_salt) "
			+ "VALUES(?, ?, SHA2(?, 512), 'TE', 2, NOW(), 'l00ph0le');");
		statement.setString(1, record.getUserName());
		statement.setString(2, record.getUserEmail());
		statement.setString(3, password);
		
		int result = statement.executeUpdate();
		
		System.out.println("Insert Result : " + result);
	    } catch (Exception e) {
		Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
	    }
	}
	
    }
    
}
