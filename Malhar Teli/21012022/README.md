**ASSIGNMENT 1**

Solid Principles - Please see the "SOLID Principles" Directory

Annotations + Surefire Reporting - Please see the "Annotations + Surefire Report" directory

MultiModule Project - Please see the "MultiModule Project + Pom" directory

SuperPOM - The super POM file defines the default configurations, repositories, and plugins that your local machine will use. 
1. Snapshots are disabled for the super POM, as it would end constantly downloading the lastest versions.
2. Building in the super POM will simply serve as the base template for building in any local POM. 
3. For Reporting, the super POM only provides the default output directory
4. It will also have the base profile

Effective POM- the Effective POM is the compile POM of your project. It will include the defaults in your SuperPOM and the configuration you wrote for your application. 

Optional POM- A Tag used to indicate that the depedency is not strictly required during building- this means that, unless it is explicitly called for in the code, the dependency will not be pulled up while building the maven project.