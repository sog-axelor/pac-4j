package com.unique.app.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.auth.google.MainApplication;
import com.example.auth.google.Utils;
import com.google.zxing.WriterException;

public class Otp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		String d1 = request.getParameter("d1");
		String d2 = request.getParameter("d2");
		String d3 = request.getParameter("d3");
		String d4 = request.getParameter("d4");
		String d5 = request.getParameter("d5");
		String d6 = request.getParameter("d6");
		String email = request.getParameter("email");
		String code = d1+d2+d3+d4+d5+d6;
			
		 String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
			String emailAdd = email;
			String companyName = "Veer Narmad South Gujarat University";
			String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, emailAdd, companyName);
			try {
				Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);
				System.err.println(Utils.getTOTPCode(secretKey));
				if (code.equals(Utils.getTOTPCode(secretKey))) {
					response.sendRedirect("welcome.jsp");
				} else {
					response.sendRedirect("log.jsp");
				}
			} catch (WriterException | IOException e) {
				e.printStackTrace();
			}
			
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

