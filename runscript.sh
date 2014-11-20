#!/bin/sh

#################### This is a script file to clean , build and deploy the olx project ############
mvn clean install -DskipTests=true
rm -rf /d/saas/SaaSFoundation/public/apache-tomcat-7.0.37/webapps/olx*
cp target/olx.war /d/saas/SaaSFoundation/public/apache-tomcat-7.0.37/webapps/
