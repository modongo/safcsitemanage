# Site Management Application

 An app for site Maintenance Manager. The site Maintenance Manager will be able to add a list of the maintenance engineers, and for each engineer, add the sites that the engineer maintains. The engineers work independently, so each site only belongs to a single engineer.
## LiveLink: https://safcsitemanager.herokuapp.com/

## Behavior of the programm

 | Behavior                                       |  Input | Output    |
 | ---------------------------------------------- | ------ | --------- |
 |Adding new models.Engineer|  Click on the add models.Engineer tab   |  New record will be adde to the list of Engieers|
 |Adding a new models.Site| click On add new site tab  |  New form will be dispalayed to add more sites |
 |Displaying the list of Engineers| click on home page |  all the Engineers and thier details will be displayed|
 
## Setup/Installation Requirements

* create a new folder on your desired location in your local machine
* git init using your terminal
* git clone https://github.com/modongo/safcSiteManager.git
* make sure you have intellij installed in you laptop.
* launch intellij and go to files>open project.
* enjoy the code.
## Database installation instructions
Make sure you have postgres Db installed locally in your machine and follow below commands.

###### Creating a role and credentials

postgres=# create user mike with password 'password';


###### Creating database
postgres=# create database site_maintenance;


###### connecting into the created database
postgres=# \c site_maintenance;

###### Creating Engineers table.

site_maintenance=# create table engineers (id int PRIMARY KEY, name varchar, ek_Number varchar, site_id varchar, created_at date);

###### Creating sites table

site_maintenance=# create table sites (id int PRIMARY KEY, name varchar, engineer_id varchar, site_Number varchar, created_at date);

## Known Bugs

there are currently no known bugs experienced on the website but feedback on bugs encountered during viewing of the page will be highly appreciated and will go a long way into making the website better for the users. The only reason that the website may fail to load is if the Internet connection is slow or disconnected which will require you to troubleshoot your Internet connection

## Technologies Used
* java
* JUnit
* Spark
* postgressql

**Main Languages & Framework used:**

* java for web application and sparkjava as a framework


**Other Technologies:**

* Bootstrap, HTML, CSS, JQuery, Javascripts

## live link:

$< https://safcsitemanager.herokuapp.com/>

# clone into repository

* git clone https://github.com/modongo/safcSiteManager.git
* Open using your favorite editor and view the code or just open the index.html on the browser

## Feedback

Incase of any issues or feedback please add using any of below links.

* [Issues](https://github.com/modongo/safcSiteManager/issues). To submit any issues.

* [email](mikodongo@gmail.com) for any other feedback.

## Support and contact details

 Contact me on my github account <https://github.com/modongo>


## License

This project is licensed under the MIT License

**_Michael Odongo_** Copyright (c) 2019