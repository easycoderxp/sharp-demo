package com.sharp.sharp.thread.model;

import java.util.concurrent.Callable;

/**
 * 实现Callable接口 可以抛出异常，返回线程执行结果
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 17:13:29
 */
public class ThreadC implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable Integer");
        Thread.sleep(3000);
        return 1024;
    }
}
