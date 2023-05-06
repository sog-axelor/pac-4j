package com.unique.app.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		   HttpSession session=request.getSession(); 
		
		  try{
              Class.forName("org.postgresql.Driver");
              Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/pac4j","axelor","axelor");
              String sql = "select email,pwd from Login";
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(sql);
              while(rs.next()){
                  String email1 = rs.getString(1);
                  String pwd1 = rs.getString(2);
                  if(email.equals(email1) && pwd.equals(pwd1)){
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
