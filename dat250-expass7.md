# DAT250 ASSIGNMENT 7 REPORT
In this assignmnet i got hands on Docker and containerization. 

## Using a Dockerized application: PostgreSQL
### First exercise
```
docker run -p 5432:5423 \
 -e POSTGRES_PASSWORD=secretpassword \
 -d --name my-postgres --rm postgres
```
- `-p` switch in a Docker `run` command is used to publish a container's port to the host system, making it accessible from outside the container. The `-p` flag maps a port on the host machine to a port in the Docker container.
Value `5432:5432` means mapping port `5432` on the host to port 5432 in the container. 
PostgreSQL typically listens on port 5432 by default, so this mapping makes PostgreSQL accessible from your host machine (or network) on the same port

- `e` switch in Docker `run` command to set environment variables in the running container. Environment variables can be used to configure various settings of the application running inside the container. I set only `POSTGRES_PASSWORD`
value and by defualt postgres creates a user `postgres`.

- to connect i used database manager `Postico 2`.
<img width="436" alt="image" src="https://github.com/user-attachments/assets/48fc4bd2-ed68-49e9-95b2-285478575ff3">



