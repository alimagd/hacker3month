package com.magd.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int s1, s2, s3,max=0;
        List<Integer> highest = new ArrayList<>();
        s1 = h1.stream().mapToInt(Integer::intValue).sum();
        s2 = h2.stream().mapToInt(Integer::intValue).sum();
        s3 = h3.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(s1+" "+s2+" "+s3+" ");
        while (!(s1 == s2 && s2 == s3)) {
    max = Integer.max(Integer.max(s1, s2), s3);
//    System.out.println("max = " + max);
    if (max == s1) {
        s1 = s1 - h1.get(0);
//        System.out.println("s1 = " + s1);
        h1.remove(0);
    }
    if (max == s2) {
        s2 = s2 - h2.get(0);
//        System.out.println("s2 = " + s2);
        h2.remove(0);
    }
    if (max == s3){
        s3 = s3 - h3.get(0);
//        System.out.println("s3 = " + s3);
        h3.remove(0);
    }
}
        return s1;
    }
}

