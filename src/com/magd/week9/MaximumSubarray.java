package com.magd.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MaximumSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = maxSubarray(arr);
                System.out.println(result);

//                bufferedWriter.write(
//                        result.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                                + "\n"
//                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        List<Integer> tArr = new ArrayList<>();
        int sumC = 0;
        int top = Collections.max(arr);
        if (top <= 0) {
            result.add(top);
            result.add(top);
            return result;
        }
        for (int x : arr) {
            sumC += x;
            if (sumC < 0) {
                sumC -= x;
                tArr.add(sumC);
                sumC = 0;
            } else {
                tArr.add(sumC);
            }
        }
        int max = tArr.stream().max(Comparator.naturalOrder()).get();
        result.add(max);
        int sumP = arr.stream().filter(x -> (x > 0)).mapToInt(x -> x).sum();
        result.add(sumP);
        return result;
    }
}
