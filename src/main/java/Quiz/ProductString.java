package Quiz;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class ProductString {
    private static String product(String x, String y) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            if (x.length() == 1)
                a.push(0);
            a.push(Character.getNumericValue(x.charAt(i)));
        }

        for (int i = 0; i < y.length(); i++) {
            if (y.length() == 1)
                b.push(0);
            b.push(Character.getNumericValue(y.charAt(i)));
        }

        if (a.size() > 2 || b.size() > 2) {
            System.out.println("Invalid input");
            System.exit(0);
        }

        int a2 = a.pop();
        int a1 = a.pop();

        int b2 = b.pop();
        int b1 = b.pop();

        int a3 = (a1 * 10) + a2;
        int b3 = (b1 * 10) + b2;

        return "" + (a3 * b3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        String x = "";
        String y = "";

        System.out.print("""
                1) Enter two numbers < 100
                2) Random numbers < 100
                """);

        String choice = sc.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.println("Enter two numbers < 100:");
                x = sc.nextLine();
                y = sc.nextLine();
            }
            case "2" -> {
                x = String.valueOf(rnd.nextInt(100));
                y = String.valueOf(rnd.nextInt(100));
            }
            default -> {
                System.out.println("Invalid choice");
                System.exit(0);
            }
        }

        System.out.println("Product of " + x + " and " + y + " is " + product(x, y));
    }
}
