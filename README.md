# CS4125_Project1_TeamBased
 Systems Analysis & Design
 
 ## Running the application
 Whole system is hosted on Amazon Web Services(AWS) as such the Android app will work without needing to run any other software when installed on an android device(or running on an emulator), if required changes can be made to run Spring Boot and Database on a different machine, this is described in other sections.

 ## Code Folder - Android Studio GUI
 Using Android Studio to code GUI in java for Android devices.
 We have built an unsigned APK(for debugging) which can be found in 'CS4125_Project1_TeamBased\Code\app\build\outputs\apk\debug', this APK can be used to install the app on an android device.
 - Sample login:- username= androidtest, password= test123
 - Sample search:- Start station= ED1, Date= 2020-12-01, Time= 9:00AM
 - Sample booking:- routeid= 3, quantity= 1, optionalDiscountCode= DFRR (any other routes currently in the database will not allow booking because their date & time has already passed)
 
 ## Spring - Spring Boot
 Using Java with Spring Boot for creating webservice for business logic, built using maven and hosted on Amazon EBS to which the Android app connects by default.  
 If needed Spring program can be run on local by running the built jar file found in 'CS4125_Project1_TeamBased\Spring\bookingapp\target' (using 'java -jar' command on 'bookingapp-0.0.1-SNAPSHOT.jar').  
 After starting up the spring boot application on local machine it can be tested using curl commands e.g.  
 - To register a user: ' curl localhost:5000/registeruser -d name=name -d password=password -d email=email '  
 - To login: ' curl "localhost:5000/loginuser?name=name&password=password" '      
 
 Alternatively it can also be tested using the Android app but if hosting the Spring program on a local machine it requires the host machine and phone to be on the same network and changing the link in the 'RetrofitClientInstance' class found in the Android code, to point to the host machine.

 ## cs4125_SQL_schema.sql - Database Schema File
 MySQL schema file with required tables, this schema has been created on Amazon RDS which the Spring Boot application connects to by default.
 If required this schema can be used to host the database on a different machine, but will require to change the 'application.properties' file in the Spring boot to point to the machine hosting the database.

### Authors
 - Eoghan Russell 17202124
 - Pawel Ostach 17214211
 - Damian Skrzypek - 17217679
 - Darragh Kelly - 17235545

