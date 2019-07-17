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
# Instructions on pushing the code

```
a) git pull origin master (this my lead to merge conflict)
      >Two types of merge conflit
      i) we worked on the same file but git was able to fix it for us
          1) a window opens in nano editor to leave a comment on the merge
          2) press ctrl + O , press enter key, press ctrl + X (this save the merge message)
          3) merge is finished ready to add, commit and push
      ii) we worked on same file and same lines and git can't fix it (this is unlikely in our situation)
          1) read this <https://www.atlassian.com/git/tutorials/using-branches/merge-conflicts>
             jump to the explaination under "How to identify merge conflicts"
b) git add . (in the root of the project)
c) git commit -m "a message"
d) git push origin master
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

