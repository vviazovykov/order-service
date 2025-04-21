FROM openjdk:21

COPY build/libs/order-service.jar order-service.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar order-service.jar"]
