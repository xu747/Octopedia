FROM openjdk:12-alpine

#RUN rm -rf /opt/running/octopedia*
RUN rm -rf ./Docker/running/octopedia*
ADD ./target/octopedia-1.0.0.jar ./Docker/running/octopedia.jar

EXPOSE 8080
WORKDIR ./Docker/running/

CMD ["java", "-jar", "octopedia.jar","--spring.profiles.active=prod"]
