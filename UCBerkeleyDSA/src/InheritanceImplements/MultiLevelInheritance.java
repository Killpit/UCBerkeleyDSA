package InheritanceImplements;
import java.lang.*;

/*In Multilevel Inheritance, a derived class will be inheriting a base class, and as well as the derived class also
* acts as the base class for other classes.*/

//Java program to illustrate the concept of Multilevel inheritance

class One {
    public void print_geek()
    {
        System.out.println("Geeks");
    }
}

class Two extends one {
    public void print_for() { System.out.println("for"); }
}

class three extends two {
    public void print_geek()
    {
        System.out.println("Geeks");
    }
}

// Drived class
public class MultiLevelInheritance {
    public static void main(String[] args)
    {
        three g = new three();
        g.print_geek();
        g.print_for();
        g.print_geek();
    }
}