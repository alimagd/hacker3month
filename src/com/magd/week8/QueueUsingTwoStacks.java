package com.magd.week8;

//In this challenge, you must first implement a queue using two stacks.
// Then process q queries, where each query is one of the following 3 types:
//        1 x: Enqueue element  into the end of the queue.
//        2: Dequeue the element at the front of the queue.
//        3: Print the element at the front of the queue.
//Input Format:
// The first line contains a single integer, q , denoting the number of queries.
// Each line i of the q subsequent lines contains a single query in the form described
//   in the problem statement above. All three queries start with an integer denoting the query type
//   ,but only query 1 is followed by an additional space-separated value x
//   ,denoting the value to be enqueued.
//
//Constraints: 1 <= type <= 3
//  It is guaranteed that a valid answer always exists for each query of type 3 .
//Output Format:
//  For each query of type 3 , print the value of the element at the front of the queue on a new line.


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        int type;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            type = scanner.nextInt();
            switch (type) {
                case 1:
                    deque.addLast(scanner.nextInt());
                    break;
                case 2:
                    if (!deque.isEmpty())
                    deque.poll();
                    break;
                case 3:
                    System.out.println(deque.peekFirst());
                    break;
            }
        }
    }
}
