package com.ll.demo.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类说明   : newCachedThreadPool创建一个可缓存线程池，
 * 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 * 作者      :LiLi
 * 日期      :2017/8/9 18:37
 * 版本号    : V1.0
 */
public class TestCachedThreadPool {

    //线程池为无限大，当执行第二个任务时第一个任务已经完成，
    //会复用执行第一个任务的线程，而不用每次新建线程。
    public static void main(String[] args) {
        ExecutorService cached = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cached.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}
