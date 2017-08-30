# Sample Project using BAND OpenAPI

## Requirements
- [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Apache Maven 3.x](http://maven.apache.org)

## Preparations
1. Add 'http://localhost:8080/' value to 'Redirect URI' in [My Apps](http://developers.band.us/develop/myapps/list) page.
2. Edit src/main/resources/band-oauth.properties file
- fill band-oauth.clientId with value of 'Client ID' from [develoers.band.us](http://develoers.band.us/develop/myapps/list)
- fill band-oauth.clientSecret with value of 'Client Secret' from [develoers.band.us](http://develoers.band.us/develop/myapps/list)

## Quick Start
1. <pre><code>mvn clean package </code></pre>
2. <pre><code>java -jar target/myservice-0.0.1-SNAPSHOT.jar</code></pre>
3. open 'http://localhost:8080/' in your browser
