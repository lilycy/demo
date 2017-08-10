package com.ll.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类说明   :newSingleThreadExecutor 创建一个单线程化的线程池，
 * 它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * 作者      :LiLi
 * 日期      :2017/8/10 15:27
 * 版本号    : V1.0
 */
public class TestSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
