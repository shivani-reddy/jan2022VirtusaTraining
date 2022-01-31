package com.virtusa.pocstructures;

import com.virtusa.pocstructures.proxy.Proxy;
import com.virtusa.pocstructures.singleton.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocStructuresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocStructuresApplication.class, args);
		//PROXY

		Proxy proxy = new Proxy();

		//We will now run the proxy's process method, demonstrating how Proxy runs the ExpensiveObject creation method in addition to its own.
		proxy.process();
		//We will run it again, to showcase how Proxy is using a single instance of the Expensive Object it represents to perform its operations.
		proxy.process();

		//SINGLETON

		//In the lines below, we will get our singleton's one and only instance, and print out the randomNumber it has selected.
		Singleton singleton = Singleton.getInstance();

		System.out.println("This is the singleton's only number: " + String.valueOf(singleton.getRandomNumber()));
		// To demonstrate how this Singleton works, I will also bring it up from the Observable class

		// ... and the Proxy class
		System.out.println("This is the value of singleton in the Proxy class: " + String.valueOf(proxy.singleton.getRandomNumber()));
		// ... and the Factory class
	}

}
