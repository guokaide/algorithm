package com.ex.singleton;

// V3.0: 双重校验
public class Singleton3 {
    // volatile提供可见性（工作内存的值能立即在主内存中可见），
    // 保证getInstance返回的是初始化完全的对象
    private static volatile Singleton3 instance = null;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        // 同步之前进行null检查，避免进入代价相对昂贵的同步块
        if (instance == null) {
            synchronized (Singleton3.class) {
                // 持有锁之后进行null检查，避免上一个线程已经初始化变量
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
