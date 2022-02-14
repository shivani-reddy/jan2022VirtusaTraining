package com.solidprinciples.Spring_boot_solid_example;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        
    }
}
