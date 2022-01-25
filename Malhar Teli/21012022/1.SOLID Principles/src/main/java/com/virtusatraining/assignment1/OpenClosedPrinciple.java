package com.virtusatraining.assignment1;

// In this class, I will demonstrate the Open-Closed Principle

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//This class fails to keep the open-closed Principle, as each time it is extended by a subclass, it will need to be
// modified to account for its presence
@AllArgsConstructor
@NoArgsConstructor
@Data
class OpenOpenPrinciple {
    Double baseValue = 2.0;
    public double add2(OpenOpenPrinciple source){
        if (source instanceof openAdd2Double){
            return source.getBaseValue() + 2.0;
        }
        if(source instanceof openAdd2Integer){
            return source.getBaseValue() +2.0;
        }
        return 0;
    }
}


@Data
class openAdd2Integer extends OpenOpenPrinciple{
    Double baseValue = 2.0;
}

@Data
class openAdd2Double extends OpenOpenPrinciple{
    Double baseValue = 2.0;
}

//In the Open Closed Principle, superclass simply establishes that there will be a function that adds 2 to the class's baseValue
// In the subclasses, we override the functions we intend to use with our new objects.
///This means that we do not need to readjust the superclass to the needs of the subclass, while taking advantage of its
///open structure to override its base functionality.

@NoArgsConstructor
@Data
public class OpenClosedPrinciple {
    Double baseValue = 2.0;
    public double add2(OpenClosedPrinciple source){return this.baseValue + 2.0;}
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class closedIntAdd2 extends OpenClosedPrinciple{
    Double baseValue = 2.0;
    public Integer add2(){
        return this.getBaseValue().intValue() + 2;
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class closedDoubleAdd2 extends OpenClosedPrinciple{
    Double baseValue = 2.0;
    public Double add2(){
        return this.getBaseValue()+2.0;
    }
}
