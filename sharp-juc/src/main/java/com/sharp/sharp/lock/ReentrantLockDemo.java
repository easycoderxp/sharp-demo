package com.sharp.sharp.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-24 10:53:36
 */
public class ReentrantLockDemo {
    private int number = 30;

    private final ReentrantLock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "-sale-" + (number--) + "--have--" + (number));
            }
        } finally {
            lock.unlock();
        }
    }
}
