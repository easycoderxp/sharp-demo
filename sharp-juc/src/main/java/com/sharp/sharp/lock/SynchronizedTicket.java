package com.sharp.sharp.lock;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-24 10:41:52
 */
public class SynchronizedTicket {
    private int number = 30;

    /**
     * synchronized对方法加锁，锁是当前实例对象
     * 避免多个线程同时对number操作，导致数量异常问题
     */
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "-sale-" + (number--) + "--have--" + (number));
        }
    }
}
