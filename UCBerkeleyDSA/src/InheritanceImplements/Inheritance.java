package InheritanceImplements;/*Inheritance is the mechanism in Java by which one class is allowed to inherit the features of another class. A
* class that inherits from another class can reuse the methods and fields of that class. In addition, you can add new
* fields and methods to your current class as well.
*
* Why do we need java inheritance?
*
* Code reusability: The code written in the Superclass is common to all subclasses. Child classes can directly use the
* parent class code.
*
* Method Overriding: Method Overriding is achievable only through inheritance. It is one of the ways by which Java
* archives run time polymorphism.
*
* Abstraction: The concept of abstract where we do not have to provide all details is achieved through inheritance.
* Abstraction only shows the functionality to the user.*/

//Base class
class Bicycle {
    //the Bicycle class has two fields
    public int gear;
    public int speed;

    //the Bicycle class has one constructor
    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    //the Bicycle class has three methods
    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    //toString() method to print info of Bicycle
    public String toString() {
        return ("No of gears are " + gear + "\n" + "speed of bicycle is " + speed);
    }
}

//derived class
class MountainBike extends Bicycle {
    //the MountainBike subclass adds one more field
    public int seatHeight;

    //the MountainBike subclass has one constructor
    public MountainBike(int gear, int speed, int startHeight) {
        //invoking base-class (Bicycle) constructor
        super(gear, speed);
        seatHeight = startHeight;
    }

    //the MountainBike subclass adds one more method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    //overriding toString() method of bicycle to print more info

    @Override
    public String toString() {
        return (super.toString() + "\nseat height is " + seatHeight);
    }
}

//driver class
public class Inheritance {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(3, 100, 25);
        System.out.println(mb.toString());
    }
}