# webdriver-java-samples

This repo contains examples of how to use the webdriver java bindings to create page objects and tests. The application under test is a forked copy of [tourdedave's "the-internet"](https://github.com/tourdedave/the-internet) project which contains numerous examples of hard to automate pages. 

# Dependencies
* Ruby -- Needed to run the "the-internet" project locally.
* Java
* Maven
* A Java IDE like Intellij or Eclipse. I prefer the former.
* Chrome

# Web server setup instructions
To start the "the-internet" web server, clone the latest version of this repo from https://github.com/jdavis61/the-internet.git. Then start the server using the rackup command. If you receive the message "Your Ruby version is 2.3.3, but your Gemfile specified x.x.x", add the version of Ruby installed on your machine to the Gemfile. Once the webserver is started, the home page may be found at http://localhost:9292.

```
git clone https://github.com/jdavis61/the-internet.git
rackup
```

# Test execution
To execute the tests locally using chrome, follow the below instructions.

clone the latest code from master
```git clone https://github.com/jdavis61/webdriver-java-samples.git``` 

If you have already downloaded the source code run ```git pull``` to get the latest updates.

Run tests
```mvn test```

Executing this command will load chrome locally on your system and run all tests in the test/java/com/maineqa folder.

