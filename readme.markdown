SPA 
===

GIT Assume unchanged
--------------------

git update-index --assume-unchanged path/to/file.ext

for properties files that shouldnt be commited so that they dont turn up as changed

Building
--------

Build using maven command line tool (or build from within Eclipse IDE using maven plugin)

* mvn package - Packages the application and compiles into binary (war)
* mvn integration-test - Run integration tests (mostly db interface tests)
* mvn test - Run unit tests


Running tests
-------------

Acceptance testing is enabled with Selenium. Selenium uses PhantomJS as WebDriver.
To be able to run the mvn integration-test you need to [install the PhantomJS driver](http://phantomjs.org/download.html) and
set the PHANTOM system path to /path/to/phantomjs/driver.

Build profiles
--------------

Default profile is "dev", invoke other profile by adding flag to maven build command

e.g. mvn -Pdevwin package

Add a build profile in the pom if needed, also add a resource folder (conveniently copy folder from similar profile)
Each profile folder contains JDBC, logging, secure file area and other specific configurations for each build profile
