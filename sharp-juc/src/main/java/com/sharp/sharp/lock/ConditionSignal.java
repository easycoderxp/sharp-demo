package com.sharp.sharp.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-24 10:56:25
 */
public class ConditionSignal {
    private int flag = 1;
    private final Lock lock = new ReentrantLock();

    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void print3(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + i + "=====" + loop);
            }
            flag = 2;
            c2.signal();

        } finally {
            lock.unlock();
        }
    }

    public void print6(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 0; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + i + "=====" + loop);
            }
            flag = 3;
            c3.signal();

        } finally {
            lock.unlock();
        }
    }

    public void print9(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 0; i < 9; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + i + "=====" + loop);
            }
            flag = 1;
            c1.signal();

        } finally {
            lock.unlock();
        }
    }
}
