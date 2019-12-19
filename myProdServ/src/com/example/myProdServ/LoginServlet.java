package com.example.myProdServ;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestTomcat
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    private static final int NAME_CODE_RIGHT = 0; //  
    private static final int CODE_WRONG = 1;     //  
    private static final int NAME_WRONG = 2;     //  
  
    public LoginServlet(){  
  
    }  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        // TODO Auto-generated method stub  
             
        resp.setContentType("text/html;charset=utf-8");  
        req.setCharacterEncoding("utf-8");  
        resp.setCharacterEncoding("utf-8");  
        PrintWriter out = resp.getWriter();  
        String name = req.getParameter("NAME");  
        String code = req.getParameter("CODE");  
  
       //��������ʣ�û�����κβ�������HTML��ʽ��������������� 
       // out.println("<html>"); 
       // out.println("<head>"); 
        //out.println("<title>Tomcat Servlet����</title>"); 
        //out.println("</head>"); 
       // out.println("<body>"); 
        //out.println("Hello,��֪��������������ʵ�.");
       
        //�ֻ��ͻ��˷���  
        int ret = checkSubmit(name, code);  
        //String ret = checkSubmit(name, code); 
        //out.print("�����ǣ�"+ret); 
        //out.println("�����ǣ�"+ret); 
        out.print(ret);
        out.flush();  
        out.close();  
  
     }  
  
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        // TODO Auto-generated method stub  
    	/*
        if(req == null){  
            return;  
        }  
  
        resp.setContentType("text/html;charset=utf-8");  
        req.setCharacterEncoding("utf-8");  
        resp.setCharacterEncoding("utf-8");  
  
        PrintWriter out = resp.getWriter();  
        String name = req.getParameter("NAME");  
        String code = req.getParameter("CODE");  
  
        int ret = checkSubmit(name, code);  
        out.print(ret);  
        out.flush();  
        out.close();  
        */
    	doGet(req, resp);
    }  
  
    /** 
     * �жϵ�¼�������� 
     * @param name 
     * @param code 
     * @return 
     */  
    private int checkSubmit(String name, String code){  
        int ret = -2;  
        //String ret="";
        
        String ppwd=DBUtil.selectUPwd(name);
        //out.print(ppwd); 
        if(code.equals(ppwd))
        ret = NAME_CODE_RIGHT;
        else ret = CODE_WRONG;
        /*
        if(name.equals("admin")){  
            if(code.equals("123")){  
                ret = NAME_CODE_RIGHT;  
            }else{  
                ret = CODE_WRONG;  
            }  
        }else{  
            ret = NAME_WRONG;  
        }  
        */
        return ret;  
        //return  ppwd;
    }  
}
