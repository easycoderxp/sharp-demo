package com.sharp.sharp.thread.build;

import com.sharp.sharp.thread.model.ThreadB;

import java.util.concurrent.*;

/**
 * 使用线程池
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 17:30:22
 */
public class BuildD {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2, 6, 50L, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ThreadB());
        }

    }
}
