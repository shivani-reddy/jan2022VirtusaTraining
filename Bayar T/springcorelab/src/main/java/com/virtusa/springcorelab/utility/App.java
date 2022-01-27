package com.virtusa.springcorelab.utility;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.virtusa.springcorelab.models.Config;
import com.virtusa.springcorelab.models.Customer;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		//Resource resource=new ClassPathResource("com/virtusa/springcorelab"
		//		+ "/resources/spring-config.xml");
		//BeanFactory beanFactory=new XmlBeanFactory(resource);
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(Config.class);
		//IOC
		Customer customer=(Customer) ctxt.getBean("customer1");
		System.out.println("CustomerId "+customer.getCustomerId() + ", CustomerName " + customer.getName());
		customer=(Customer) ctxt.getBean("customer2");
		System.out.println("CustomerId "+customer.getCustomerId() + ", CustomerName " + customer.getName());
		customer=(Customer) ctxt.getBean("default");
		System.out.println("CustomerId "+customer.getCustomerId() + ", CustomerName " + customer.getName());
		customer=(Customer) ctxt.getBean(Customer.class);
		((ConfigurableApplicationContext)ctxt).close();
	}

}
