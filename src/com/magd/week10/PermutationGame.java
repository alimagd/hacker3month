package com.magd.week10;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

public class PermutationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = permutationGame(arr);
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

    public static String permutationGame(List<Integer> arr) {
        // Write your code here
        return isWinning(arr) ? "Alice" : "Bob";
    }
    static Map<List<Integer>,Boolean> cache=new HashMap<>();
    static boolean isSorted(List<Integer> arr){
        int l=arr.size();
        for(int i=0;i<l-1;i++){
            if(arr.get(i)>arr.get(i+1))return false;
        }
        return true;
    }
    static boolean isWinning(List<Integer> list){
        if(cache.containsKey(list)){
            return cache.get(list);
        }
        int l=list.size();
        int val;
        for(int i=0;i<l;i++){
            val=list.get(i);
            list.remove(i);
            if(isSorted(list)){
                list.add(i, val);
                cache.put(list,Boolean.TRUE);
                return true;
            }
            if(!isWinning(list)){
                list.add(i,val);
                cache.put(list,Boolean.TRUE);
                return true;
            }
            list.add(i,val);
        }
        cache.put(list,Boolean.FALSE);
        return false;
    }
}