import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count3 = 1;
        int count5 = 1;

        for (int i = 1; i <= n; i++) {

            if (count3 == 3 && count5 == 5) {
                System.out.println("FizzBuzz");
                count3 = 0;
                count5 = 0;
            } else if (count3 == 3) {
                System.out.println("Fizz");
                count3 = 0;
            } else if (count5 == 5) {
                System.out.println("Buzz");
                count5 = 0;
            } else {
                System.out.println(i);
            }
            count3++;
            count5++;
        }
    }
}