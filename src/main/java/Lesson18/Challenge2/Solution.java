package Lesson18.Challenge2;

import java.util.*;

public class Solution {
    private final LinkedList<String> list;

    public Solution() {
        Random rnd = new Random();
        list = new LinkedList<>();
        boolean cont = true;
        int val;

        do {
            val = rnd.nextInt(100);
            if (val >= 10)
                cont = false;
        } while (cont);

        for (int i = 0; i < val; i++)
            addLast(list);
    }

    public void addLast(LinkedList<String> list) {
        Random rnd = new Random();
        list.addLast("" + rnd.nextInt(100));
    }

    public void quarter() {
        int quarter = 0;
        int counter = 1;
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            it.next();
            counter++;
            if (counter % 4 == 0)
                quarter++;
        }

        it = list.iterator();
        int temp = 0;

        while (it.hasNext()) {
            if (quarter > 0) {
                if (temp == (quarter - 1)) {
                    System.out.println(it.next());
                    break;
                } else {
                    it.next();
                    temp++;
                }
            } else {
                System.out.println(it.next());
                break;
            }
        }
    }

    public void display() {
        Iterator<String> it = list.iterator();
        System.out.println("The linked list contains:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        Solution qpl = new Solution();
        qpl.startDemo();
    }

    public void startDemo() {
        System.out.println("Elements in the list include:");
        display();
        System.out.println();
        System.out.println("Element at the 25% position is:");
        quarter();
    }
}
