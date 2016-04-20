package com.my.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.util.ConnUtil;
import com.mysql.jdbc.Connection;

@Controller
public class Test {

	@RequestMapping(value="/testt")
	@ResponseBody
	public Object Testt(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("12", "213123");
		return map;
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,String userName){
		HttpSession session = request.getSession();
		System.out.println("传入的userName="+userName);
		session.setAttribute("userName", userName);
		System.out.println("session里面的userName="+(String) session.getAttribute("userName"));
		return "test";
	}
	@RequestMapping(value="/test")
	public String getList(HttpServletRequest request,String userName){
		HttpSession session = request.getSession();
		String userName1 = (String) session.getAttribute("userName");
		System.out.println("userName1="+userName1);
		if(null==userName1){
			System.out.println("登录失败");
		}else{
			System.out.println("登录成功");
		}
		return "test";
	}
	
	@RequestMapping("/getCount")
	@ResponseBody
	public String getCount(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", "0");
		map.put("count", getContt(11));
		String re = getContt(11);
		String mapp = "{\"state\":\"0\",\"coubt\":\""+getContt(11)+"\"}";
		request.setAttribute("json", mapp);
		return "aa";
	}
	
	@RequestMapping("/getTable")
	public String getTaleInfo(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", "0");
		map.put("count", getContt(11));
		String re = getContt(11);
		String mapp = "{\"state\":\"0\",\"coubt\":\""+getContt(11)+"\"}";
		request.setAttribute("json", mapp);
		return "aa";
	}
	
	public String getContt(int m){
		String ss = "";
		for(int i=0;i<m;i++){
			ss = ss + (int)(1+Math.random()*(10-1+1));
		}
		return ss;
	}
	
	
	public void testt(){
		Connection conn = ConnUtil.getConn();
		PreparedStatement stmt = null;
		String sql = "";
		// 执行sql语句，并返回结果
		try {
			// 创建预编译sql对象
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				rs.getObject(1);
			}
//			MetaData m = null;
		}catch(Exception e){
			
		}
	}
}
