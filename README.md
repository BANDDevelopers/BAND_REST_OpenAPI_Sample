# Sample Project using BAND OpenAPI
See also [Developers Guide](http://developers.band.us/develop/guide/api/get_authorization_code_from_user)

## Features
- Login with BAND ([Get User Access Token](http://developers.band.us/develop/guide/api/get_authorization_code_from_user)) ([OAuth 2.0](https://tools.ietf.org/html/rfc6749#section-4.1)) 
- Get my BAND profile ([Get User Profile](http://developers.band.us/develop/guide/api/get_user_information))

## Requirements
- [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Apache Maven 3.x](http://maven.apache.org)

## Preparations
1. Add 'http://localhost:8080/' value to '**Redirect URI**' in [My Apps](http://developers.band.us/develop/myapps/list) page.
2. Edit src/main/resources/**band-oauth.properties** file
 - Replace **band-oauth.clientId** value with your 'Client ID' from [develoers.band.us](http://develoers.band.us/develop/myapps/list)
 - Replace **band-oauth.clientSecret** value with your 'Client Secret' from [develoers.band.us](http://develoers.band.us/develop/myapps/list)

## Quick Start
1. <code>mvn clean package </code>
2. <code>java -jar target/myservice-0.0.1-SNAPSHOT.jar</code>
3. open 'http://localhost:8080/' in your browser
