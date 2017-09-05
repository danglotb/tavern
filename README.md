# Tavern

This a a toy project for tutorial on usage of DSpot.

There are two branches: `master` which is stable and `regression` which contains a regression bug made during refactoring of the method **sellItem** of **fr.inria.stamp.tavern.Seller**.

We suppose that you pulled DSpot from GitHub and build it in a parent directory:

```
.
+-- DSpot
|   +-- target
|   |   +-- dspot-1.0.0-jar-with-dependencies.jar
+-- tavern
|   +-- src
|   |   +-- main
|   |   |   +-- resources
|   |   |   |   +-- tavern.properties
```

You can find the property file to give as input to DSpot in `src/main/resources/`.

```
#relative path to the project root from dspot project
project=../tavern
#relative path to the source project from the project properties
src=src/main/java/
#relative path to the test source project from the project properties
testSrc=src/test/java
#java version used
javaVersion=8
#filter used to amplify specific test cases
filter=fr.inria.stamp.*
#path to the output folder
outputDirectory=output
```

You can amplify test of this project using the following command
```
java -jar target/dspot-1.0.0-jar-with-dependencies.jar -p ../tavern/src/main/resources/tavern.properties -i 1 -t fr.inria.stamp.MainTest -c test --verbose -a TestDataMutator
```