
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM alpine:latest

CMD ["/bin/sh"]

docker pull amazoncorretto
FROM amazoncorretto:17-alpine-jdk
maintainer PedroBelvedere
COPY target/portfoliopedro.jar portfoliopedro.jar
ENTRYPOINT ["java","-jar","/portfoliopedro.jar"]