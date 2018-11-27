package com.ex.singleton;

// V1.0: 饿汉式
public class Singleton1 {
    // instance必须是static变量（类变量）
    private static Singleton1 instance = new Singleton1();

    // private无参构造函数: Java会自动为没有明确声明构造函数的类，
    // 定义一个public的无参构造函数，若没有这个private无参构造函数，
    // 外部可以随意new Singleton
    private Singleton1() {}

    // getInstance必须是static方法（类方法）
    public static Singleton1 getInstance() {
        return instance;
    }
}
