# webdriver-java-samples

This repo contains examples of how to use the webdriver java bindings to create page objects and tests. The application under test is tourdedave's "[the-internet](https://github.com/tourdedave/the-internet)" project which contains examples of hard to automate pages. 

# Dependencies
* Java
* Maven
* A Java IDE like Intellij or Eclipse. I prefer the former.
* Chrome

# Test execution
To execute the tests locally using chrome, follow the below instructions.

clone the latest code from master
```
git clone https://github.com/jdavis61/webdriver-java-samples.git
``` 

If you have already downloaded the source code run ```git pull``` to get the latest updates.

Run tests
```
mvn test
```

Executing this command will load chrome locally on your system and run all tests in the test/java/com/maineqa folder.

