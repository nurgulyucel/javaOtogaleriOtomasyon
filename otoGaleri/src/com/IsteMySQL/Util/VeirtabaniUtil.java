package com.IsteMySQL.Util;
import java.sql.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class VeirtabaniUtil {
	static Connection conn=null;
	public static Connection Baglan() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/otogaleri","root","mysql");
			return conn; 
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage().toString());
			return null;
			
		}
	}
public static String MD5Sifrele(String icerik) {
	try {
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[]sifrelenmis=md.digest(icerik.getBytes()); //icerik byte byte okunuyor
		BigInteger no=new BigInteger(1,sifrelenmis);
		
		String hashIcerik=no.toString(16);
		while(hashIcerik.length()<32) {
			hashIcerik="0"+hashIcerik;
		}
		return hashIcerik;
		
		
	}catch(NoSuchAlgorithmException e) {//sifreleme algoritmalarinda kullanilir.
		throw new RuntimeException(e);
		
		
	}
	

}

}
