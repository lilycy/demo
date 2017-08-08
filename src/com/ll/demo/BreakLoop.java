package com.ll.demo;

/**
 * 类说明   : 跳出多层循环的方法
 * 作者      :LiLi
 * 日期      :2017/8/8 10:29
 * 版本号    : V1.0
 */
public class BreakLoop {
    public static void main(String[] args) {
        test1();
        test2();
    }
    //标记法
    public static void test1() {
        ok:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ";j=" + j);
                if (j == 5) {
                    break ok;
                }
            }
        }
    }
    //自定义变量结合break使用
    public static void test2() {
        boolean ok = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ";j=" + j);
                if (j == 5) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                break;
            }
        }
    }
}
