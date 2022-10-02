package ru.geekbrains.homework.lesson_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCounter {

    private Lock lock = new ReentrantLock();

    private int value = 0;

    private int maxValue = 20;

    private int threadValue = 5;


    public int getValue() {
        return value;
    }

    public void incrementByThread(){
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadValue; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j<maxValue/threadValue; j++){
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() +"="+value);
                        value++;
                        lock.unlock();
                    }
                }
            });
            threads.add(thread);
        }

        for (Thread t: threads) {
            t.start();
        }
        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


    public static void main(String[] args) throws InterruptedException {
        ThreadCounter counter = new ThreadCounter();
        counter.incrementByThread();
        System.out.println(counter.getValue());
    }
}
