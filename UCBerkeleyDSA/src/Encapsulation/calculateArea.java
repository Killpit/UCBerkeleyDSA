package Encapsulation;

/*Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together
* code and the data it manipulates.

*Technicallu in encapsulation, the variables of data of a class is hidden from any other class and can be accessed
* only through any member function of its own class in which it is declared.

*As in encapsulation, the data in a class is hidden from other classes using the data hiding concept which is achieved
* by making the members or methods of a class private, and the class is exposed to the end-user or the world without
* providing any details behind implementation using the abstraction concept, so it is also known as a combination of
* data-hiding and abstraction.

*Encapsulation can be achieved by declaring all the variables in the class as private and writing public methods in
* the class as private and writing public methods in the class to set and get the values of variables.

*It is more defined with the setter and getter method.  */

/*Advantages of Encapsulation
*
* Data Hiding: it is a way of restricting the access of our data members by hiding the implementation details.
* Encapsulation also provides a way for data hiding. The user will have no idea about the inner implementation of the
* class. It will not be visible to the user how the class is storing values in the variables. The user will only know
* that we are passing the values to a setter method and variables are getting initialized with that value.

*Increased Flexibility: We can make the variables of the class read-only or write-only depending on our requirements.
* If we wish to make the variables read-only, then we have to omit the setter methods like setName(), setAge(), etc.
* from the above program or if we wish to make the variables write-only, then we have to omit the get methods like
* getName(), getAge(), etc. from the above program

*Re-usability: Encapsulation also improves re-usability and it is easy to change with new requirements.

*Testing code is easy: Encapsulated code is easy to test for unit testing

*Freedom to programmer in implementing the details of the system: This is one of the major advantage of encapsulation
* that it gives the programmer freedom in implementing the details of a system. The only constraint on the programmer
* is to maintain the abstract interface that outsiders see.*/

//fields to calculate area
class Area {

    int length;
    int breadth;

    //constructor to initialize values
    Area(int length, int breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }

    //method to calculate area
    public void getArea()
    {
        int area = length * breadth;
        System.out.println("Area: " + area);
    }
}

class calculateArea {
    public static void main(String[] args)
    {
        Area rectangle = new Area(2, 16);
        rectangle.getArea();
    }
}