package com.ex.singleton;

// V4.0: 静态内部类
public class Singleton4 {
    private static class SingletonHolder {
        public static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }
}
