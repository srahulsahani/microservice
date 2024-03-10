#  microservice
Start Service Registry First 

When ever services are running in docker-desktop
        hit the api-gateway with BASE_URL = http://host.docker.internal:9191

When ever services are not running in docker-desktop
        hit the api-gateway with BASE_URL = http://localhost:9191/<service-name>

# Install zipkin in docker deskop
        docker pull openzipkin/zipkin
# Run zipkin
        docker run --rm -it --name zipkin -p 9411:9411 openzipkin/zipkin

#Alternatively you can run zipkin jar file present in repository using command - java -jar .\jars\zipkin-server-3.1.1-exec.jar
