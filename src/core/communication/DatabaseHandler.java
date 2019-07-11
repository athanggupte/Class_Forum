/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.communication;

import core.data.Topic;
import java.sql.*;
import core.data.User;
import core.utils.CryptoTools;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.PasswordView;

/**
 *
 * @author ADMIN
 */
public class DatabaseHandler {
    
    public static User login(Connection dbConnection, String username, String password) throws User.InvalidUserException {
	
	synchronized(dbConnection) {
	    try {
		PreparedStatement statement = dbConnection.prepareStatement("SELECT user_salt FROM users "
			+ "WHERE user_name=?;");
		statement.setString(1, username);
		
		ResultSet rs = statement.executeQuery();
		String salt = null;
		if(rs.next())
		    salt = rs.getString("user_salt");
		rs.close();
		statement.close();
		
		if(salt == null)
		    return null;
		
		statement = dbConnection.prepareStatement("SELECT * FROM "
			+ "(SELECT * FROM users WHERE user_name=?) AS U1 "
			+ "WHERE user_pass=SHA2(?,512);");
		statement.setString(1, username);
		statement.setString(2, CryptoTools.getSaltedPassword(password, CryptoTools.saltToBytes(salt)));
	    
		rs = statement.executeQuery();
		if(rs.next())
		    return new User(
			rs.getString("user_name"),
			rs.getString("user_email"),
			rs.getString("user_class"),
			rs.getString("user_branch"),
			rs.getDate("user_date"));
		
	    } catch (SQLException ex) {
		Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    return null;
	}
	
    }
    
    public static void insertRecord(Connection dbConnection, User record, String password) {
	
	synchronized(dbConnection) {
	    try {
		
		System.out.println("user : " + record.toString());
		
		byte [] salt = CryptoTools.getSalt(8);
		PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO "
			+ "users(user_name, user_email, user_pass, user_class, user_branch, user_date, user_salt) "
			+ "VALUES(?, ?, SHA2(?, 512), ?, ?, NOW(), ?);");
		statement.setString(1, record.getUserName());
		statement.setString(2, record.getUserEmail());
		statement.setString(3, CryptoTools.getSaltedPassword(password, salt));
		statement.setInt(4, record.getUserClass());
		statement.setInt(5, record.getUserBranch());
		statement.setString(6, CryptoTools.saltToString(salt));
		
		int result = statement.executeUpdate();
		
		System.out.println("Insert Result : " + result);
	
		
	
	    } catch (Exception e) {
		Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
	    }
	}
	
    }
    
    public static User searchUserById(Connection dbConnection, int userId) {
	User user = null;
	synchronized(dbConnection) {
	    try {
		PreparedStatement statement = dbConnection.prepareStatement("SELECT user_name, user_class, user_branch "
			+ "FROM users WHERE user_id=?;");
		statement.setInt(1, userId);
		
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
		    user = new User(rs.getString("user_name"),
			    rs.getString("user_class"),
			    rs.getString("user_branch"));
		}
		
	    } catch (Exception e) {
		Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
	    }
	
	}
	
	return user;
    }

    public static Topic searchTopicById(Connection dbConnection, int topicId) {
	Topic topic = null;
	synchronized(dbConnection) {
	    try {
		PreparedStatement statement = dbConnection.prepareStatement("SELECT * "
			+ "FROM topics WHERE topic_id=?;");
		statement.setInt(1, topicId);
		
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
		    topic = new Topic(rs.getString("topic_name"),
			    rs.getString("topic_subject"),
			    rs.getInt("topic_user"));
		}
		
	    } catch (Exception e) {
		Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, e);
	    }
	
	}
	
	return topic;
    }
    
}
