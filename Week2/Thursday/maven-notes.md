# Thursday Notes

## Topics
- JAR - Java Archive files 
- EAR - Enterprise Archives file

---

## JAR/WAR Files

### Category of JARS
- executable JAR files - Will have at least one class containing main method 
- Non executable JAR files - Will contain no main method, contains 

### Executing JAR files
- java -jar jar_file

### packages
- logically group classes and methods

### Test vs. Source
- seperate src and test/ files
- test/ is where to contain Junit and Mockito test classes

---

## Maven


### pom.xml 
- project object model
- xml - Extensible markup language
- tags are known are coordinates

#### GAV (group, artifact, version) 
- required tags for pom in enclosing <>
- groupId /groupId, artifactId /artifactId, version /version
- properties /properties, dependancies /dependancies, build /build

### Project Management Tool
- Build Automation and Dependancy Management tool

### Build Automation
- Automatically initializes src and test directories
- 

### Dependancy Management
- manages Java version
- allows easy addition of dependancies

### Build Lifecycle
- Goal: A task implemented by plugin
- Phase: Named step in the lifecycle
- Ordered Sequence of steps followed for building an app

### Default lifecycle (subset)

| Phase | Typical work |
|-------|----------------|
| `validate` | Check project is correct |
| `compile` | Compile main sources |
| `test-compile` | Compile tests |
| `test` | Run unit tests (Surefire) |
| `package` | Produce JAR/WAR/etc. |
| `verify` | Run checks (e.g. integration tests) |
| `install` | Put artifact in local `~/.m2` repository |
| `deploy` | Publish to remote repository |

> **Phases run in sequence** so running mvn test will run the previous phases as well


# Garbage Collector

## 