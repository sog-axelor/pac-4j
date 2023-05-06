package com.unique.app.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.auth.google.MainApplication;
import com.example.auth.google.Utils;
import com.google.zxing.WriterException;


public class OtpValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.print(request.getParameter("email"));
		out.print("hello");
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


//
//String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
//	String emailAdd = email;
//	String companyName = "Axelor";
//	String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, emailAdd, companyName);
//	try {
//		Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);
//		System.out.print("Please enter 2fA code here -> ");
//		System.err.println(Utils.getTOTPCode(secretKey));
//		if (num.equals(Utils.getTOTPCode(secretKey))) {
//			System.out.println("Logged in successfully");
//			response.sendRedirect("welcome.jsp");
//		} else {
//			System.out.println("Invalid 2FA Code");
//
//		}
//	} catch (WriterException | IOException e) {
//		e.printStackTrace();
//	}
	

