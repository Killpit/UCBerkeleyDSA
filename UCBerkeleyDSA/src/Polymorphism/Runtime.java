package Polymorphism;

/*
* Subtypes of Compile-time Polymorphism:
*
* Function Overloading
*
*It is a feature in C++ where multiple functions can have the same name but with different parameter lists. The compiler
* will decide which function to call based on the number and types of arguments passed to the function.
*
* Operator Overloading
*
* It is a feature in C++ where the operators such as +, -, * etc. can be given additional meanings when applied to
* user-defined data types.
*
* Template
*
* It is a powerful feature in C++ that allows us to write generic functions and classes. A template is a blueprint for
* creating a family of functions or classes.
*
* Runtime Polymorphism
*
* It is also known as dynamic method dispatch. It is a process in which a function call to the overridden method is
* resolved at runtime. This type of polymorphism is achieved by method overriding. Method overriding, on the other
* hand, occurs when a derived class has a definition for one of the member functions of the base class. That base
* function is said to be overridden.*/

class Parent {

    //Method of parent class
    void Print() {

        //Print Statement
        System.out.println("parent class");
    }
}

class subclass1 extends Parent {

    //Method
    void Print() { System.out.println("subclass"); }
}

class subclass2 extends Parent {

    //Method
    void Print() {

        //Print statement
        System.out.println("subclass2");
    }
}

class Runtime {

    //Main driver method
    public static void main(String[] args) {

        //Creating object of class 1
        Parent a;

        //Now we will be calling print methods inside main() method
        a = new subclass1();
        a.Print();

        a = new subclass2();
        a.Print();
    }
}