package com.magd.week9;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ChiefHopper {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = chiefHopper(arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static int chiefHopper(List<Integer> arr) {
        // Write your code here
        int minStartEnergy = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            int height = arr.get(i);
            if (height > minStartEnergy) {
                minStartEnergy += (int) Math.ceil((height - minStartEnergy) / 2.0);
            } else if (height < minStartEnergy) {
                minStartEnergy = (int) Math.ceil((height + minStartEnergy) / 2.0);
            }
        }
        return minStartEnergy;
    }

}

