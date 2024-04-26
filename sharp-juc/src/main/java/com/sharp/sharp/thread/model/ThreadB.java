package com.sharp.sharp.thread.model;

import java.time.LocalDateTime;

/**
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 17:02:07
 */
public class ThreadB implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("di di da di da " + LocalDateTime.now());
        }
    }
}
