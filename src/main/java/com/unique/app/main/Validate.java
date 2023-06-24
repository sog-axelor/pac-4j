package com.unique.app.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		boolean qr = false;


		   HttpSession session=request.getSession(); 
		
		  try{
              Class.forName("org.postgresql.Driver");
              Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/pac4j","axelor","axelor");
              String sql = "select email,pwd,qr from Login";
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(sql);
              while(rs.next()){
                  String email1 = rs.getString(1);
                  String pwd1 = rs.getString(2);
                  boolean qr1 = rs.getBoolean(3);
                  if(email.equals(email1) && pwd.equals(pwd1) && !(qr || qr1)){
                	  response.sendRedirect("welcome.jsp");
                	  session.setAttribute("email",email);
                  }else if(email.equals(email1) && pwd.equals(pwd1) && (qr || qr1)) {
                	  response.sendRedirect("otp.jsp");
                	  session.setAttribute("email",email);
                  }
              }
          }catch(Exception ex){
              System.out.println(ex);
          }
		
        
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
