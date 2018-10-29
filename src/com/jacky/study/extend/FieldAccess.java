package com.jacky.study.extend;

/**
 * 域和静态方法都不具有多态性.
 * 
 * @author chenjie
 * @times 2014-2-13 上午9:59:54
 * 
 */
public class FieldAccess {
	public static void main(String[] args) {
		Super sup = new Super();
		System.out.println("sup.field = " + sup.field + ", sup.getField() = "
				+ sup.getField());

		Super supSub = new Sub();
		System.out.println("supSub.field = " + supSub.field
				+ ", supSub.getField() = " + supSub.getField());

		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + ", sub.getField() = "
				+ sub.getField() + ", sub.getSuperField() = "
				+ sub.getSuperField());

		// sup.field = 0, sup.getField() = 0
		// supSub.field = 0, supSub.getField() = 1
		// sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0
	}
}

class Super {
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;

	public int getField() {
		return field;
	}

	public int getSuperField() {
		return super.field;
	}
}
