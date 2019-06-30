/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

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
    
}
