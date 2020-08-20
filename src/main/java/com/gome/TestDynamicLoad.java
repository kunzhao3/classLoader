package com.gome;

public class TestDynamicLoad {
    static {
        System.out.println("========TestDynamicLoad code===========");
    }

    public static void main(String[] args) {
        A a=new  A();
        System.out.println("=======load test=========");
        B b=null;
    }
}
