package Lesson18.Challenge2;

import java.util.LinkedList;

public class QuarterPercentList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        int size = (int) ((Math.random() * 100) + 10);
        while (size > 100) size = (int)
                ((Math.random() * 100) + 10);

        for (int i = 0; i < size; i++)
            list.add(Integer.toString((int) (Math.random() * 100)));

        System.out.println("List size: " + list.size());
        System.out.println("List contents: " + list);

        int quarter = (size / 4) - 1;
        int count = 0;

        System.out.println("Quarter: " + (quarter + 1));

        for (String s : list) {
            if (count == quarter) {
                System.out.println("Quarter percent is: " + s);
                break;
            }
            count++;
        }
    }
}
