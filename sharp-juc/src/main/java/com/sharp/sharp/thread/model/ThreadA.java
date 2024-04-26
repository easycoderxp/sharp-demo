package com.sharp.sharp.thread.model;

import java.time.LocalDateTime;

/**
 * 继承Thread类重写run方法
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 16:55:42
 */
public class ThreadA extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("di di da di da " + LocalDateTime.now());
        }
    }
}
