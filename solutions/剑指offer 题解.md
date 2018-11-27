# 剑指offer 题解

## 2. 实现单例模式

### 单例模式的好处
单例模式适用于应用中频繁创建的对象，尤其是频繁创建的重量级对象。
例如统一的配置文件。
使用单例模式能够提升性能，减小内存开销。

### 单例模式的实现
#### 1.饿汉式
饿汉式加载类的时候，就会创建类的实例对象，那么如果不用这个单例的话，就会消耗内存，浪费性能。
因此，需要懒加载（lazy-load）

```java
public class Singleton {
    // instance必须是static变量（类变量）
    private static Singleton instance = new Singleton();

    // private无参构造函数: Java会自动为没有明确声明构造函数的类，
    // 定义一个public的无参构造函数，若没有这个private无参构造函数，
    // 外部可以随意new Singleton
    private Singleton() {}

    // getInstance必须是static方法（类方法）
    public static Singleton1 getInstance() {
        return instance;
    }
}
```

#### 2.懒汉式
懒汉式改进了饿汉式的性能问题，但是又带来了一个问题，即线程安全问题。
在多线程的情况下，会出现多个实例，违背了单例模式的原则。

```java
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
```

#### 3.双重校验（双检锁）
双重校验能够保证单例模式的实例唯一性，同时能够兼顾效率和线程安全。

```java
public class Singleton {
    // volatile提供可见性（工作内存的值能立即在主内存中可见），
    // 保证getInstance返回的是初始化完全的对象
    private static volatile Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        // 同步之前进行null检查，避免进入代价相对昂贵的同步块
        if (instance == null) {
            synchronized (Singleton.class) {
                // 持有锁之后进行null检查，避免上一个线程已经初始化变量
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

#### 4.静态内部类
静态内部类的方式实现，可以保证多线程对象的唯一性，同时可以降低双重校验中同步锁机制的代价。
这种方式还有个好处，就是静态内部类不会在单例类加载的时候就加载，而是在调用`getInstance()`
方法时才加载。

```java
public class Singleton {
    private static class SingletonHolder {
        public static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
```

####  5.枚举方法 
枚举方法是由《Effective Java》的作者Josh Bloch提出，其好处在于：
* 自由序列化
* 保证只有一个实例
* 线程安全

```java
public enum Singleton {
    INSTANCE;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        //调用
        Singleton.INSTANCE.setId(1);
        Singleton.INSTANCE.getId();
    }
}
```



## 3.数组中重复的数字

### 3.1 找出数组中重复的数字

在一个长度为n的数组里的所有的数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复，也不知道每个数字重复了几次。请找出数组中任意的一个数字。

例如，输入长度为7的数组{2,3,1,0,2,5,3}，那么对应输出的是重复数字2或者3。

### 3.2 不修改数组找出重复的数字

在一个长度为n+1的数组里的所有的数字都在1~n的范围内，所以数组中至少有一个数字是重复的，请在不修改数组的情形下，找出数组中任意一个重复数字。

例如，输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应输出的是重复数字2或者3。

