/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.DrbgParameters;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CryptoTools {
    
    public static String getSaltedPassword(String password, byte [] salt) {
	String generatedPassword = null;
	
	try {
	    MessageDigest md = MessageDigest.getInstance("SHA-1");
	    md.update(salt);
	    
	    byte[] mdBytes = md.digest(password.getBytes());
	    StringBuilder sb = new StringBuilder();
            for(int i=0; i< mdBytes.length ;i++){
                sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16).substring(1));
            }
	    generatedPassword = sb.toString();
	    System.out.println("generated pass : " + generatedPassword);
	} catch (NoSuchAlgorithmException ex) {
	    Logger.getLogger(CryptoTools.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return generatedPassword;
    }   
    
    public static byte [] getSalt(int size) {
	SecureRandom rand = new SecureRandom();
	byte[] salt = new byte[size];
	rand.nextBytes(salt);
	
	return salt;
    }
    
    public static String saltToString(byte [] salt) {
	StringBuilder sb = new StringBuilder();
        for(int i=0; i< salt.length ;i++){
	    sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }
	String saltString = sb.toString();
	return saltString;
    }
    
    public static byte [] saltToBytes(String salt) {
	byte [] bytes = new BigInteger(salt, 16).toByteArray();
	if(bytes[0] == 0) {
	    byte [] output = new byte[bytes.length - 1];
	    System.arraycopy(bytes, 1, output, 0, output.length);
	    System.out.println("bytes : " + saltToString(output));
	    return output;
	}
	System.out.println("bytes : " + saltToString(bytes));
	return bytes;
    }
}
