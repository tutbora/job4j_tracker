package ru.job4j.temp.serialize;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Tom");
        Person person2 = new Person(2, "Jerry");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.bin"))) {
            oos.writeObject(person1);
            oos.writeObject(person2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
