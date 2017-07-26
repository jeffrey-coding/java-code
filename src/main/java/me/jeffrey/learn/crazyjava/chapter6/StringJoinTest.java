package me.jeffrey.learn.crazyjava.chapter6;


public class StringJoinTest {
    public static void main(String[] args) {
        String s1 = "疯狂Java";
        String s2 = "疯狂"+"Java";
        System.out.println(s1 == s2);

        String str1 = "疯狂";
        String str2 = "Java";
        String s3 = str1 + str2;
        System.out.println(s1 == s3);

        final String str3 = "疯狂";
        final String str4 = "Java";
        String s4 = str3 + str4;
        System.out.println(s1 == s4);
    }
}
