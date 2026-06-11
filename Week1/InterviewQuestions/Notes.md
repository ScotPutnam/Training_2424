# QC Notes


## Object Oriented Programming - 4 Pillars

### Encapsulation
> **Encapsulation** describes bundling data and methods together
- Encapsulatioin prevents external control of the programs functions/fields
- Typically enforced through keyword access modifiers private, public, default, protected
- Fields must be accessed with getters and are only mutable through setters
> **Why it matters** for QA is encapsulation keeps test configurations safe from acidentally modifying production code


### Inheritance
> **Inheritance** describes creating classes from already existing ones, thus inheriting their fields and methods
> **Why it matters** test frameworks inherit from base classes to generate mock classes and scrutinize every part of a program

### Polymorphism
> **Polymorphism** describes objets responding to the same method call with different behavior
- Think of an Animal base class extending to cat and dog. Both animals will have differnet behavior, still animals
> **Why it matters** a test runner can call base class methods to test functionality without needing to know how exactly the method works

### Abstraction
> **Abstraction** hides complex implementation details, exposing only necessary aspects of program
- think abstract base classes

## Summary

- **Encapsulation:** Bundle data + methods; control access to internal state.
- **Inheritance:** Create specialized classes from general ones.
- **Polymorphism:** Same method call, different behavior depending on the object.
- **Abstraction:** Hide complexity; expose simple interfaces.
- These four pillars are the foundation of every professional Python framework you'll use.
- We'll implement these concepts with actual Python classes in the next readings.
