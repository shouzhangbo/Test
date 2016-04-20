package com.my.util;

import java.sql.DriverManager;
import java.sql.SQLException;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.framelib.utils.ConnUtil;
//import com.framelib.utils.JDBCProperUtils;
import com.mysql.jdbc.Connection;

public class ConnUtil {

	private static String url = "jdbc:mysql://localhost:3306/test" ;    
	private static String username = "root";
	private static String password = "";
	
    static {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
    }
    
    public static Connection getConn(){
    	java.sql.Connection con = null;
		try {
			con = DriverManager.getConnection(url , username , password );
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	return (Connection) con;
    }
    
    public static void main(String[] args) {
		System.out.println(getConn());
	}
}
