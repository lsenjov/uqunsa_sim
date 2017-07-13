FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/uqunsa_sim.jar /uqunsa_sim/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/uqunsa_sim/app.jar"]
