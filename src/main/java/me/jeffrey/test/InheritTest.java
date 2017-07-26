package me.jeffrey.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * 测试继承特性
 * Created by jeffreysun on 2017/7/20.
 */

class Base{

    /**
     * 打印类名
     */
    void printClassName1(){
        System.out.println(this.getClass().getName());
    }

    /**
     * 打印缓存类名
     */
    private String className = this.getClass().getName();
    void printClassName2(){
        System.out.println(className);
    }
}

class Children1 extends Base{
    /**
     * 测试打印类名
     */
    void test1(){
        printClassName1();
        printClassName2();
    }
}

class Children2 extends Base{
    /**
     * 测试打印类名
     */
     void test1(){
        printClassName1();
        printClassName2();

    }
}

public class InheritTest extends Base {

    /**
     * 测试类型获取
     */
     private void test1(){
        Children1 child1 = new Children1();
        Children2 child2 = new Children2();
        child1.test1();
        child2.test1();
    }

    public static void main(String[] args) {
//        InheritTest test = new InheritTest();
//        test.test1();

        String c = "4c65616b7363616e3a205453542854656e63656e74205365637572697479205465616d290d0a4163636570743a20746578742f68746d6c2c6170706c69636174696f6e2f7868746d6c2b786d6c2c6170706c69636174696f6e2f786d6c3b713d302e" +
                "2a3b713d302e380d0a557365722d4167656e743a204d6f7a696c6c612f352e30202857696e646f7773204e5420362e3129204170706c";

        byte[] ser = new byte[0];
        try {
            ser = Hex.decodeHex(c.toCharArray());
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        System.out.println(new String(ser));

    }
}
