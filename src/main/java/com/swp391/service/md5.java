package com.swp391.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;


@Service
public class md5 {
	public boolean getMD5(String Inputpassword, String Password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] messageDigest = md.digest(Inputpassword.getBytes());
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : messageDigest) {
	                String hex = Integer.toHexString(0xff & b);
	                if(hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	         String PwConverted = hexString.toString();
	            return PwConverted.equalsIgnoreCase(Password);
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }
}


