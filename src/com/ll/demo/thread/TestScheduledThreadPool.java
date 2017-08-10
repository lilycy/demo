package com.ll.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 类说明   :newScheduledThreadPool 创建一个定长线程池，
 * 支持定时及周期性任务执行。
 * 作者      :LiLi
 * 日期      :2017/8/10 15:03
 * 版本号    : V1.0
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThread = Executors.newScheduledThreadPool(3);
        scheduledThread.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
