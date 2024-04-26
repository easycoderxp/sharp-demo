package com.sharp.sharp.thread.build;

import com.sharp.sharp.thread.model.ThreadA;

/**
 * 继承Thread类，重写run方法
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 16:58:58
 */
public class BuildA {
    public static void main(String[] args) {
        new ThreadA().start();
    }
}
