package com.virtusatraining.assignment1;

//In this file, I will demonstrate a use case for the DependencyInversionPrinciple

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



//This SuperClass, called Person, will be used to represent a regular person who just wants to hang out.
@NoArgsConstructor
class Person{
    public List<Person> invitedPeople = new ArrayList<>();
    public String firstName = "";
    public String lastName = " ";
    // This function allows one Object of Class Person to add another Object of class Person to the invitedPeople list
    public void invitePerson(Person person){
        this.invitedPeople.add(person);
    }
    Person (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
//This class, called Employee, will be used to extend Person.
class Employee extends Person{
    Employee (String firstName, String lastName){
        super(firstName, lastName);
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Person paul = new Person("Paul", "Workabout");
        Employee stan = new Employee("Stan", "Kirkhope");
        Employee sheryl = new Employee("Sheryl", "Lidwick");
        //Sheryl can invite Paul, who is an object of class Person, to her party
        sheryl.invitePerson(paul);
        //Sheryl can ALSO invite Stan, who is an object of class Employee. The function invitePeople expects an object
        // of class Person, but because Employee extends Person, it can be injected in the place of a Person object.
        ///This is the "Dependency Injection" this principle is all about.
        sheryl.invitePerson(stan);
        for (Person person: sheryl.invitedPeople){
            System.out.println(person.firstName);
        }
    }
}
