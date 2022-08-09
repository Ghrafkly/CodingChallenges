package Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryArraySequence {
    private static int longestSequence(int[] arr, int t) {
        int max = 0, count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0)
                list.add(i + 1);

        list.add(arr.length+1);

        t += 2;
        for (int i = 0; i < list.size(); i++) {
            while (t <= list.size()) {
                int x = list.get(t-1);
                int y = list.get(count);

                if (x - y - 1 > max)
                    max = x - y - 1;

                count++;
                t++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};
        int t = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of zeroes to replace");

        try {
            t = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
            System.exit(0);
        }


        int check = (int) Arrays.stream(arr).filter(j -> j == 0).count();

        while (t > check || t < 0) {
            System.out.println("Invalid input. Enter a new number of zeroes to replace:");
            t = sc.nextInt();
        }

        System.out.println(longestSequence(arr, t));
        sc.close();
    }
}
