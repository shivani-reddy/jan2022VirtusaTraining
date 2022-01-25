package com.virtusatraining.assignment1;

// In this file, I will demonstrate the Liskov Substitution Principle

// In this class, I will create a base shape with a few key properties and methods

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
abstract class Shape {
    double height;
    double width;

    public abstract double area();
    public abstract double circumference();
}

// This following extension of Shape violated the Liskov Substitution Principle Example
class Circle extends Shape{


    @Override
    public double area(){
        return 0;
    }

    @Override
    public double circumference() {
        return 0;
    }
    // This violates one of the rules of Shape- by making it so that the Weight and Height are the same,
    /// setHeight breaks the rule set forth in shape that allows width and height to be set independently.
    public void setHeight(double newHeight){
        super.setHeight(newHeight);
        super.setWidth(newHeight);
    }
}

//This is a correction to Shape that will allow its circle subclass to set its own rules on width and height
///without violating Liskov's Substitution
//By not creating Getters or Setters in GoodShape, we ensure that GoodShape can be extended to a variety of shapes without
///violating this principle

@AllArgsConstructor
abstract class GoodShape {
    double height;
    double width;

    public abstract double area();
    public abstract double circumference();
}


class GoodSquare extends GoodShape{
    // Inside of GoodSquare, we can create a constructor that only accepts a single double as its edge length. We can
    /// also use the GoodShape abstract class' constructor with GoodSquare, without violating its rules.
    GoodSquare(double length){
        super(length, length);
    }

    @Override
    public double area() {
        return super.height*super.height;
    }

    @Override
    public double circumference() {
        return this.height*4.0;
    }
}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        GoodSquare testSquare = new GoodSquare(4.0);
        System.out.println(testSquare.area());
    }

}
