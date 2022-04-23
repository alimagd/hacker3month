package com.magd.week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static int alternate(String s) {
        // Write your code here
        char[] chars = s.toCharArray();
        int res = 0;
        String str;
        Set<String> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(String.valueOf(aChar));
        }
        String sSet = String.join("", set);
        char[] tChars = sSet.toCharArray();

        for (int i = 0; i < sSet.length() - 1; i++) {
            for (int j = i + 1; j < sSet.length(); j++) {
                char one = tChars[i];
                char two = tChars[j];
                str = s.replaceAll("[^" + one + "" + two + "]", "");
                if (strIsAlter(str)) {
                    int len = str.length();
                    res = Math.max(len, res);
                }
            }
        }
        return res;
    }

    private static boolean strIsAlter(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

