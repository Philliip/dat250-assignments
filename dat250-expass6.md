# DAT250 ASSIGNMENT 6 REPORT
This assignment introduced to me a message passsing system and publish/subscribe paradigm with use of rabitMQ. 
## Exercise 1 - Installation 
I succesfully set up rabbitMQ with use of Docker. I used command:
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management
```
## Exercise 2 - Hello World
In this exercise i tried a send/receive procudure, working with message broker to accepts the message. To send a message i used code in file [Send.Java](./assignment_6/src/main/java/hvl/dat_250/Send.java)
and to receive message i used code in file [Recv.java](./assignment_6/src/main/java/hvl/dat_250/Recv.java). After compiling i used two terminal tabs. In one terminal tab i ran the program `Send.java` with command
```Bash
java -cp .:amqp-client-5.21.0.jar:slf4j-api-1.7.36.jar:slf4j-simple-1.7.36.jar hvl.dat_250.Send

```
and another terminal tab i used command bellow to ran program `Recv.java`
```
java -cp .:amqp-client-5.21.0.jar:slf4j-api-1.7.36.jar:slf4j-simple-1.7.36.jar hvl.dat_250.Recv

```
The result of this procedure was receiving message in `Recv` terminal and the message was `[x] Received 'Hello World!'`.

## Exercise 3 - Work Queue

##  Exercise 4 - Topics

Code for additional experiments is in directory [assignment_6](./assignment_6).

