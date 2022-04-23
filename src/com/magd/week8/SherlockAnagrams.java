package com.magd.week8;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class SherlockAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = sherlockAndAnagrams(s);
                System.out.println(result);

//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            List<String> sub = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (i + j < s.length() + 1)
                    sub.add(s.substring(j, i + j));
            }
            for (int j = 0; j < sub.size(); j++) {
                for (int k = j + 1; k < sub.size(); k++) {
                    if (isAnagrams(sub.get(j), sub.get(k))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static final int ALPHABET_COUNT = 26;
    private static boolean isAnagrams(String str1, String str2) {

        char[] chars1 = new char[ALPHABET_COUNT];
        char[] chars2 = new char[ALPHABET_COUNT];

        for (int i = 0; i < str1.length(); i++) {
            chars1[str1.charAt(i) - 97] += 1;
            chars2[str2.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}

