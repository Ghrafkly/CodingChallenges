package Lesson19.Challenge1;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Character.isDigit;

public class CheckExpression {

    private boolean wellFormed(String exp) {
        Stack<Character> stack = new Stack<>();

        if (exp.contains(" "))
            exp = exp.replace(" ", "");

        String[] arr = exp.split("");
        Character[] arrChar = new Character[arr.length];

        for (int i = 0; i < arr.length; i++)
            arrChar[i] = arr[i].charAt(0);

        Arrays.stream(arrChar).forEach(stack::push);

        System.out.println(stack);

        Character hold = null;
        boolean b = true;
        while (stack.size() > 0 && b) {
            Character check = stack.pop();

            if (hold == null) {
                hold = check;
            } else if (isDigit(hold)) {
                if (isOperator(check)) hold = check;
                else b = false;
            } else if (isOperator(hold)) {
                if (isDigit(check)) hold = check;
                else b = false;
            } else {
                b = false;
            }
        }

        return b;
    }

    private boolean isOperator(Character check) {
        return check == '+' || check == '-' || check == '*' || check == '/';
    }

    public static void main(String[] args) {
        String exp = "1+2-3";
        CheckExpression ce = new CheckExpression();
        System.out.println(ce.wellFormed(exp) ? "Well Formed" : "Not Well Formed");
    }
}
