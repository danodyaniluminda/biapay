## nexus upload - library project ##
#
If your project for publish dependency for others, please follow below guidences. <p>
`` Note: dependency version should be increase every release.``
```
Ex:
  <groupId>com.biapay</groupId>
  <artifactId>core</artifactId>
  <version>0.0.1</version>
  <name>core</name>
  <description>BIAPAY Core</description>
```


1: Your pom file should be include below blox for enable deploy command.

```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-deploy-plugin</artifactId>
            <version>2.8.2</version>
            <configuration>
                <file>target/${project.artifactId}-${project.version}.jar</file>
                <groupId>${project.groupId}</groupId>
                <artifactId>${project.artifactId}</artifactId>
                <version>${project.version}</version>
                <packaging>jar</packaging>
                <repositoryId>nexus</repositoryId>
                <url>https://nexus.biapay.net/repository/maven-releases/</url>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>deploy-file</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
 
<distributionManagement>
    <repository>
        <id>nexus</id>
        <url>https://nexus.biapay.net/repository/maven-releases/</url>
    </repository>
</distributionManagement>
```

2: docker for CI process

```
FROM harbor.biapay.net/maven/3-adoptopenjdk-11:01 as builder
WORKDIR /application
COPY . /application
RUN mvn package -DskipTests
RUN mvn deploy:deploy-file
```