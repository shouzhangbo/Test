package com.my.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class QueryResylt {
	
	public List<Object> getTable(Connection con,String sql){
		List<Object> list = new ArrayList<Object>();
		List<String> arr = new ArrayList<String>();
		int stat = 0;
		String str = sql.substring(sql.indexOf("select"),sql.indexOf("from")).trim();
		if("*".equals(str))
		{
			stat = 1;
		}else{
			String[] arry = str.split(",");
			arr = Arrays.asList(arry);
		}
		Statement state;
		try {
		   state = con.createStatement();
		   ResultSet rs = state.executeQuery(sql);
		   ResultSetMetaData rsmd = rs.getMetaData();
		   
		   if(null!=arr||arr.size()>0){
			   while(rs.next()){
				   Map<String,Object> map = new HashMap<String,Object>();
				   for(String s:arr){
					   map.put(s, rs.getObject(s));
				   }
				   list.add(map);
			   }
		   }else{
			   while(rs.next()){
				   Map<String,Object> map = new HashMap<String,Object>();
				   for(int i = 1; i <= rsmd.getColumnCount(); i++)
				   {
					   	 map.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
				   }
				   list.add(map);
			 }
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void getTableInfo(Connection con){
		String sql = "select * from "+"test";
		   Statement state;
		try {
			state = con.createStatement();
		
		   ResultSet rs = state.executeQuery(sql);
		   ResultSetMetaData rsmd = rs.getMetaData() ;
		   while(rs.next()){
			   System.out.println(rs.getObject("id")+","+rs.getObject("name")+","+rs.getObject("sex"));
//			   System.out.println(rs.getObject("name"));
//			   System.out.println(rs.getObject("sex"));
		   }
//		   for(int i = 1; i <= rsmd.getColumnCount(); i++)
//		   {
//		         String colname = rsmd.getColumnName(i);
//		         System.out.println(colname);
//	             String typeName = rsmd.getColumnTypeName(i);
//	             System.out.println(typeName);
//	             int itype = rsmd.getColumnType(i);
//	             System.out.println(itype);
//	             int size = rsmd.getColumnDisplaySize(i);
//	             int precision=rsmd.getPrecision(i);
//	             int n = rsmd.isNullable(i);
//	             int scale=rsmd.getScale(i);
//	             boolean nullable = true;
//		   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection con = ConnUtil.getConn();
		getTableInfo(con);
	}

}
