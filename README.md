# ![alt tag](https://github.com/SumeetKumarBarua/FactsBox-Heroku-Edition/blob/master/WebContent/img/logo.png) FactsBox-Heroku-Edition
Everyone wants to have a piece of Science in their daily lives. This app gives some interesting facts in various areas of Science in a random manner. Most importantly it's a Full Stack developed project using various technologies like Core Java, PostgresSQL, JDBC, AngularJS, HTML, RESTful Webservice and Maven. It also guides you through different steps of deploying an app on Heroku.

# In Action
![alt tag](https://github.com/SumeetKumarBarua/FactsBox-Heroku-Edition/blob/master/WebContent/img/first.gif)

![alt tag](https://github.com/SumeetKumarBarua/FactsBox-Heroku-Edition/blob/master/WebContent/img/iphone.gif)

# Motivation
We always find small snippets of code all over the net doing some functionalities. So how about getting everything all together(from Back-End to front-End) truly coupled up for our purpose. Sounds cool..Right. So follow the steps below and enjoy.

# Getting Started
This project is solely dedicated for web hosting on Heroku. To make it live please follow the configuration steps for Heroku <a href="https://devcenter.heroku.com/articles/getting-started-with-java#set-up">here</a>

# Prerequisites
    1.OS: Windows
    2.JDK 1.7 or above
    3.An IDE for development (eg. Eclipse)
    4.Git and Maven installed on your system
    5.Heroku CLI to deploy on Heroku

# Installing
To run only on local server please visit <a href="https://github.com/SumeetKumarBarua/FactsBox">FactsBox</a>. 

Still if you want to make this project to work on your local system then make some minor changes:

   1.Copy the project on to your local system and run the table script on your own database.
   
   2.Import the repo to Eclipse as Maven Project.
    
   3.Configure the connection file(JDBCConnection.java) with the driver settings of database whichever
      you are using here.
    ![alt tag](https://github.com/SumeetKumarBarua/FactsBox-Heroku-Edition/blob/master/WebContent/img/connection.PNG)
      
   4.Change the URL setting(Properties.js) as per the URL configuration of the server you are using.
    
        var getURI = function(){
	    var URL='https://factsbox.herokuapp.com/api/';
	    return URL;
         }
	 
    	Eg. If you use Tomcat then it would look something like this:
	      [http]://localhost:[port number]/Your_App_Name/index.html
    
   5.Run on server.    
As Heroku supports postgreSQL database for the application, this application has been fully configured on its terms. kindly change it as per your requirements.

# Deploy
Please visit <a href="https://devcenter.heroku.com/articles/getting-started-with-java#deploy-the-app">here </a> to follow the steps to deploy on Heroku

# Live Demo
Please Visit <a href="https://factsbox.herokuapp.com">here </a>

# Working with API
This project exposes its data in the form of API. To know about various API methods in detail please <a href="https://github.com/SumeetKumarBarua/Working-with-API">Check here</a>.

# Something isn't working properly
Send me an email sumeet.barua007@gmail.com (might take a few days)

# Links
  <a href="https://devcenter.heroku.com/articles/getting-started-with-java#set-up">Heroku Java Support</a><br>
  <a href="https://github.com/kissaten/webapp-runner-minimal">An Example on Webapp-runner</a>

# Thanks
    1.Github: For everything.
    2.Heroku: For providing a platform to make it go Live.
    3.Quora: For collecting some really interesting facts. 
    4.Google, alpha coders and many more for the images.
    5.Thanks to anyone who's code was used
    
# Improvements
    1.Improving the UI
    2.Making it compatible for Hibernate
    3.Adding more Facts to the database to avoid repetation


# The MIT License (MIT)

Copyright (c) 2017 Sumeet Kumar Barua

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
