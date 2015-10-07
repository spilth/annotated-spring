[![Stories in Ready](https://badge.waffle.io/AnnotatedSpring/annotated-spring.png?label=ready&title=Ready)](https://waffle.io/AnnotatedSpring/annotated-spring)
[![Circle CI](https://circleci.com/gh/AnnotatedSpring/annotated-spring.svg?style=svg)](https://circleci.com/gh/AnnotatedSpring/annotated-spring)

# Annotated Spring

[![Join the chat at https://gitter.im/AnnotatedSpring/annotated-spring](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/AnnotatedSpring/annotated-spring?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Web site for Spring Screencasts

## Requirements

- [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.X](http://maven.apache.org)

On a Mac you can install Maven with [Homebrew](http://brew.sh):

    $ brew install maven
    
## Tests

To run the test suite, run Maven with the `test` profile:

    $ mvn -P test

Or you can simply just run `mvn`.

## Development Server

To run a local development server, run Maven with the `development` profile.

    $ mvn -P development

Then go to <http://localhost:8080> to view the site.

### Auto Reload SCSS Changes

If you want to be able to make SCSS changes and see them without restarting the development server every time, open a second terminal window and use the following Maven goal:
 
    $ mvn sass:watch

## Troubleshooting

### Maven & JAVA_HOME

If Maven complains about `JAVA_HOME` not being set, you can set it with the following:

    $ export JAVA_HOME=$(/usr/libexec/java_home)
    
You'll likely want to add that to your `.bash_profile` or similar shell initialization script.

### sass:watch Errors

If using `sass:watch` generates an error with `no such file to load -- hitimes/hitimes`, try clearing out your gems.

If you're using `rvm` you can do the following:

    $ rvm gemset empty default --force
    