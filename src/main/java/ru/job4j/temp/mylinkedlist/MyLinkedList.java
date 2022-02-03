package ru.job4j.temp.mylinkedlist;

import java.util.Arrays;

public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public String toString() {
        int[] result = new int[size];
        int index = 0;
        Node temp = head;

        while (temp != null) {
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }

    public int get(int index) {
        int curIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (curIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                curIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getSize() {
        return size;
    }

    public MyLinkedList oddOrNotArithmetic(MyLinkedList list) {
        MyLinkedList value = new MyLinkedList();
        int count = 0;
        int countBool = 0;
        Node temp = head;
        long start = System.currentTimeMillis();

        while (temp != null) {
            long startBool = System.currentTimeMillis();
            if (temp.getValue() % 2 == 1) {
                long endBool = System.currentTimeMillis();
                countBool = (int) (countBool + endBool - startBool);
                count++;
            }
                temp = temp.getNext();
        }
//        for (int i = 0; i < size; i++) {
//            if (list.get(i) % 2 == 1) {
//                count++;
//            }
//        }
        long end = System.currentTimeMillis();
        value.add(count);
        value.add((int) (end - start));
        value.add(countBool);
        return value;
    }

    public MyLinkedList oddOrNotWithBit(MyLinkedList list) {
        MyLinkedList value = new MyLinkedList();
        int count = 0;
        int countBool = 0;
        Node temp = head;
        long start = System.currentTimeMillis();
        while (temp != null) {
            long startBool = System.currentTimeMillis();
            if ((temp.getValue() & 1) != 0) {
                long endBool = System.currentTimeMillis();
                countBool = (int) (countBool + endBool - startBool);
                count++;
            }
            temp = temp.getNext();
        }
//        for (int i = 0; i < size; i++) {
//            if ((list.get(i) & 1) != 0) {
//                count++;
//            }
//        }
        long end = System.currentTimeMillis();
        value.add(count);
        value.add((int) (end - start));
        value.add(countBool);
        return value;
    }

    private static class Node {

        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
