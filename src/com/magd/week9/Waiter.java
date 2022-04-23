package com.magd.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = waiter(number, q);
        System.out.println(result);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        // Write your code here
        List<Integer> primes = getPrimes(q);
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        for (Integer value : number) {
            A.push(value);
        }
        int prime;

        for (int i = 0; i < q; i++) {
            prime = primes.get(i);
            Stack<Integer> B = new Stack<>();
            Stack<Integer> nextA = new Stack<>();
            while (!A.isEmpty()){
                int num = A.pop();
                if (num % prime == 0) {
                    B.push(num);
                } else {
                    nextA.push(num);
                }
            }
            answer.addAll(stackToList(B));
            A = nextA;
        }
        answer.addAll(stackToList(A));
        return answer;
    }

    public static List<Integer> stackToList(Stack<Integer> stack) {
        List<Integer> res = new ArrayList<>();
        int tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            res.add(tmp);
        }
        return res;
    }
    public static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int x = 3;
        while (n > 1) {
            if (isPrime(x)) {
                primes.add(x);
                x += 2;
                n--;
            } else x += 2;
        }
        System.out.println("primes = " + primes);
        return primes;
    }

    private static boolean isPrime(int x) {

        for (int i = 3; i < x / 2; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

}


