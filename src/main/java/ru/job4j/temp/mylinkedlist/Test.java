package ru.job4j.temp.mylinkedlist;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList myLinkedListSimple = new MyLinkedList();

        fillRandomList(myLinkedList, 1000);
        var notBit = myLinkedList.oddOrNotArithmetic();
        var bit = myLinkedList.oddOrNotWithBit();
        System.out.println(notBit);
        System.out.println(bit);

        fillStraightRow(myLinkedListSimple, 1000);
        var notBitSimple = myLinkedListSimple.oddOrNotArithmetic();
        var bitSimple = myLinkedListSimple.oddOrNotWithBit();
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
