**Assignment 1: SOLID PRINCIPLES**

In this project, I will be demonstrating the 5 SOLID Principles with practical examples.

The Principles are written out as follows:

1) Single Responsibility Principle: 
    Each class should be responsible for a single part or function of the system.
   1) This means that each class should be responsible for a single job (like printing information, calculating taxes, or accessing servers. Each of these functions require a dedicated class.)
   2) Makes it a lot easier to diagnose errors
2) Open-Closed Principle: Components of the project should be open to extensibility, but closed for modification
3) Liskov Substitution Principle: Objects of a superclass should be replaceable with objects of a subclass without causing breaks.
   1) This essentially means that all classes that extend the superclass should effectively account for all intended use cases of the superclass
4) Interface Segregation Principle: No client should be forced to depend on methods that are not used within the client
   1) This means that properly principled coding should not create classes that depend on methods defined externally to successfully produce objects of said classes
5) Dependency Inversion Principle: Modules built for a high level functionality (ie Super Models) should not depend on lower-level modules in order to function, but both should depend on Abstractions
   1) This supports a better seperation of concerns, and allows classes with the same superclass to be used interchangeably