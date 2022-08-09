package Lesson18.Challenge1;

import java.util.*;

public class Solution {
    private final LinkedList<String> listOne;
    private final LinkedList<String> listTwo;

    public Solution() {
        Random rnd = new Random();

        listOne = new LinkedList<>();

        int val = rnd.nextInt(5);
        for (int i = 0; i < val; i++)
            addLast(listOne);

        listTwo = new LinkedList<>();

        val = rnd.nextInt(5);
        for (int i = 0; i < val; i++)
            addLast(listTwo);
    }

    public void addLast(LinkedList<String> list) {
        Random rnd = new Random();
        list.addLast("" + rnd.nextInt(100));
    }

    public void addLast(LinkedList<String> list, String value) {
        list.addLast(value);
    }

    public void combine() {
        listTwo.forEach(s -> addLast(listOne, s));
    }

    public void display(LinkedList<String> list) {
        Iterator<String> it = list.iterator();
        System.out.println("The linked list contains:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        Solution llc = new Solution();
        llc.startDemo();
    }

    public void startDemo() {
        System.out.println("Elements in the first list include:");
        display(listOne);
        System.out.println();
        System.out.println("Elements in the second list include:");
        display(listTwo);
        System.out.println();
        combine();
        System.out.println("Combined elements include:");
        display(listOne);
    }
}
