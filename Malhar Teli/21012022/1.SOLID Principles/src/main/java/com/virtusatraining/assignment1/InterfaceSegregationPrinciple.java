package com.virtusatraining.assignment1;

//In this file, I will be demonstrating the usage of the Interface Segregation Principle

import lombok.NoArgsConstructor;

//In this NonSegShape interface, you will find that there are additional functions that make it difficult to provide code for each function
///By including a volume function in the shape interface, we've created a situation that requires Two-Dimensional Shape objects that implement the  NonSegShape Interface to code in a volume function
interface NonSegShape{
    double getCircumference(double length);
    double getArea(double length);
    double getVolume(double length);
}

@NoArgsConstructor
class Square implements NonSegShape{
    @Override
    public double getCircumference(double length){
        return length*4.0;
    }
    @Override
    public double getArea(double length){
        return length*length;
    }
    @Override
    //Because the Square is a 2D object, it doesn't have a volume, thus making this an extraneous definition
    public double getVolume(double length) {
        return 0;
    }
}

//In this following example, we will segregate the functions we put into NonSegShape's interface, and therefore only implement the interfaces needed by our class SegShape
interface SegShapeCircumference{
    double getCircumference(double length);
}

interface SegShapeArea{
    double getArea(double length);
}

interface SegShapeVolume{
    double getVolume(double length);
}

//This class, SegCube, can implement all three interfaces and therefore provide solutions to each of their functions
@NoArgsConstructor
class SegCube implements SegShapeCircumference, SegShapeArea, SegShapeVolume{
    @Override
    public double getCircumference(double length) {
        return length*6.0;
    }

    @Override
    public double getArea(double length) {
        return length*length*6.0;
    }

    @Override
    public double getVolume(double length) {
        return length*length*length;
    }
}

//This class, SegSquare, does not have a volume, and therefore can supply a meaningful resolution to SegShapeVolume's methods. Therefore, we won't implement SegShapeVolume into SegSquare.
class SegSquare implements SegShapeCircumference, SegShapeArea{

    @Override
    public double getCircumference(double length) {
        return length*4;
    }

    @Override
    public double getArea(double length) {
        return length*length;
    }
}

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        SegCube segCubeExample = new SegCube();
        SegSquare segSquareExample = new SegSquare();
        System.out.println("SegCube's volume of 4.0 is " + (segCubeExample.getVolume(4.0)));
        System.out.println("SegSquare's area of 4.0 is " + (segSquareExample.getArea(4.0)));
    }
}
