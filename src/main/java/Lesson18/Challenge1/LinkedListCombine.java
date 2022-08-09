package Lesson18.Challenge1;

import java.util.LinkedList;

public class LinkedListCombine {

    public static LinkedList<String> combine(LinkedList<String> list1, LinkedList<String> list2) {

        while (!list2.isEmpty())
            list1.add(list2.removeFirst());

        list1.addAll(list2);

        return list1;
    }

    public static void main(String[] args) {
        LinkedList<String> x = new LinkedList<>();
        LinkedList<String> y = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            x.add(String.valueOf((int) (Math.random() * 100) + 1));
            y.add(String.valueOf((int) (Math.random() * 100) + 1));
        }

        System.out.println("X: " + x);
        System.out.println("Y: " + y);

        LinkedList<String> z = combine(x, y);
        System.out.println(z);
    }
}
