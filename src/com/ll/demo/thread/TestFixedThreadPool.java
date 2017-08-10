package com.ll.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类说明   :newFixedThreadPool 创建一个定长线程池，
 * 可控制线程最大并发数，超出的线程会在队列中等待。
 * 作者      :LiLi
 * 日期      :2017/8/10 14:51
 * 版本号    : V1.0
 */
public class TestFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixed = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixed.execute(new Runnable() {
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
