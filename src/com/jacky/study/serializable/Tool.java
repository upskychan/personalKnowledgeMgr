package com.jacky.study.serializable;

import java.io.Serializable;

public class Tool implements Serializable {
	private static final long serialVersionUID = 1L;
	private String toolName;

	/**
	 * @return the toolName
	 */
	public String getToolName() {
		return toolName;
	}

	/**
	 * @param toolName
	 *            the toolName to set
	 */
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
}
