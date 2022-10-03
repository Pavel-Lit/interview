package ru.geekbrains.homework.lesson_3;

public class PingPong {
    private final Object monitor = new Object();
    private volatile String printedWord ="ping";

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Thread ping = new Thread(pingPong::printPing);
        Thread pong = new Thread(pingPong::printPong);
        ping.start();
        pong.start();
    }

    private void printPing(){
        synchronized (monitor){
            for (int i = 0; i < 10; i++) {
                while(printedWord != "ping"){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("ping");
                monitor.notify();
                printedWord ="pong";
            }

        }
    }
    private void printPong(){
        synchronized (monitor){
            for (int i = 0; i < 10; i++) {
                while(printedWord != "pong"){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("pong");
                monitor.notify();
                printedWord ="ping";
            }

        }
    }
}
