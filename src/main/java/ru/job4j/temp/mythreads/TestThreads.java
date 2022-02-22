package ru.job4j.temp.mythreads;

public class TestThreads {

    public static void main(String[] args) {

        MyThreads myThreads0 = new MyThreads();
        myThreads0.start();

        MyThreads myThreads1 = new MyThreads();
        myThreads1.start();
    }
}

class MyThreads extends Thread {

    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println("Hello from thread " + i);
        }
    }
}