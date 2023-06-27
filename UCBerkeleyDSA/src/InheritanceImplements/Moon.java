package InheritanceImplements;

//Hybrid Inheritance, is a mix of two or more of the above types of inheritance.
/*
* What Can Be Done in a Subclass?
In sub-classes we can inherit members as is, replace them, hide them, or supplement them with new members:

The inherited fields can be used directly, just like any other fields.
We can declare new fields in the subclass that are not in the superclass.
The inherited methods can be used directly as they are.
We can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it (as in the example above, toString() method is overridden).
We can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
We can declare new methods in the subclass that are not in the superclass.
We can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.
 Advantages Of Inheritance in Java:

Code Reusability: Inheritance allows for code reuse and reduces the amount of code that needs to be written. The subclass can reuse the properties and methods of the superclass, reducing duplication of code.
Abstraction: Inheritance allows for the creation of abstract classes that define a common interface for a group of related classes. This promotes abstraction and encapsulation, making the code easier to maintain and extend.
Class Hierarchy: Inheritance allows for the creation of a class hierarchy, which can be used to model real-world objects and their relationships.
Polymorphism: Inheritance allows for polymorphism, which is the ability of an object to take on multiple forms. Subclasses can override the methods of the superclass, which allows them to change their behavior in different ways.
Disadvantages of Inheritance in Java:

Complexity: Inheritance can make the code more complex and harder to understand. This is especially true if the inheritance hierarchy is deep or if multiple inheritances is used.
Tight Coupling: Inheritance creates a tight coupling between the superclass and subclass, making it difficult to make changes to the superclass without affecting the subclass.
*/

class SolarSystem {
}
class Earth extends SolarSystem {
}
class Mars extends SolarSystem {
}
public class Moon extends Earth {
    public static void main(String args[])
    {
        SolarSystem s = new SolarSystem();
        Earth e = new Earth();
        Mars m = new Mars();

        System.out.println(s instanceof SolarSystem);
        System.out.println(e instanceof Earth);
        System.out.println(m instanceof SolarSystem);
    }
}