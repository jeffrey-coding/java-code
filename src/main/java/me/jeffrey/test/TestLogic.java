package me.jeffrey.test;

public class TestLogic {
    public static void main(String[] args){
        int ia = 3;
        int ib = 2;

        boolean b3 = (++ia == 3 && ++ib == 3);// ①
        System.out.println("b3 = " + b3); //②
        System.out.println("ia = " + ia); //③
        System.out.println("ib = " + ib); //④

        System.out.println("-------------------------------");
        //第一个条件为真后，跳过第二个条件的执行
        boolean b4 = (++ia == 5 || ++ib == 3);//
        System.out.println("b4 = " + b4); //⑥
        System.out.println("ia = " + ia); //⑦
        System.out.println("ib = " + ib); //⑧
    }
}
