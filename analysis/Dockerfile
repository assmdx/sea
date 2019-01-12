FROM java:8
VOLUME /tmp
ADD ./target/analysis.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8889
ENTRYPOINT ["java","-jar","/app.jar"]