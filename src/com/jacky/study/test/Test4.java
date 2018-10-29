package com.jacky.study.test;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
	public static long index = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(index,"1");
		for(int i=0;i<5;i++){
			Node nodes1 = new Node(index,root.getName()+"_"+i);
			root.getChildren().add(nodes1);
			for(int j=0;j<5;j++){
				Node nodes2 = new Node(index,nodes1.getName()+"_"+j);
				nodes1.getChildren().add(nodes2);
				for(int k=0;k<6;k++){
					Node nodes3 = new Node(index,nodes2.getName()+"_"+j);
					nodes2.getChildren().add(nodes3);
				}
			}
		}
		System.out.println(root);
	}

}

class Node {
	private Long id;
	private String name;
	private List<Node> children = new ArrayList<Node>();
	
	public Node(long id,String name){
		Test4.index++;
		this.id = id;
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}



	/**
	 * @return the children
	 */
	public List<Node> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
