package com.ll.demo.produce;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 类说明   : BlockingQueue解决生产者/消费者
 * 作者      :LiLi
 * 日期      :2017/8/3 16:44
 * 版本号    : V1.0
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
        // BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        //不设置的话，LinkedBlockingQueue默认大小为Integer.MAX_VALUE

        // BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        for (int i = 0; i < 5; i++) {
            new Thread(producer, "Producer" + (i + 1)).start();

            new Thread(consumer, "Consumer" + (i + 1)).start();
        }
    }

    public static class Producer implements Runnable {
        BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String temp = "A Product, 生产线程："
                        + Thread.currentThread().getName();
                System.out.println("I have made a product:"
                        + Thread.currentThread().getName());
                queue.put(temp);//如果队列是满的话，会阻塞当前线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Consumer implements Runnable{
        BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String temp = queue.take();//如果队列为空，会阻塞当前线程
                System.out.println(temp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
