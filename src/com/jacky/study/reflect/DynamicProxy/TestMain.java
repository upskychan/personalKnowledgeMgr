package com.jacky.study.reflect.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 代理模式是为了提供额外或不同的操作，而插入的用来替代”实际”对象的对象，这些操作涉及到与”实际”对象的通信，因此代理通常充当中间人角色。
 * Java的动态代理比代理的思想更前进了一步，它可以动态地创建并代理并动态地处理对所代理方法的调用。
 * 在动态代理上所做的所有调用都会被重定向到单一的调用处理器上，它的工作是揭示调用的类型并确定相应的策略。
 * 
 * 通过调用Proxy静态方法Proxy.newProxyInstance()可以创建动态代理，这个方法需要得到一个类加载器，
 * 一个你希望该代理实现的接口列表(不是类或抽象类)，以及InvocationHandler的一个实现类。
 * 动态代理可以将所有调用重定向到调用处理器，因此通常会调用处理器的构造器传递一个”实际”对象的引用，从而将调用处理器在执行中介任务时，将请求转发。
 * 
 * @author Upsky
 *
 */
public class TestMain {
    public static void main(String[] args) {
        RealObject real = new RealObject();
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[] {Interface.class},
                new DynamicProxyHandler(real));
        
        proxy.doSomething();
        proxy.somethingElse("Jacky");
    }
}
