package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        // Здесь создайте компаратор на основании анонимного класса.
        Comparator<Attachment> attachmentComparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getSize() - o2.getSize();
            }
        };
        Comparator<String> cmpText2 = (s, anotherString) -> s.compareTo(anotherString);
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpText3 = Comparator.comparingInt(String::length).reversed();

        Comparator<String> cmpDescSize2 = Comparator
                .comparing(String::length).reversed();

        Comparator<String> cmpDescSize = Comparator.comparingInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String l) {
                return l.length();
            }
        }).reversed();
    }
}