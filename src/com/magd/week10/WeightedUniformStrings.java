package com.magd.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class WeightedUniformStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = weightedUniformStrings(s, queries);
        System.out.println(result);
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        List<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            alphabet.add(c);
        }
        int w = 0;
        List<String> res = new ArrayList<>();
        Set<Integer> weights = new HashSet<>();
        char chary = s.charAt(0);
        for (char ch : s.toCharArray()) {
            int ind = alphabet.indexOf(ch) + 1;
            if (ch == chary) {
                w += ind;
            } else {
                w = ind;
                chary = ch;
            }
            weights.add(w);
        }
        for (int y : queries) {
            if (weights.contains(y)) {
                res.add("Yes");
            } else res.add("No");
        }
        return res;
    }
}

