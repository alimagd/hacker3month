package com.magd.week8;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.IntStream;

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = isBalanced(s);
                System.out.println(result);

//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static String isBalanced(String s) {
        // Write your code here

        Stack<Character> stack = new Stack<>();
        if (s.isEmpty()) return "NO";
        char dish = s.charAt(0);
        stack.add(dish);

        String sub = s.substring(1);

        for (char c : sub.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            } else dish = stack.peek();
                if (isPair(dish, c)) {
                    stack.pop();
                } else stack.add(c);
        }
        if (stack.isEmpty()) return "YES";
        else
            return "NO";
    }

    public static boolean isPair(char c1, char c2) {
        switch (c1) {
            case '{':
                if (c2 == '}')
                    return true;
            case '(':
                if (c2 == ')')
                    return true;
            case '[':
                if (c2 == ']')
                    return true;
        }
        return false;
    }
}

