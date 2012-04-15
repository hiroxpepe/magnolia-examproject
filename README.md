# magnolia-examproject (c) by examproject

***
### What's this?
An example of [Magnolia CMS](http://www.magnolia-cms.com/magnolia-cms.html) and it's module [Magnolia Blossom](http://documentation.magnolia-cms.com/modules/blossom.html).

***
### How to run at the local?
You will need to get [Apache Maven](http://maven.apache.org/).

To run the application at your command line.

    > cd { path to this README.md directory. }
    > mvn compile
    > mvn install
    > java -jar target/dependency/jetty-runner.jar exmp-magnolia-webapp/target/*.war

You can access to http://localhost:8080/ on your web browser.  
To stop the application hit ctrl + c

***
### How to run on the Heroku?

You will need to get [Git](http://git-scm.com/), of course.  
You will need to create a application for [Heroku](http://www.heroku.com/), and must need to get the heroku tools, used [RubyGems](http://rubygems.org/).  

To push the application for Heroku at your command line.

    > cd { path to this README.md directory. }
    > heroku login
    > git push git@heroku.com:your-app-name.git

***
### Hosted on GitHub.
[hiroxpepe/magnolia-examproject](https://github.com/hiroxpepe/magnolia-examproject)

***
### Running on Heroku.
http://exmpmagnolia.herokuapp.com/home

***
### Author
[hiroxpepe](mailto:hiroxpepe@gmail.com)

***
### License
The examproject is released under version 2.0 of the
[Apache License](http://www.apache.org/licenses/LICENSE-2.0).
