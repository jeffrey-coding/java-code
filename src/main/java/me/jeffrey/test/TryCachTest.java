package me.jeffrey.test;

public class TryCachTest {
    // catch 工作
    public static String catchMethod() {
        System.out.println("catchMethod is running ==1==");
        return "catch method";
    }

    // finally工作
    public static String finallyMethod() {
        System.out.println("finallyMethod is running ==2==");
        return "finally method";
    }

    // return 工作
    public static String returnMethod(String methodName){
        System.out.println( methodName + " call returnMethod is running ==3==");
        return "=" + methodName;
    }

    public static String catchTest() {
        System.out.println("====catchTest=====");
        try {
            int i = 10 / 0;   // 抛出 Exception，后续处理被拒绝
            System.out.println("i vaule is : " + i);
            return returnMethod("catchTest");    // Exception 已经抛出，没有获得被执行的机会
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            return catchMethod();    // Exception 抛出，获得了调用方法并返回方法值的机会
        }
    }

    public static String catchFinallyTest1() {
        System.out.println("=========");
        System.out.println("catchFinallyTest1");
        try {
            int i = 10 / 0; // 抛出 Exception，后续处理被拒绝
            System.out.println("i vaule is : " + i);
            return returnMethod("catchFinallyTest1");   // Exception 已经抛出，没有获得被执行的机会
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            return catchMethod();  // Exception 抛出，获得了调用方法的机会，但方法值在 finally 执行完后才返回
        } finally {
            finallyMethod();  // Exception 抛出，finally 代码块将在 catch 执行 return 之前被执行
        }
    }

    public static String catchFinallyTest2() {
        System.out.println("=========");
        System.out.println("catchFinallyTest2");
        try {
            int i = 10 / 2; // 不抛出 Exception
            System.out.println("i vaule is : " + i);
            return returnMethod("catchFinallyTest2");
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            return catchMethod();  // Exception 抛出，获得了调用方法的机会，但方法值在 finally 执行完后才返回
        } finally {
            finallyMethod();  // Exception 抛出，finally 代码块将在 catch 执行 return 之前被执行
        }
    }

    public static String catchFinallyTest3() {
        System.out.println("=========");
        System.out.println("catchFinallyTest3");
        try {
            int i = 10 / 2;  // 不抛出 Exception
            System.out.println("i vaule is : " + i);
            return returnMethod("catchFinallyTest3");   // 获得被执行的机会，但执行需要在 finally 执行完成之后才能被执行
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            return catchMethod();
        } finally {
            return finallyMethod();  // finally 中含有 return 语句，这个 return 将结束这个方法，不会在执行完之后再跳回 try 或 catch 继续执行，方法到此结束，返回 false
        }
    }

    public static String catchFinallyTest4() {
        System.out.println("=========");
        System.out.println("catchFinallyTest4");
        try {
            int i = 10 / 0;  // 抛出 Exception，后续处理被拒绝
            System.out.println("i vaule is : " + i);    // Exception 已经抛出，没有获得被执行的机会
            return returnMethod("catchFinallyTest4");
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            return catchMethod();
        } finally {
            return finallyMethod();     // finally 中含有 return 语句，这个 return 将结束这个方法，不会在执行完之后再跳回 try 或 catch 继续执行，方法到此结束，返回 false
        }
    }

    public static String catchFinallyTest5() {
        System.out.println("=========");
        System.out.println("catchFinallyTest5");
        try {
            int i = 10 / 2;  // 不抛出 Exception
            System.out.println("i vaule is : " + i);
            System.exit(0);
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            return catchMethod();
        } finally {
            return finallyMethod();  // finally 中含有 return 语句，这个 return 将结束这个方法，不会在执行完之后再跳回 try 或 catch 继续执行，方法到此结束，返回 false
        }
    }


    public static void main(String[] args) {
        System.out.println(catchTest());
        System.out.println(catchFinallyTest1());
        System.out.println(catchFinallyTest2());
        System.out.println(catchFinallyTest3());
        System.out.println(catchFinallyTest4());
        System.out.println(catchFinallyTest5());
    }


}
