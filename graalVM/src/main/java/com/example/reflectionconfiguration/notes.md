

Now we are targeting the graalVM native image, in this demo we are going to deliberately using **reflection**

    - It works fine in the JVM but it collapse in the native image (due to code analysis)


The stack : 

    > the following Stack
        - Main class : StringTransformer (service class)
        - 2 utility classes : 1- reverser and 2- capitalize
        - Controller endpoints 

Once finishing ; run  ./gradlew run and test your endpoints sames works


---

## Producing the native Executable : 

run : 
> ./gradlew task | grep native
> 
> // build the executable
> 
> ./gradlew nativeRun

The moment you execute the endpoints you get error <br>
so your role is to run the native test using the agent <br>

    - run the test + with the agent     > > > return a folder help to give reflection configure our application
