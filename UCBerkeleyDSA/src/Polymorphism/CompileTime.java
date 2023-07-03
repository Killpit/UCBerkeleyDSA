package Polymorphism;

/*
* Compile-Time Polymorphism
*
* Known as static polymorphism. This type of polymorphism is achieved by function overloading or operator overloading.
*
* Java doesn't support the operator overloading
*
* Method Overloading
*
* When there are multiple functions with the same name but different parameters, then these functions are said to be
* overloaded. Functions can be overloaded by changes in the number of arguments or/and a change in the type of
* arguments.*/

//Java program for method overloading by using different types of arguments
class Helper {

    //Method with 2 integer parameters
    static int Multiply (int a, int b) {

        //Returns product of integer numbers
        return a * b;
    }

    //Method 2 with same name but with 2 double parameters
    static double Multiply(int i, double a, double b) {

        //Returns product of double numbers
        return a * b;
    }
}

//Main class
class CompileTime {

    public static void main(String[] args) {

        //Calling method by passing input as in arguments
        System.out.println(Helper.Multiply(2, 4));
        System.out.println(Helper.Multiply(2, 5.5, 6.3));
    }
}