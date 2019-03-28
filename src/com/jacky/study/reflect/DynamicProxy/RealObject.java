package com.jacky.study.reflect.DynamicProxy;

public class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething.");
    }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
