
To create maven project
>mvn archetype:generate "-DgroupId=com.keyboard.app" "-DartifactId=keyboard-app" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.5" "-DinteractiveMode=false"

To clean and compile
>mvn clean compile

To build executable jar file
>mvn package

To clean and compile and To build executable jar file
> mvn clean package && java -jar .\target\keyboard-app-1.0.jar