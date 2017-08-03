package com.ll.demo.produce;

/**
 * 采用synchronized锁以及wait notify方法实现
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        Person person = new Person();
        new Thread(new Consumer(person, "消费者一")).start();
        new Thread(new Consumer(person, "消费者二")).start();
        new Thread(new Consumer(person, "消费者三")).start();

        new Thread(new Producer(person, "生产者一")).start();
        new Thread(new Producer(person, "生产者二")).start();
        new Thread(new Producer(person, "生产者二")).start();
    }

    public static class Producer implements Runnable {
        private  Person person;
        private String produceName;

        public Producer(Person person, String produceName) {
            this.person = person;
            this.produceName = produceName;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    person.produce();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        private Person person;
        private String consumeName;

        public Consumer(Person person, String consumeName) {
            this.person = person;
            this.consumeName = consumeName;
        }

        @Override
        public void run() {
            try {
                person.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static class Person
    {
        private int foodNum = 0;
        private Object synObj = new Object();
        private final int MAX_NUM = 5;

        public void produce() throws InterruptedException {
            synchronized (synObj) {
                while (foodNum == 5) {
                    System.out.println("box is full，size = " + foodNum);
                    synObj.wait();
                }
                foodNum++;
                System.out.println("produce success foodNum = " + foodNum);
                synObj.notifyAll();
            }
        }

        public void consume() throws InterruptedException {
            synchronized (synObj) {
                while (foodNum == 0) {
                    System.out.println("box is empty,size = " + foodNum);
                    synObj.wait();
                }
                foodNum--;
                System.out.println("consume success foodNum = " + foodNum);
                synObj.notifyAll();
            }

        }
    }
}
