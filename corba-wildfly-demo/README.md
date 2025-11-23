# corba-wildfly-demo

Simple HelloService CORBA demo targeting WildFly 33 and Java 17.

Project layout

corba-wildfly-demo/
 ├── pom.xml
 ├── src/
 │   ├── main/java/com/example/corba/
 │   │    ├── Hello.idl
 │   │    ├── HelloImpl.java
 │   │    ├── HelloServer.java
 │   │    ├── HelloClient.java
 │   │    └── CorbaHelper.java
 │   └── resources/
 │        └── META-INF/application.xml
 └── wildfly-config/
      └── standalone-full.xml

Build & deploy (local)

1. Build the jar:

   mvn -DskipTests package

2. Copy target jar into WildFly's `standalone/deployments/`.

3. Start WildFly (with IIOP enabled in config) and verify exposed services.
