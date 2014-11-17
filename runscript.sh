#!/bin/sh

mvn clean install
rm -rf /d/saas/SaaSFoundation/public/apache-tomcat-7.0.37/webapps/olx*
cp target/olx.war  /d/saas/SaaSFoundation/public/apache-tomcat-7.0.37/webapps/
