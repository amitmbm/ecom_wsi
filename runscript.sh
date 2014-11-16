#!/bin/sh

mvn clean install
rm -rf /d/saas/SaaSFoundation/public/apache-tomcat-7.0.37/webapps/springcrud*
cp target/springcrud.war  /d/saas/SaaSFoundation/public/apache-tomcat-7.0.37/webapps/
