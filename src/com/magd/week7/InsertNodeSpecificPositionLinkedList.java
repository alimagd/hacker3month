package com.magd.week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class SinglyLinkedListNode2 {
    public int data;
    public SinglyLinkedListNode2 next;

    public SinglyLinkedListNode2(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList2 {
    public SinglyLinkedListNode2 head;
    public SinglyLinkedListNode2 tail;

    public SinglyLinkedList2() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode2(int nodeData) {
        SinglyLinkedListNode2 node = new SinglyLinkedListNode2(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper2 {
    public static void printList(SinglyLinkedListNode2 node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

/*
 * Complete the 'insertNodeAtPosition' function below.
 *
 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
 * The function accepts following parameters:
 *  1. INTEGER_SINGLY_LINKED_LIST llist
 *  2. INTEGER data
 *  3. INTEGER position
 */

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */

public class InsertNodeSpecificPositionLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList2 llist = new SinglyLinkedList2();


        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, llistCount).forEach(i -> {
            try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                llist.insertNode2(llistItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int data = Integer.parseInt(bufferedReader.readLine().trim());

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode2 llist_head = insertNodeAtPosition2(llist.head, data, position);

//        SinglyLinkedListPrintHelper.printList(llist_head, " ", bufferedWriter);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static SinglyLinkedListNode2 insertNodeAtPosition2(SinglyLinkedListNode2 llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode2 node = new SinglyLinkedListNode2(data);

        if (llist == null || position == 0) {
            node.next = llist;
            return node;
        }
        SinglyLinkedListNode2 preNode = null;
        SinglyLinkedListNode2 posNode = llist;

        while (position > 0) {
            preNode = posNode;
            posNode = posNode.next;
            position--;
        }
        assert preNode != null;
        preNode.next = node;
        node.next = posNode;

        while (llist != null) {
            System.out.print(" "+llist.data);
            llist = llist.next;
        }
        return llist;

    }
}

