package Encapsulation;

class Account {
    private long acc_no;
    private String name, email;
    private float amount;

    //public getter and setter methods
    public long getAcc_no() { return acc_no; }
    public void setAcc_no(long acc_no)
    {
        this.acc_no = acc_no;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public float getAmount() { return amount; }
    public void setAmount(float amount)
    {
        this.amount = amount;
    }
}

public class Acc {
    public static void main(String[] args)
    {
        //creating instance of Account class
        Account acc = new Account();
        //setting values through setter methods
        acc.setAcc_no(7310805450L);
        acc.setName("MD FAIZ");
        acc.setEmail("mdfaiz689@gmail.com");
        acc.setAmount(100000f);
        //getting values through getter methods
        System.out.println(
                acc.getAcc_no() + " " + acc.getName() + " "
                + acc.getEmail() + " " + acc.getAmount());
    }
}

/*

* Advantages

* Improves security of an object's internal state by hiding it from the outside world.

* Increases modularity and maintainability by making it easier to change the implementation without affecting other
parts of the code

* Enables data abstraction, allowing objects to be treated as a single unit.

* Allows for easy addition of new methods and fields without affecting the existing code.

* Supports the object-oriented principle of information hiding, making it easier to change the implementation
without affecting the rest of the code */

/*

* Disadvantages

* Can lead to increased complexity, especially if not used properly

* Can make it more difficult to understand how the system works.

* May limit the flexibility of the implementation */