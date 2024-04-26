package com.sharp.sharp.lock;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-24 10:48:52
 */
public class WaitSynchronized {
    private int number = 0;

    /**
     * 资源类模拟线程通信问题，必须用while条件判断。因为if不会重新判断，会从wait（）方法继续执行
     *
     * @throws InterruptedException 中断异常
     */
    public synchronized void increment() throws InterruptedException {
        //wait条件使用while,否则可能会有虚假唤醒问题
        while (number != 0) {
            wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "---" + number);
        notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number != 1) {
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "---" + number);
        notifyAll();
    }
}
