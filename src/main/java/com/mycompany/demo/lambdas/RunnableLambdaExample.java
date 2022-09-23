package com.mycompany.demo.lambdas;

public class RunnableLambdaExample {
    public static void main(String[] args) {

        // Java 8 prior
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Inside runnable 1");
            }

        };
        new Thread(runnable).start();

        // Java 8 lambda
        Runnable runnableLambda = () -> {
            System.out.println("Inside runnable 2");
        };
        new Thread(runnableLambda).start();

        Runnable runnableLambda1 = () -> System.out.println("Inside runnable 3");
        new Thread(runnableLambda1).start();

        new Thread(() -> System.out.println("Inside runnable 4")).start();
    }

}
