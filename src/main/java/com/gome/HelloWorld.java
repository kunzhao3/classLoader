package com.gome;

import com.gome.classloader.User;

public class HelloWorld {
    private User user=new User();

    public static void main(String[] args) {
        int a =0;
        for (int i = 0; i <100 ; i++) {
            a++;
        }
        System.out.println(a);
    }
}
