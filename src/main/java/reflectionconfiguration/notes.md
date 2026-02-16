

Now we are targeting the graalVM native image, in this demo we are going to deliberately using **reflection**

    - It works fine in the JVM but it collapse in the native image (due to code analysis)
    - 