package com.jacky.study.reflect.staticinit;

/**
 * 每个类都会产生一个对应的Class对象，也就是保存在.class文件。
 * 所有类都是在对其第一次使用时，动态加载到JVM的，当程序创建一个对类的静态成员的引用时，就会加载这个类。
 * Class对象仅在需要的时候才会加载，static初始化是在类加载时进行的。
 * 
 * @author Upsky
 *
 */
public class TestMain {
	public static void main(String[] args) {
        System.out.println(XYZ.name);//不会调用XYZ的构造方法
    }
}

class XYZ {
    public static String name = "Jacky";

    static {
        System.out.println("xyz静态块");
    }

    public XYZ() {
        System.out.println("xyz构造了");
    }
}
