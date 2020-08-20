package com.gome.createobject;

public class StackOverflowTest {
    static int count=0;
    static void redo(){
        count++;
        redo();
    }
    public static void main(String[] args) {
        try{
            redo();
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println(count);
        }
    }
}
