# Stage 1: create the war file to be deployed into wildfly
FROM maven:3.5.2-jdk-8-alpine AS MVN_PACKAGE_STAGE
WORKDIR /tmp/
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: plug war above into wildfly server
FROM jboss/wildfly:latest
ADD target/mavha-challenge.war /opt/jboss/wildfly/standalone/deployments/
COPY --from=MVN_PACKAGE_STAGE /tmp/target/mavha-challenge.war /opt/jboss/wildfly/standalone/deployments/