**MYSQL CRUD PROJECT**

In this project, I will be demonstrating how to use Spring annotations and dependencies to create a jar that can interact with, and manipulated, a MySql database. For this to function accurately, you will need to set up a bankerdb schema in your localhost mySql

In this project, there are two models being implemented: Currency and Customer.
1) Many Customers can use a Currency
2) One Currency may have many Customers

Currency tuples contain: 
1) Id: long 
2) Currency_Name: Unique String
3) Country_Name: String
4) Currency_Symbol: Unicode Symbol
5) Currency_Image: Blob

Customer tuples contain:
1) Id: Long
2) First_Name: FullName.firstName
3) Last_Name: FullName.lastName
4) Middle_Name: FullName.middleName
5) Credit_Line: long
6) Email: String
7) Currency: ForeignKey with Currency

