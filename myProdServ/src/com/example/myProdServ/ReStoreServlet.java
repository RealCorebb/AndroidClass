package com.example.myProdServ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
public class ReStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int INSERT_SUCCESS = 0; //  
    private static final int INSERT_ERROR = 1;     //       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ret ;  
		resp.setContentType("text/html;charset=utf-8");  
        req.setCharacterEncoding("utf-8");  
        resp.setCharacterEncoding("utf-8");  
        PrintWriter out = resp.getWriter();  
        //name,password,birthday,sex
        
        String name = req.getParameter("NAME"); 
        //out.print(name);
        String type =req.getParameter("TYPE");
        Boolean exist=false;
        exist=DBUtil.isExist(name,"backup_atten");
           String falg=DBUtil.GetBackATTEN(name);
    		if(falg!=null)
    			ret=falg;
    		else ret="1";
    			out.print(ret);
    	        out.flush();  
    	        out.close();  
        }
	 
	
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
