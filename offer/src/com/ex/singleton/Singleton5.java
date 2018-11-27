package com.ex.singleton;

// V5.0: 枚举方法
public enum Singleton5 {
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
        Singleton5.INSTANCE.setId(1);
        Singleton5.INSTANCE.getId();
    }
}
