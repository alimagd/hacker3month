package com.magd.week10;

import java.util.*;

public class QHEAP1 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int Q , first, second ;
        int min = Integer.MAX_VALUE;
        List<Integer> arr = new ArrayList<>();

        Q = scan.nextInt();
        while (Q > 0) {
            first = scan.nextInt();
            switch (first) {
                case 1:
                    second = scan.nextInt();
                    arr.add(second);
                    if (second<min || arr.size()==1) min = second;
                    break;
                case 2:
                    second = scan.nextInt();
                    arr.remove(Integer.valueOf(second));
                    if (min == second && !arr.isEmpty()) min = Collections.min(arr);
                    break;
                case 3:
                    System.out.println(min);
                    break;
            }
            Q--;
        }
    }
}
