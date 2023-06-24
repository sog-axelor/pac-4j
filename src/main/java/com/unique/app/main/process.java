package com.unique.app.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class process extends HttpServlet{
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String qr = request.getParameter("qr");
		HttpSession session=request.getSession(); 
		Object email = session.getAttribute("email");
		boolean qrValue = Boolean.parseBoolean(qr);
		out.print(qrValue);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emf.createEntityManager();
		  EntityTransaction transaction = null;

	        try {
	            transaction = entityManager.getTransaction();
	            transaction.begin();

	            // Retrieve the entity to be updated
	            Login login = entityManager.createQuery("SELECT e FROM Login e WHERE e.email = :email", Login.class)
	                    .setParameter("email", email)
	                    .getSingleResult();

	            // Update the desired property
	            login.setQr(qrValue);

	            // Save the changes
	            entityManager.merge(login);

	            transaction.commit();
	            System.out.println("Value updated successfully.");
	            response.sendRedirect("welcome.jsp");
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	            emf.close();
	        }
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
