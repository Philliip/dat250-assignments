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
In this exercise i got in touch with queues, sending tasks to queue and sending tasks to workers from queue. To send a task to queue i used code in file [NewTask.java](./assignment_6/src/main/java/hvl/dat_250/NewTask.java) and to define workers i used code in file [Worker.java](./assignment_6/src/main/java/hvl/dat_250/Worker.java). To test out this setup i used four terminal tabs. In three of them i "spawned" workers with command
```
java -cp .:amqp-client-5.21.0.jar:slf4j-api-1.7.36.jar:slf4j-simple-1.7.36.jar hvl.dat_250.Worker

```
From the remaining terminal tab i sent tasks to the queue with command which i repreated 6 times.
```
java -cp .:amqp-client-5.21.0.jar:slf4j-api-1.7.36.jar:slf4j-simple-1.7.36.jar hvl.dat_250.NewTask TaskNew
```
The result was that each worker terminal had two ouputs: `[x] Received 'TaskNew'`


##  Exercise 4 - Topics
In last exercise i got experience with full messaging model of rabitMQ. This exercise introducted another concpet of exchange. Exchange accepts taks from producer and then based on specific rules it pushes it to particular queues. To simulate this behaviour i used code in file [EmitLog.java](./assignment_6/src/main/java/hvl/dat_250/EmitLog.java). Mentioned file behaves similar as `NewTask.java`, send some task. File that produce exchange element is [ReceiveLogs.java](./assignment_6/src/main/java/hvl/dat_250/ReceiveLogs.java). During the executing of program, i specified output to be stored into file `logs_from_rabbit.log`.
I did not push it into GitHub because pushing `.log` files is not a good practice. 
Both program were ran analogically to previous programs. 

## Conclusion
During my work on this assignment i did not experience any issues. I managed to go through all exercises and there no pending issues on my side. Overall assignmment was exciting.


