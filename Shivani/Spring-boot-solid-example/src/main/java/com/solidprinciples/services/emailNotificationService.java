package com.solidprinciples.services;

import org.springframework.context.annotation.Primary;

@Primary
public class emailNotificationService implements ServiceInterface{

	@Override
	public void sendOTP() {
		// TODO Auto-generated method stub
		//logic for email you create a same class  even for mobile as well which implements interface
		System.out.println("Sent the OTP through email Please check");
	}
	public String Resend() {
		return "I am from primary bean";
		
	}

}
