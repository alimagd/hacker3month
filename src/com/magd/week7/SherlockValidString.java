package com.magd.week7;

import java.io.*;
import java.util.*;

public class SherlockValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = isValid(s);
        System.out.println(result);
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static String isValid(String s) {

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int counter = 0;
        char character = 0;
        Arrays.sort(chars);
        char tmp = chars[0];

        for (char aChar : chars) {
            character = aChar;
            if (aChar == tmp) {
                counter++;
            } else {
                set.add(counter);
                map.put(tmp, counter);
                counter = 1;
                tmp = aChar;
            }
        }
        map.put(character, counter);
        set.add(counter);
        // set : numbers of any char in the string s
        // map : map of any char with its numbers
        // ints : array of numbers

        if (map.size() < 2) return "YES";
        if (set.size() < 2) return "YES";

        int[] ints = map.values().stream().mapToInt(x -> x).toArray();
        Arrays.sort(ints);

        if (map.size() == 2
                && Math.abs(ints[1] - ints[0]) < 2) return "YES";
        if (set.size() == 2 && Collections.min(set) == 1) {
            int count1 = counting(1, ints);
            if (count1==1) return "YES";
        }
            if (set.size() == 2
                    && ints[ints.length - 1] - ints[0] == 1) {
                int count2 = counting(ints[0], ints);
                int count3 = counting(ints[ints.length - 1], ints);
                if (count2 == 1 || count3 == 1) return "YES";
            }

        return "NO";
    }

    // a method for counting an array values
    static int counting(int x, int[] arr) {
        int c = 0;
        for (int a : arr) {
            if (a==x) c++;
        }
        return c;
    }
}




