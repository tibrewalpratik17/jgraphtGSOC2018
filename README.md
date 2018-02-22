# jgraphtGSOC2018

This stores all the files related to *Google Summer Of Code 2018*. At present, it contains a warmup exercise to get acquainted with the codebase. The JAVA class basically takes input of a `DOT` file and returns the lowest common ancestors of the two vertices which are given as input. More details regarding the task can be found [here](https://github.com/jgrapht/jgrapht/wiki/GSOC-2018-Warmup).

## Requirements

To run this project you need:
* Java8
* jdk 1.8 or higher
* Maven

## Execution

To run this project:
* `clone` the repository 
* `mvn package`
* `mvn exec:java -Dexec.args=""args1" "args2" "args3""`

Example: `mvn exec:java -Dexec.args=""GOT.dot" "Sansa" "Arya""`