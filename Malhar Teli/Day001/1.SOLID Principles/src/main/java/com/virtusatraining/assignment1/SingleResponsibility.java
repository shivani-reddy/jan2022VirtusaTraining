package com.virtusatraining.assignment1;

// In this file, I will demonstrate a set of classes that represent a single responsibility format

import lombok.Data;
import lombok.NoArgsConstructor;

// This class fails to make use of the single responsibility rule, becoming responsible for three multiple use cases
class MultiResponsibility{
    public void printDetails(String details){
        System.out.println(details);
    }
    public Integer add2(Integer x){
        return (x+2);
    }
    public Double add2(Double x){
        return (x+2.0);
    }
}

// These classes succeed in the single responsbility rule, seperating the functions defined in class MultiResponsibility
// into single responsible classes

@NoArgsConstructor
class DetailPrinter{
    public void printDetails(String details){
        System.out.println(details);
    }
}

@NoArgsConstructor
class Add2Int{
    public Integer add2(Integer x){
        return (x+2);
    }
}

@NoArgsConstructor
class Add2Double{
    public Double add2(Double x){
        return (x+2.0);
    }
}

@NoArgsConstructor
@Data
public class SingleResponsibility {
    private DetailPrinter detailPrinter= new DetailPrinter();
    private Add2Int add2Int = new Add2Int();
    private Add2Double add2Double = new Add2Double();
}
