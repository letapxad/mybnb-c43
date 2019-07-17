# Instructions to complie and run the project

clone the repository
```
git clone git@github.com:letapxad/mybnb-c43.git
```

Compile the maven project
```
mvn clean package
```

run the jar file
```
java -jar target/mybnb-c43.jar
```


# Instructions on what to do to test DB on java code change

made changes to model classes and SAVED the files

```
0) mysql -u root (in cmd)
1) drop database mybnbauto; (in cmd)
```
above will drop everything about DB if it exists

```
2) mvn clean package (in cmd, in project root directory)
```
above will compile and and store the jar file in target folder

```
3) java -jar target\mybnb-c43.jar (in cmd)
```
above will run the project you just compiled, it is a server to it will stay live and won't exit

```
4) mysql -u root (in another cmd window, all of the below)
5) use mybnbauto;
6) show tables;
7) describe <table_name>; (to see tables schema)
```
above queries to navigate your changes and see if they reflect

```
8) press ctrl + c (in the window us used in step 3, this kills the server)
```
START OVER from 0)

