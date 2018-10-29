package com.jacky.study.dataStructure.linearTable;

/**
 * 线性表.
 * 
 * @author chenjie
 * @times 2013-5-8 上午11:15:36
 * 
 */
public interface LinearTable<T> {
	// 判空
	public boolean isEmpty();

	// 获取长度
	public int getLength();

	// 返回某个位置的元素
	public T getData(int index);

	// 设置index位置的元素，并返回先前的元素
	public T setData(int index, T element);

	// 插入一个元素，位置没有限定(插入链表尾部)
	public boolean addData(T element);

	// 在指定的位置插入一个元素
	public boolean addData(int index, T element);

	// 删除某个位置的元素，并返回该元素
	public T removeData(int index);

	// 清空线性表
	public void clearData();
}
