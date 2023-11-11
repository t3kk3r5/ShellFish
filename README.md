ShellFish
=======================

Overview
--------

ShellFish is a simple webshell for GlassFish Server 4.0.

Prerequisites
-------------

*   Java JDK 8
*   Servlet API https://download.oracle.com/glassfish/4.0/release/

Compilation
---------------------

1.  **Compile the Java Servlets:**
    
    *   Use the Java compiler (`javac`) to compile the servlets.
    *   Ensure that the servlet API is included in the classpath.
    *   Example: 
    ```bash
    javac -classpath /path/to/javaee-api-7.0.jar -d WebContent/WEB-INF/classes src/com/webshell/WebShellServlet.java
    ```
2.  **Package the Application:**
    
    *   Package the application into a WAR file using the `jar` command.
    *   Example: 
    ``` bash
    jar -cvf WebShell.war -C WebContent/ .
    ```

Deployment on GlassFish
-----------------------

1.  Start the GlassFish server.
2.  Open the GlassFish Admin Console (usually at [http://localhost:4848](http://localhost:4848)).
3.  Navigate to the "Applications" section.
4.  Click "Deploy" and choose the generated WAR file.
5.  Follow the on-screen instructions to complete the deployment.

Accessing the Application
-------------------------

After deployment, the application can be accessed at: `http://localhost:8080/WebShell` (URL might vary depending on the server configuration and context root).

Credit
---------------

The webshell is based on `https://github.com/tennc/webshell/blob/master/fuzzdb-webshell/jsp/cmdjsp.jsp`