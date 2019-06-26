/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.database;

import java.sql.*;
import core.data.User;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DatabaseHandler {

    /**
     * @param args the command line arguments
     */
    Connection dbConnection;
    PreparedStatement dbStatement;

    public DatabaseHandler() {

	final String dbURL = "jdbc:mysql://192.168.1.9:3306/DB2";
	final String user = "athang213";
	final String password = "One1Two2Three3";

	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    dbConnection = DriverManager.getConnection(dbURL, user, password);

	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    public void searchRecord(String fName) throws SQLException {
	try {
	    //Prepare Statement
	    dbStatement = dbConnection.prepareStatement("");
	    //Set Parameters
	    //TODO
	    //Execute Statement
	    ResultSet rs = dbStatement.executeQuery();
	    
	} catch (SQLException ex) {
	    ex.printStackTrace();
	} finally {
	    dbStatement.close();
	}
    }
    
    public void insertRecord(User record) throws SQLException {
	try {
	    //Prepare Statement
	    dbStatement = dbConnection.prepareStatement("");
	    //Set Parameters
	    //TODO
	    //Execute Statement
	    dbStatement.execute();
	} catch (SQLException ex) {
	    ex.printStackTrace();
	} finally {
	    dbStatement.close();
	}
    }

    public ArrayList<User> readRecords() {
	ArrayList<User> recordList = new ArrayList<>();

	try {
	    dbStatement = dbConnection.prepareStatement("");
	    ResultSet rs = dbStatement.executeQuery();
	    //TODO Add results to recordList
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
	
	return recordList;
    }
    
}
