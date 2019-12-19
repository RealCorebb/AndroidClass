package com.example.myProdServ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class DBUtil 
{
  //与 MySql数据库建立连接
    public static Connection getConnection()
	{
    	Connection con=null;
		try
		{			
			Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
			String url="jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8";//链接数据库语句
            con= (Connection) DriverManager.getConnection(url); //链接数据库
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
    
    public static void delete(String sql)
    {
    	try
		{
			Connection con=getConnection();			
			Statement st=con.createStatement();			
			st.executeUpdate(sql);						
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
     //登录密码验证
    public static String selectUPwd(String uname)
    {
		String result=null;
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String sql="select U_pswd from user where U_name='"+uname+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				result=rs.getString(1);
				//out.print(result); 
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    
		return result;
    	
    }
    //存在验证
   public static boolean isExist(String uname,String database)
   {
	   String result=null;
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String sql="select * from "+database+" where U_name='"+uname+"'";
			ResultSet rs=st.executeQuery(sql);		
			if(rs.next()){
				result=rs.getString(1);
				//return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		if(result!=null)
			return true;
		else
			return false;
   	
   }
   
    //忘记密码
    public static boolean getbackUPwd(String uname,String password)
    {
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String sql="update user set U_pswd='"+password+"' where U_name='"+uname+"'";
        	st.executeUpdate(sql);
        	st.close();
    		con.close();
    		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
    }
    //备份联系人
    public static boolean BackUpATTEN(String uname,String data,boolean exist)
    {
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String sql;
			if(!exist){
            sql="insert into backup_atten(U_name,data) value('"+uname+"','"+data+"')";
			}
			else{
			sql="update backup_atten set data='"+data+"' where U_name='"+uname+"'";
			}
            st.execute("set char set 'gbk'");
        	st.executeUpdate(sql);
        	st.close();
    		con.close();
    		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
    }
    //还原联系人
    public static String GetBackATTEN(String uname)
    {
    	String result=null;
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			String sql;
            sql="select data from backup_atten where U_name='"+uname+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				result=rs.getString(1);
				//out.print(result); 
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
    }
  //添加用户信息到MySql数据库
    public static Boolean insertUser(String name,String password,String birthday,String sex)
    {
    	Boolean falg=false;
    	try{
    		Connection con=getConnection();
    		Statement st=con.createStatement();
            String sql="insert into user(U_name,U_pswd,U_bird,U_sex) value('"+name+"','"+password+"','"+birthday+"','"+sex+"')";
            st.execute("set char set 'gbk'");
            st.executeUpdate(sql);
    		st.close();
    		con.close();
        	falg=true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
		return falg;
    	
    }
  //添加用户信息到MySql数据库
    public static Boolean insertProdDB(String sId,String sName,String sBa)
    {
    	Boolean falg=false;
    	
		//String sId=String.valueOf(id);
		//String sBa=String.valueOf(account.getBalance());
		try{
    		Connection con=getConnection();
    		Statement st=con.createStatement();
            String sql="insert into account(_id,name,balance) value('"+sId+"','"+sName+"','"+sBa+"')";
            st.execute("set char set 'gbk'");
            st.executeUpdate(sql);
    		st.close();
    		con.close();
    		falg=true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return falg;
    }
    public static Boolean deleteProdDB(String sId)
    {
    	Boolean falg=false;
    	try{
    		Connection con=getConnection();
        	Statement st=con.createStatement();
        	String sql="delete from account where _id='"+sId+"'";
        	st.execute(sql);
        	st.close();
    		con.close();
        	falg=true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
		return falg;
    	
    }
    public static Boolean updateProdDB(String sId,String sName,String sBa)
    {
       Boolean falg=false;
    	
		//String sId=String.valueOf(id);
		//String sBa=String.valueOf(account.getBalance());
		try{
			
    		Connection con=getConnection();
        	Statement st=con.createStatement();
        	String sql="update account set name='"+sName+"',balance='"+sBa+"'where _id='"+sId+"'";
        	st.executeUpdate(sql);
        	st.close();
    		con.close();
    		falg=true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return falg;
    }
}


