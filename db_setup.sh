#!/bin/bash

echo "Create docker for Experiment Database"
docker container run --restart=always --name=experimentdb -p 3306:3306 -e MYSQL_ROOT_PASSWORD="a1DcN9q+" -e MYSQL_USER="dbuser" -e MYSQL_PASSWORD="a1DcN9q+" -e MYSQL_DATABASE="experimentdb" -d mysql:latest --sql-mode=NO_ENGINE_SUBSTITUTION
if [ $? -eq 0 ]; then
    count=0
    while [ $count -lt 20 ]; do
        sleep 1
        printf "."
        let count=count+1
    done
    echo "MySQL created"
    docker exec experimentdb mysql -uroot -pa1DcN9q+ -e "CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'a1DcN9q+';"
    docker exec experimentdb mysql -uroot -pa1DcN9q+ -e "CREATE USER 'dbuser'@'172.17.0.1' IDENTIFIED BY 'a1DcN9q+';"
    docker exec experimentdb mysql -uroot -pa1DcN9q+ -e "GRANT ALL PRIVILEGES ON *.* TO 'dbuser'@'localhost';"
    docker exec experimentdb mysql -uroot -pa1DcN9q+ -e "GRANT ALL PRIVILEGES ON *.* TO 'dbuser'@'172.17.0.1';"
fi

cd experimental-liquibase
mvn liquibase:update -Dliquibase.url=jdbc:mysql://localhost:3306/experimentdb -Dliquibase.username=dbuser -Dliquibase.password="a1DcN9q+" -X
