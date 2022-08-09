package Quiz;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    private static Stack<String> reverse(Stack<String> stack) {
        Stack<String> tempStack = new Stack<>();
        while (!stack.isEmpty())
            tempStack.push(stack.pop());
        return tempStack;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        System.out.print("""
                1) Enter strings
                2) Random strings
                """);

        String choice = sc.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.println("Enter strings. Stop entry with empty line:");
                while (true) {
                    String str = sc.nextLine();
                    if (str.equals(""))
                        break;
                    stack.push(str);
                }
            }
            case "2" -> {
                Random rnd = new Random();
                int max = rnd.nextInt(10);
                for (int i = 0; i < max; i++)
                    stack.push("" + rnd.nextInt(100));
            }
            default -> {
                System.out.println("Invalid choice");
                System.exit(0);
            }
        }

        System.out.println("Stack before reverse:" + stack);
        stack = reverse(stack);
        System.out.println("Stack after reverse:" + stack);
    }
}
