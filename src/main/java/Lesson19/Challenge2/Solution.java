package Lesson19.Challenge2;

import java.util.*;

public class Solution {

    private Stack<String> stack;

    public Solution() {
        stack = new Stack<>();
        Random rnd = new Random();
        int max = rnd.nextInt(10);

        for (int i = 0; i < max; i++)
            stack.push("" + rnd.nextInt(100));
    }

    public void display() {
        System.out.println(Arrays.toString(stack.toArray()));
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        ss.start();
    }

    public void sort(Stack<String> stack) {
        Stack<String> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            String temp = stack.pop();

            while (!tempStack.isEmpty() && Integer.parseInt(tempStack.peek()) > Integer.parseInt(temp))
                stack.push(tempStack.pop());

            tempStack.push(temp);
        }
        this.stack = tempStack;
    }

    public void start() {
        System.out.println("Stack before reverse:");
        display();
        sort(stack);
        System.out.println("Stack after sort:");
        display();
    }
}
