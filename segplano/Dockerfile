FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot 

COPY /target/spring-boot*.jar spring_boot_com_mysql.jar

ADD target/segplano.jar segplano.jar
EXPOSE 8086

ENTRYPOINT ["java", "-jar", "segplano.jar"]