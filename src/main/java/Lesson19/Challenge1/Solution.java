package Lesson19.Challenge1;

import java.util.*;

public class Solution {
    Deque<Character> stack;

    public Solution() {
        stack = new ArrayDeque<>();
    }

    public void check(String exp) {
        if (validExp(exp))
            System.out.println(validate(exp) ? "Expression well formed" : "Expression not well formed.");
        else
            System.out.println("Expression contains non numeric characters. Invalid");
    }

    public static void main(String[] args) {
        Solution ce = new Solution();
        ce.startDemo();
    }

    public void startDemo() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter a mathematical expression");
        String exp = console.nextLine();
        check(exp);
    }

    public boolean validExp(String exp) {
        for (int i = 0; i < exp.length(); i++) {
            int val = exp.charAt(i);

            if (((val < '0') || (val > '9')) &&
                    (val != '+') && (val != '-') && (val != '*') && (val != '/') &&
                    (val != '(') && (val != '{') && (val != '[') &&
                    (val != ')') && (val != '}') && (val != ']')) {
                return false;
            }
        }
        return true;
    }

    public boolean validate(String exp) {
        boolean operand = false;
        boolean operator = false;

        label:
        for (int i = 0; i < exp.length(); i++) {
            char val = exp.charAt(i);
            if ((val >= '0') && (val <= '9')) {
                if (operator) {
                    switch (stack.peek()) {
                        case '+', '-', '*', '/' -> {
                            stack.pop();
                            operator = false;
                        }
                    }
                }
                operand = true;
            } else if ((val == '(') || (val == '[') || (val == '{')) {
                stack.push(val);
            } else {
                switch (val) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        if ((i > 0) && (operand)) {
                            if (operator) {
                                switch (stack.peek()) {
                                    case '+', '-', '*', '/' -> {
                                        stack.pop();
                                        operand = false;
                                    }
                                }
                            }
                            stack.push(val);
                            operator = true;
                        } else {
                            break label;
                        }
                        break;
                    default:
                        if (stack.isEmpty())
                            return false;

                        char check;

                        switch (val) {
                            case ')' -> {
                                check = stack.pop();
                                if (check == '{' || check == '[')
                                    return false;
                            }
                            case '}' -> {
                                check = stack.pop();
                                if (check == '(' || check == '[')
                                    return false;
                            }
                            case ']' -> {
                                check = stack.pop();
                                if (check == '(' || check == '{')
                                    return false;
                            }
                        }

                        if (!stack.isEmpty()) {
                            switch (stack.peek()) {
                                case '+', '-', '*', '/' -> {
                                    stack.pop();
                                    operand = false;
                                }
                            }
                        }
                        break;
                }
            }
        }
        return true;
    }
}
