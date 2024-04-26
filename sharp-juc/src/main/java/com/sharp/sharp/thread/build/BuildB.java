package com.sharp.sharp.thread.build;

import com.sharp.sharp.thread.model.ThreadB;

/**
 * 实现Runnable接口
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 17:03:23
 */
public class BuildB {
    public static void main(String[] args) {
        //相比较A,更多使用BuildB。没有类的单继承局限性且适合处理多个线程共享数据的情况
        ThreadB b = new ThreadB();
        //仍然是使用Thread构造器调用start方法
        Thread myThread = new Thread(b);
        myThread.start();
    }
}
