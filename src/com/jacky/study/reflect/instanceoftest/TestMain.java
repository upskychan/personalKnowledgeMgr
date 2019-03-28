package com.jacky.study.reflect.instanceoftest;

/**
 * 编译器将检查类型向下转型是否合法，如果不合法将抛出异常。向下转换类型前，可以使用instanceof判断。
 * 
 * @author Upsky
 *
 */

class Base { }
class Derived extends Base { }

public class TestMain {
    public static void main(String[] args) {
        Base base = new Derived();
        if (base instanceof Derived) {
            // 这里可以向下转换了
            System.out.println("ok");
        }
        else {
            System.out.println("not ok");
        }
    }
}
