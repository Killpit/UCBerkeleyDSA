package Encapsulation;

/*Encapsulation refers to the bundling of data and methods that operate on that data within a single unit. It is used
* as a way of hiding the implementation details of a class from outside access and only exposing a public interface
* that can be used to interact with the class.
*
* In Java, encapsulation is achieved by declaring the instance variables of a class as private, which means they can
* only be accessed within the class. To allow outside access to the instance variables, public methods called getters
* and setters are defined, which are used to retrieve and modify the values of the instance variables, respectively.
* By using getters and setters, the class can enforce its own data validation rules and ensure that its internal state
* remains consistent.*/

class Person {
    private String name;
    private int age;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}

public class newPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}