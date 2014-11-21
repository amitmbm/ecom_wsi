#!/bin/sh

#################### This is a script file to clean , build and deploy the olx project ############


## Path variable hols the local directory where your tomcat is installed
path=C:/tomcat_7/webapps
rm -rf target/
mvn clean install -DskipTests=true
rm -rf $path/TestWS*
cp target/TestWS.war $path/
