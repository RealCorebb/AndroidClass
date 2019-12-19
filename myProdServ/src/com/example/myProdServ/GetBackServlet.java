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
public class GetBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int INSERT_SUCCESS = 0; //  
    private static final int INSERT_ERROR = 1;     //       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBackServlet() {
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
		int ret ;  
		resp.setContentType("text/html;charset=utf-8");  
        req.setCharacterEncoding("utf-8");  
        resp.setCharacterEncoding("utf-8");  
        PrintWriter out = resp.getWriter();  
        //name,password,birthday,sex
        
        String name = req.getParameter("NAME"); 
        //out.print(name);
        String password = req.getParameter("CODE"); 
        Boolean exist=false;
        exist = DBUtil.isExist(name,"user");
        if(exist){
            Boolean falg=DBUtil.getbackUPwd(name,password);
    		if(falg)
    			ret=0;
    		else ret=1;
    			out.print(ret);
    	        out.flush();  
    	        out.close();  
        }
   
        else{
        	ret=1;
			out.print(ret);
	        out.flush();  
	        out.close();  
        }
	 
	}
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
