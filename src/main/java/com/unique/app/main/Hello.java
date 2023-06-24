package com.unique.app.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		if(pwd.equals(cpwd)) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Login login = new Login();
			login.setEmail(email);
			login.setName(name);
			login.setPwd(pwd);
			login.setQr(false);
			em.persist(login);
			
			em.getTransaction().commit();
			em.close();
			emf.close();
			response.sendRedirect("log.jsp");
			
		}else {
			response.sendRedirect("reg.jsp");
		}
		
		
		
		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

//String email = request.getParameter("email");
//String pwd = request.getParameter("pwd");
//
//  try{
//      Class.forName("org.postgresql.Driver");
//      Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/pac4j","axelor","axelor");
//      String sql = "select email,pwd from Login";
//      Statement st = con.createStatement();
//      ResultSet rs = st.executeQuery(sql);
//      while(rs.next()){
//          String email1 = rs.getString(1);
//          String pwd1 = rs.getString(2);
//          
//          if(email.equals(email1) && pwd.equals(pwd1)){
//        	  response.sendRedirect("otp.jsp");
//          }
//      }
//  }catch(Exception ex){
//      System.out.println(ex);
//  }

