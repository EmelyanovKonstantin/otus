package ru.emelyanovkonstantin;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        Runnable worker = new Task();
        executor.execute(worker);
        executor.execute(worker);
    }
}