/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

import core.communication.DatabaseConnection;
import core.communication.DatabaseHandler;
import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class User {
    
    final public static HashMap<Integer, String> classHashMap;
    static {
	classHashMap = new HashMap<>(4);
	classHashMap.put(1, "FE");
	classHashMap.put(2, "SE");
	classHashMap.put(3, "TE");
	classHashMap.put(4, "BE");
    }
    
    final public static HashMap<Integer, String> branchHashMap;
    static {
	branchHashMap = new HashMap<>(3);
	branchHashMap.put(1, "CS");
	branchHashMap.put(2, "IT");
	branchHashMap.put(3, "ENTC");
    }
    
    int userId;
    String userName;
    String userEmail;
    int userClass;
    int userBranch;
    java.sql.Date userDate;

    public class InvalidUserException extends Exception {
    }
    
    public User(String userName, String userEmail, int userClass, int userBranch) throws InvalidUserException {
	this.userName = userName;
	this.userEmail = userEmail;
	this.userClass = userClass;
	this.userBranch = userBranch;
	
	if(!isNameValid() || !isEmailValid() || !isClassValid() || !isBranchValid())
	    throw new InvalidUserException();
    }
    
    public User(String userName, String userClass, String userBranch) throws InvalidUserException {
	
	this.userName = userName;
	for(Map.Entry entry : classHashMap.entrySet()){
	    if(entry.getValue().equals(userClass)){
		this.userClass = (Integer)entry.getKey();
		break;
	    }
	}
	for(Map.Entry entry : branchHashMap.entrySet()){
	    if(entry.getValue().equals(userBranch)){
		this.userBranch = (Integer)entry.getKey();
		break;
	    }
	}
    }
    
    public User(String userName, String userEmail, String userClass, String userBranch, java.sql.Date userDate) throws InvalidUserException {
	System.out.println("data : " + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userClass=" + userClass + ", userBranch=" + userBranch + ", userDate=" + userDate);
	
	this.userName = userName;
	this.userEmail = userEmail;
	for(Map.Entry entry : classHashMap.entrySet()){
	    if(entry.getValue().equals(userClass)){
		this.userClass = (Integer)entry.getKey();
		break;
	    }
	}
	for(Map.Entry entry : branchHashMap.entrySet()){
	    if(entry.getValue().equals(userBranch)){
		this.userBranch = (Integer)entry.getKey();
		break;
	    }
	}
	this.userDate = userDate;
	
	if(!isNameValid() || !isEmailValid() || !isClassValid() || !isBranchValid())
	    throw new InvalidUserException();
    }
    
    public boolean isNameValid() {
	if(userName == null || userName.length() < 8)
	    return false;
	return true;
    }
    
    public boolean isEmailValid() {
	if(userEmail == null || !userEmail.contains("@"))
	    return false;
	return true;
    }
    
    public boolean isClassValid() {
	if(userClass < 0 || userClass > classHashMap.size())
	    return false;
	return true;
    }
    
    public boolean isBranchValid() {
	if(userBranch < 0 ||  userBranch > branchHashMap.size())
	    return false;
	return true;
    }

    public String getUserName() {
	return userName;
    }

    public String getUserEmail() {
	return userEmail;
    }

    public int getUserClass() {
	return userClass;
    }

    public int getUserBranch() {
	return userBranch;
    }

    @Override
    public String toString() {
	return "User{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userClass=" + userClass + ", userBranch=" + userBranch + ", userDate=" + userDate + '}';
    }
    
}
