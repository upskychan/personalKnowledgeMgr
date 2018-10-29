package com.jacky.study.dataStructure.linearTable;

/**
 * 双向链表.
 * 
 * @author chenjie
 * @times 2013-6-4 下午6:10:13
 * 
 * @param <T>
 */
public class DBLinkList<T> implements LinearTable<T> {
	private Node head;
	private Node tail;
	private int size = 0;

	public DBLinkList() {
		this.head = new Node();
		this.tail = null;
	}

	public DBLinkList(T data) {
		this.head = new Node(null, data, null);
		this.tail = this.head;
		this.size++;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getData(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T setData(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addData(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addData(int index, T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T removeData(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearData() {
		// TODO Auto-generated method stub

	}

	class Node {
		public T date;
		public Node pre;
		public Node next;

		public Node() {
		}

		public Node(Node pre, T data, Node next) {
			this.date = data;
			this.pre = pre;
			this.next = next;
		}
	}

}
