package com.mycompany.demo.functionalInterfaces;

public class FunctionExample1 {

    static String performConcat(String str) {
        return FunctionExample.addSomeString.apply(str);

    }

    public static void main(String[] args) {
        String result = performConcat("Hello");
        System.out.println(result);
    }
}
