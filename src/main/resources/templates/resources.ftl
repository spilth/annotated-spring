<#assign title><@spring.message "page.resources.title" /></#assign>
<@application title=title active="resources">
<div class="full-page">
    <h1>${title}</h1>

    <p>This is a collection of links for tools and sites related to Java and Spring development.</p>

    <h2>Java</h2>

    <ul>
        <li><a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">Java 8 SDK</a></li>
        <li><a href="http://maven.apache.org">Maven</a> - Java build tool</li>
        <li><a href="http://search.maven.org">Maven Central Repository</a> - centrally hosted Java libraries</li>
        <li><a href="https://gradle.org">Gradle</a> - Java build tool</li>
        <li><a href="http://www.webjars.org">WebJars</a> - Client-side libraries packaged as JAR files</li>
        <li><a href="https://www.jetbrains.com/idea/">IntelliJ IDEA</a> - Java IDE with Spring support</li>
    </ul>

    <h2>Spring</h2>

    <ul>
        <li><a href="http://spring.io">Spring</a></li>
        <li><a href="http://projects.spring.io/spring-boot/">Spring Boot</a></li>
        <li><a href="https://start.spring.io">Spring Initializr</a> - Start Spring Boot projects from your browser</li>
        <li><a href="http://spring.io/docs/reference">Spring Reference Documentation</a></li>
        <li><a href="http://stackoverflow.com/questions/tagged/spring">Spring Questions on Stack Overflow</a></li>
    </ul>

    <h2>Version Control</h2>

    <ul>
        <li><a href="https://git-scm.com">Git</a> - Modern distributed version control</li>
        <li><a href="https://github.com">GitHub</a> - Git repository hosting</li>
        <li><a href="https://try.github.io/">Code School - Try Git</a> - Code School's free Git introductory course</li>
    </ul>

    <h2>Tools, Continuous Integration and Hosting</h2>

    <ul>
        <li><a href="http://brew.sh">Homebrew</a> - Package manager for OS X</li>
        <li><a href="https://circleci.com">CircleCI</a> - Hosted Continuous Integration</li>
        <li><a href="https://jenkins-ci.org">Jenkins</a> - Continuous Integration Server</li>
        <li><a href="https://run.pivotal.io">Pivotal Web Services</a> - Cloud Platform from Pivotal</li>
    </ul>
</div>
</@application>