FROM jboss/wildfly:latest
ADD target/mavha-challenge.war /opt/jboss/wildfly/standalone/deployments/
