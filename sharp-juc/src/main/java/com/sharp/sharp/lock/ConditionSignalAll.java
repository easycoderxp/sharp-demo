package com.sharp.sharp.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-24 10:55:20
 */
public class ConditionSignalAll {
    private int number = 0;

    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "---" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "---" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
