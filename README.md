[![Circle CI](https://circleci.com/gh/AnnotatedSpring/annotated-spring.svg?style=svg)](https://circleci.com/gh/AnnotatedSpring/annotated-spring)

# Annotated Spring

Web site for Spring Screencasts

## Requirements

- [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.X](http://maven.apache.org)

On a Mac you can install Maven with [Homebrew](http://brew.sh):

    $ brew install maven
    
### Maven & JAVA_HOME

If Maven complains about `JAVA_HOME` not being set, you can set it with the following:

    $ export JAVA_HOME=$(/usr/libexec/java_home)

## Tests

To run the test suite, run Maven with the `test` profile:

    $ mvn -P test

Or you can simply just run `mvn`.

## Development Server

To run a local development server, run Maven with the `development` profile.

    $ mvn -P development
    
Then go to <http://localhost:8080> to view the site.
