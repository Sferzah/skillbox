FROM openjdk:17
RUN mkdir /app
COPY target/users-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
WORKDIR /app
CMD java -jar users-0.0.1-SNAPSHOT.jar