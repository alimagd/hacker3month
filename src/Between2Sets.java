import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Between2Sets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = getTotalX(arr, brr);
        System.out.println("total = " + total);

//        bufferedWriter.write(String.valueOf(total));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            boolean isX = true;
            for (int j = 0; j < a.size() && isX; j++) {
                if (i % a.get(j) != 0) isX = false;
            }
            for (int j = 0; j < b.size() && isX; j++) {
                if (b.get(j) % i != 0) isX = false;
            }
            if (isX) count++;
        }
        return count;
    }

}
