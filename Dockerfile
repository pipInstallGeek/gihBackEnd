FROM openjdk:18-alpine
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY ./output .
COPY ./Python .
ENV MYSQL_ROOT_PASSWORD=root
CMD ["java", "-jar", "gihBackEnd-1.0-SNAPSHOT-jar-with-dependencies.jar"]