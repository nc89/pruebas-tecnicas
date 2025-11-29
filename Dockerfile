FROM amazoncorretto:17-alpine-jdk

RUN apk --no-cache update && apk --no-cache upgrade && \
    apk --no-cache add --no-progress tzdata && \
    cp /usr/share/zoneinfo/America/Bogota /etc/localtime && \
    echo "America/Bogota" > /etc/timezone && \
    rm -rf /var/cache/apk/* /tmp/* /var/tmp/*

ENV TZ=America/Bogota

RUN mkdir -p /files/logo
RUN mkdir -p /files/template

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

COPY ./app-artifact/target/backend-app-0.0.1-SNAPSHOT.jar app.jar
COPY ./app-artifact/target/classes/git.properties git.properties
COPY ./app-artifact/src/main/resources/application-qa.yml application-qa.yml
COPY ./app-artifact/src/main/resources/application.yml application.yml
COPY ./app-artifact/src/main/resources/messages.properties messages.properties
COPY ./app-artifact/src/main/resources/general_messages.properties general_messages.properties

RUN chown -R appuser:appgroup /app && chmod 500 /app/app.jar

USER appuser

EXPOSE 8090/tcp

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/urandom", "-jar", "/app/app.jar"]