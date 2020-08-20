package com.gome.classloader;

public class User {
    private String name;
    private int age;
    private String sex;

    public User() {
    }

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void sout(){
        System.out.println("=======自己的加载器加载类调用方法=======");
    }

    public static void main(String[] args) {

    }
}
