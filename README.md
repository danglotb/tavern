# Tavern

This a a toy project for tutorial on usage of DSpot.

There are two branches: `master` which is stable and `refactor` which contains regression bugs made during refactoring of the method **sellItem** of **fr.inria.stamp.tavern.Seller**.

We suppose that you pulled DSpot from GitHub and build it in a parent directory:
```
.
+-- dspot
|   +-- target
|   |   +-- dspot-1.0.0-jar-with-dependencies.jar
+-- tavern
|   +-- src
|   |   +-- main
|   |   |   +-- resources
|   |   |   |   +-- tavern.properties
```

`tavern` is this project, pointing on the `master` branch

Ensure that on both versions, the existing test suite is passing by running `mvn clean test`.

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
#following properties are used by the ChangeDetectorSelector
configPath=src/main/resources/tavern.properties
folderPath=../tavern-refactor
```

First, run `dspot` using the **NumberLiteralAmplifier**, and the default selector **PitMutantScoreSelector** with the following command:

```
java -jar ../dspot/target/dspot-1.0.0-jar-with-dependencies.jar --path-to-properties ../tavern/src/main/resources/tavern.properties --iteration 2 --test fr.inria.stamp.MainTest --cases test --amplifiers NumberLiteralAmplifier --test-criterion PitMutantScoreSelector
```

At the end of the execution, you obtain:
```
======= REPORT =======
PitMutantScoreSelector:
The original test suite kill 66 mutants
The amplification results with 3 new tests
it kill 4 more mutants
```

You can now copy paste the amplified from output to src/test/java using:

```
cp output/fr/inria/stamp/AmplMainTest.java src/test/java/fr/inria/stamp/AmplMainTest.java
```

then run tests:

```
mvn clean test
```

Eventually, checkout the refactor-branch and re-run maven test:

```
git checkout refactor
mvn clean test
```

You see a failing test. This test encodes the regression introduces during the refactoring.

### Details on the command and the customization of DSpot's execution:

* `--path-to-properties ../tavern/src/main/resources/tavern.properties` &#10137; Specifies the path the property file.
* `--iteration 2` &#10137; Number of time that the DSpot's main loop will be applied.
* `--test fr.inria.stamp.MainTest` &#10137; The test class **fr.inria.stamp.MainTest** (full qualified name) to be amplified.
* `--cases test` &#10137; The test method (test case) named **test** of the specified test class to be amplified.
* `--amplifiers NumberLiteralAmplifier` &#10137; Class name of the amplifier used to modify input of the test.
* `--test-criterion PitMutantScoreSelector` &#10137; Class name of the selector used to filter which amplified test DSpot must keep.

### Mutation analysis results

You can results of the mutations analysis in `mutations_results`:

* original.csv is the mutations analysis obtained used only the existing test.
* amplified.csv is the mutations analysis obtained used both the original and the amplified version of test.
* diff.csv is the list of new mutants killed by the amplified version.
* remain_alive.csv is the list of mutants that remains alive after the amplification.
