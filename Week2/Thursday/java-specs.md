# Java

## Topics
- Memory Management
- Garbage Collector
- Strings


### Strings
- String is a class
- String is a sequence of characters which is immutable
- Created using a string literal " " or using String class constructor

#### String literal
- Stored in the string pool, special memory area

#### String Object
- String intern like in Python
- Java first checks requested string object in string pool, if exists, returns reference to pool
- Else will create new string object

#### Comparison in Java
- == compares primitives, compares objects reference
- .equals() - does a value-value hash comparison, useful for checking string equality

### Memory Management