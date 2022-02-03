package ru.job4j.temp.mylinkedlist;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList myLinkedListSimple = new MyLinkedList();
//        myLinkedList.add(1);
//        myLinkedList.add(2);
//        myLinkedList.add(3);
//        myLinkedList.add(4);
//        myLinkedList.add(5);
//        myLinkedList.add(6);

        fillRandomList(myLinkedList, 100000);
        var notBit = myLinkedList.oddOrNotArithmetic(myLinkedList);
        var bit = myLinkedList.oddOrNotWithBit(myLinkedList);
        System.out.println(notBit);
        System.out.println(bit);

        fillStraightRow(myLinkedListSimple, 100000);
        var notBitSimple = myLinkedListSimple.oddOrNotArithmetic(myLinkedListSimple);
        var bitSimple = myLinkedListSimple.oddOrNotWithBit(myLinkedListSimple);
        System.out.println(notBitSimple);
        System.out.println(bitSimple);
    }

    public static void fillRandomList(MyLinkedList list, int limit) {
        while (list.getSize() < limit) {
            Random rand = new Random();
            list.add(rand.nextInt(10));
        }
    }

    public static void fillStraightRow(MyLinkedList list, int limit) {
        for (int i = 0; i < limit; i++) {
            list.add(i);
        }
    }
}
