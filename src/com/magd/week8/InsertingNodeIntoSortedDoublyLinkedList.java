package com.magd.week8;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertingNodeIntoSortedDoublyLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

        /*
         * Complete the 'sortedInsert' function below.
         *
         * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_DOUBLY_LINKED_LIST llist
         *  2. INTEGER data
         */

        /*
         * For your reference:
         *
         * DoublyLinkedListNode {
         *     int data;
         *     DoublyLinkedListNode next;
         *     DoublyLinkedListNode prev;
         * }
         *
         */

        public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
            // Write your code here
            DoublyLinkedListNode tmpNode = new DoublyLinkedListNode(data);
//            if (llist == null) {
//                return tmpNode;
//            }

            DoublyLinkedListNode prevNode = null;
            DoublyLinkedListNode nextNode = llist;
            while (nextNode != null) {
                if (nextNode.data > data) {
                    break;
                }

                prevNode = nextNode;
                nextNode = nextNode.next;
            }

            if (prevNode != null) {
                prevNode.next = tmpNode;
            } else {
                llist = tmpNode;
            }

            if (nextNode != null) {
                nextNode.prev = tmpNode;
            }

            tmpNode.prev = prevNode;
            tmpNode.next = nextNode;

            return llist;
/////////////////////////////////////////////////////////
//            DoublyLinkedList dblist = new DoublyLinkedList();
//            DoublyLinkedListNode tmp = new DoublyLinkedListNode(llist.data);
//            while (llist != null) {
//                if (llist.data < data) {
//                    dblist.insertNode(llist.data);
//                    // llist = llist.next;
//                } else {
//                    dblist.insertNode(data);
//                    data = llist.data;
//                    // llist = llist.next;
//                }
//                tmp = llist;
//                // tmp.prev = llist.prev;
//                tmp.next = llist.next;
//                llist = llist.next;
//                llist.prev = tmp;
//            }
//            return dblist.head;
//////////////////////////////////////////////////////////////
        }
            private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

//            printDoublyLinkedList(llist1, " ", bufferedWriter);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}


