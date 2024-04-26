package com.sharp.sharp.thread.build;

import com.sharp.sharp.thread.model.ThreadC;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现callable接口
 *
 * @author xiap0308
 * @version v1.0.0
 * @since 2024-04-22 17:16:45
 */
public class BuildC {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadC c = new ThreadC();
        //callable 接口实现类作为参数构造futureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(c);
        new Thread(futureTask, "ThreadC").start();
        int result;
        while (!futureTask.isDone()) {
            System.out.println("wait");
        }
        result = futureTask.get();
        System.out.println(result);
        System.out.println("Callable end");
    }
}
