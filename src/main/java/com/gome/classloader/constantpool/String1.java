package com.gome.classloader.constantpool;

public class String1 {
    static String s1 = "Hello";
    static String s2 = "Hello";
    static String s3 = "Hel" + "lo";
    static String s4 = "Hel" + new String("lo");
    static String s5 = new String("Hello");
    static String s6 = s5.intern();
    static String s7 = "H";
    static String s8 = "ello";
    static String s9 = "H" + "ello";
    static String s10 = s7+s8;
    public static void main(String[] args) {

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // true
        System.out.println(s1 == s10);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true
    }
}
