FROM gradle:8.4.0-jdk21 AS builder
WORKDIR /home/app
COPY --chown=gradle:gradle . .
RUN gradle bootJar

FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=builder /home/app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
