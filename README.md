# MyCrudApp 
The app is showing the list of computer parts required (or not required) to assemble a computer.  
Parts are stored in database. One can create, update and delete the parts via the web browser interface. Also one can search for the parts by name, filter by necessity for computer and see the number of computers ready to be assembled.

Used technologies:  
	• Maven (to build the project);  
	• Tomcat 9 (for deployment and testing);  
	• Spring Framework;  
	• Hibernate;  
	• Oracle MySQL;  
	• Spring MVC (for frontend).
 
The script "dbscript.sql" located in the root folder is required to fill the database with data.  
After that the project is ready to be deployed on Tomcat and available via  
http://localhost:8080/

Main view
![Screenshot](https://github.com/Deformin/MyCrudApp/raw/master/readme_image/Capture.PNG)