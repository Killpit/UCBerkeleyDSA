package InheritanceImplements;
import java.io.*;
import java.lang.*;
import java.util.*;

/*In Multiple inheritances, one class can have more than one superclass and inherit features from all parent classes.
* Please note that Java does not support multiple inheritances with classes. In Java, we achieve multiple inheritances
* only through interfaces.*/

//Java program to illustrate the concept of multiple inheritance

interface dog {
    public void print_tongue();
}

interface cocker {
    public void print_ears();
}

interface KingCharles extends dog, cocker {
    public void print_hair();
}

class child implements KingCharles {
    @Override
    public void print_tongue() {
        System.out.println("Tongue");
    }

    @Override
    public void print_ears() {System.out.println("Ears");}


    @Override
    public void print_hair() {System.out.println("Hair");}
}

//Driver code
public class MultipleInheritanceThroughInterface {
    public static void main(String[] args) {
        child c = new child();
        c.print_ears();
        c.print_hair();
        c.print_tongue();
    }
}