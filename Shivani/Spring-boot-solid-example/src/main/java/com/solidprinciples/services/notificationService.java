package com.solidprinciples.services;

import org.springframework.context.annotation.Lazy;

@Lazy(value=true)
public class notificationService implements ServiceInterface{
   public void sendOTP() {
	   //write the logic to integrate the email api
	   System.out.println("My medium is Mobile");
   }
}
//Now i want add new functionality by adding sendOPT through mobile number
//Now i we cannot modify the extsiting code but we need to add the new feature designing in such a way comes under open closed principle.
//so we need create an interface which implements the sendOTP function.