package com.jacky.study.dataStructure.linearTable;

/**
 * 顺序线性表.
 * @author chenjie
 * @times 2013-6-5 上午11:31:40
 *
 * @param <T>
 */
public class SequenceTable<T> implements LinearTable<T> {
	private T[] seTable;
	private int length;// 表示线性表长度，元素的个数

	public SequenceTable(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("SequenceTable size must > 0");
		} else {
			this.seTable = (T[]) new Object[size];
			this.length = 0;
		}
	}

	public SequenceTable() {
		this(20);
	}

	@Override
	public boolean isEmpty() {
		return this.length == 0;
	}

	@Override
	public int getLength() {
		return this.length;
	}

	@Override
	public T getData(int index) {
		if (index >= 0 && index < this.length) {
			return (T) this.seTable[index];
		}
		return null;
	}

	@Override
	public T setData(int index, T element) {
		if (index >= 0 && index < this.length && element != null) {
			T oldElement = (T) this.seTable[index];
			this.seTable[index] = element;
			return oldElement;
		}
		return null;
	}

	@Override
	public boolean addData(T element) {
		return addData(this.length, element);// 加到末尾
	}

	@Override
	public boolean addData(int index, T element) {
		if (element == null) {
			return false;
		}
		if (this.length == this.seTable.length) {
			T[] tmp = this.seTable;
			// 以2倍的方式进行扩容
			this.seTable = (T[]) new Object[tmp.length * 2];
			for (int i = 0; i < tmp.length; i++) {
				this.seTable[i] = tmp[i];
			}
		}
		if (index < 0)
			index = 0;// 小于0默认插入到第1个位置
		if (index > this.length) {
			index = this.length;// 大于线性表长度，则默认插入末尾的位置
		}
		// index后面的元素依次后移
		for (int position = this.length - 1; position >= index; position--) {
			this.seTable[position + 1] = this.seTable[position];
		}
		this.seTable[index] = element;
		this.length++;
		return true;
	}

	@Override
	public T removeData(int index) {
		if (this.length != 0 && index >= 0 && index < this.length) {
			T oldData = this.seTable[index];
			// index后面的元素依次前移
			for (int position = index; position < this.length - 1; position++) {
				this.seTable[position] = this.seTable[position + 1];
			}
			this.seTable[this.length - 1] = null;
			this.length--;
			return oldData;
		}
		return null;
	}

	@Override
	public void clearData() {
		if (this.length != 0) {
			for (T t : this.seTable) {
				t = null;
			}
			this.length = 0;
		}
	}

}
