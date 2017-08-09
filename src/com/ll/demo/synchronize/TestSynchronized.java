package com.ll.demo.synchronize;

/**
 * 类说明   : Synchronized和Static Synchronized区别
 * 作者      :LiLi
 * 日期      :2017/8/9 17:54
 * 版本号    : V1.0
 */
public class TestSynchronized {
    public synchronized void test1() {
        int i = 5;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while( i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized myt2 = new TestSynchronized();
        //可以同步执行
        //Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
        //Thread test2 = new Thread(  new Runnable() {  public void run() { TestSynchronized.test2();   }  }, "test2"  );
        //test1.start();
        //test2.start();
        //不可以同步执行
        //Thread test3 = new Thread(  new Runnable() {  public void run() {  TestSynchronized.test2();  }  }, "test3"  );
        //Thread test4 = new Thread(  new Runnable() {  public void run() { TestSynchronized.test2();   }  }, "test4"  );
        //test3.start();
        //test4.start();
        //不可以同步执行
        //Thread test5 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test5"  );
        //Thread test6 = new Thread(  new Runnable() {  public void run() { myt2.test1();   }  }, "test6"  );
        //test5.start();
        //test6.start();
        //可以同步执行
        final TestSynchronized myt3 = new TestSynchronized();
        Thread test7 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test7"  );
        Thread test8 = new Thread(  new Runnable() {  public void run() { myt3.test1();   }  }, "test8"  );
        test7.start();
        test8.start();
    }
}
