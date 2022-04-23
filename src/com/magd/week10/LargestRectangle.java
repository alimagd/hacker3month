package com.magd.week10;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = largestRectangle(h);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static long largestRectangle(List<Integer> h) {
        // Write your code here
//        h.sort(Collections.reverseOrder());
        Stack<Integer> st = new Stack<>();
        long maxArea = 0;
        for (int i = 0; i <= h.size(); i++) {
            int tmp = (i == h.size()) ? 0 : h.get(i);
            if (st.isEmpty() || h.get(st.peek()) <= tmp) {
                st.push(i);
            }else {
                int top = st.pop();
                maxArea = Math.max(maxArea, (long) h.get(top) * (st.isEmpty() ? i : i - st.peek() - 1));
                i--;
            }
        }
        return maxArea;
    }
}

