/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class User {
    
    enum Class{
	FE, SE, TE, BE
    };
    
    int userId;
    String userName;
    String userEmail;
    Class userClass;
    byte userDivision;
    java.sql.Date userDate;

    public User(String userName, String userEmail) {
	this.userName = userName;
	this.userEmail = userEmail;
    }

    public String getUserName() {
	return userName;
    }

    public String getUserEmail() {
	return userEmail;
    }

    public Class getUserClass() {
	return userClass;
    }

    public byte getUserDivision() {
	return userDivision;
    }
    
    
    
}
