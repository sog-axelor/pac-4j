package com.example.auth.google;

import com.fasterxml.jackson.core.sym.Name;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.Scanner;



public class MainApplication {

	
	 public static void name(String code) throws WriterException, IOException {
		 String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
			String emailAdd = "v.desai@gmail.com";
			String companyName = "Veer Narmad South Gujarat University";
			String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, emailAdd, companyName);
			Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);
			System.out.print("Please enter 2fA code here -> ");
			System.err.println(Utils.getTOTPCode(secretKey));
			if (code.equals(Utils.getTOTPCode(secretKey))) {
				System.out.println("Logged in successfully");
			} else {
				System.out.println("Invalid 2FA Code");

			}
	}
	 
	 
	public static void main(String[] args) throws WriterException, IOException {
		
	}

}
