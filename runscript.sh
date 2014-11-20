#!/bin/sh

mvn clean install -DskipTests=true
rm -rf C:/tomcat7/apache-tomcat-7.0.54/webapps/olx*
cp target/olx.war C:/tomcat7/apache-tomcat-7.0.54/webapps/
