package com.magd.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CoinChangeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        System.out.println(ways);
//        bufferedWriter.write(String.valueOf(ways));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static long getWays(int n, List<Long> c) {
        // Write your code here
// c = [8,3,1,2] , n=3
        if (n == 0) {
            return 1;
        }

        long[][] dp = new long[c.size()][n+1];

        for(int val=1; val<=n; val++) {

            for(int i=0; i<c.size(); i++) {
                int coinSize = Math.toIntExact(c.get(i));
                if (i == 0) {
                    while(coinSize <= val) {
                        dp[i][coinSize] = 1;
                        coinSize += c.get(i);
                    }
                } else {
                    while (coinSize <= val) {
                        if (coinSize == val) {
                            dp[i][val] += 1;
                        }
                        dp[i][val] += dp[i-1][val-coinSize];
                        coinSize += c.get(i);
                    }
                    dp[i][val] += dp[i-1][val];
                }
            }
        }

        return dp[c.size()-1][n];

    }
}

