package ru.emelyanovkonstantin;

class Task implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for(int i = 0; i < 10; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": " + i);
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for(int i = 10; i >= 0; i--) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": " + i);
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}