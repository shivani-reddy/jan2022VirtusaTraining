**MultiModule Project**

This is a demonstrations of a multimodule Maven project.

The primary difference between a regular module and a multimodule project is that its context spreads across multiple packages/directories

You can include modules in your Spring Context by adding them in the pom.xml located at the root of your project. In this case, there are two modules included in the root's pom.xml

There are two modules being used here, both of which are designed only to demonstrated the basic usage of MultiModule functionality. 

1. Library Module
   1. These are classes that we will reference in the application module.
2. Application Module
   1. This module contains the application that will use the library module in order to produce a specific result. 


