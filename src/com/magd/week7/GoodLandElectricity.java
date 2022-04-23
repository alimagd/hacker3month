package com.magd.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

public class GoodLandElectricity {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = pylons(k, arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static int pylons(int k, List<Integer> arr) {
        int counter = 0;
        int index = 0;
        int notCovered = 1;
        int lastAvailable = -1;
        while (index < arr.size()) {
            if (arr.get(index) == 1) {
                lastAvailable = index;
            }

            if (notCovered >= k) {
                if (lastAvailable == -1) {
                    return -1;
                }
                notCovered = -(k - 1) + (index - lastAvailable) + 1;
                index++;
                counter++;
                lastAvailable = -1;
            } else if (index == arr.size() - 1) {
                if (notCovered > 0) {
                    if (lastAvailable != 0) {
                        counter++;
                    } else {
                        return -1;
                    }
                }
                index++;
            } else {
                notCovered++;
                index++;
            }
        }
        return counter;
    }
}

