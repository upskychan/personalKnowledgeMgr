package com.jacky.study.dataStructure;

import org.junit.Test;

import com.jacky.study.dataStructure.linearTable.LinearTable;
import com.jacky.study.dataStructure.linearTable.SequenceTable;

public class TestDataStructure {
	@Test
	public void testSequenceTable() {
		LinearTable<String> sequenceTable = new SequenceTable<String>(10);
		boolean isEmpty = sequenceTable.isEmpty();
		System.out.println("isEmpty:" + isEmpty);
		sequenceTable.addData("java");
		sequenceTable.addData("c");
		sequenceTable.addData("c++");
		System.out.println("length:"+sequenceTable.getLength());
		System.out.println(sequenceTable.getData(2));
		System.out.println(sequenceTable.getData(3));
		sequenceTable.removeData(1);
		sequenceTable.addData("html");
		sequenceTable.addData(1, "php");
	}

	public void testSequenceTableWithNegativeSize() {
		LinearTable<String> sequenceTable = new SequenceTable<String>(-10);
	}

}
