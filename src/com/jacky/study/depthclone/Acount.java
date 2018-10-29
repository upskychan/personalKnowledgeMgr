package com.jacky.study.depthclone;

public class Acount implements Cloneable {
	private User user;
	private long balance;

	public Acount clone() throws CloneNotSupportedException {
		Acount acount = (Acount) super.clone();
		if (user != null) {
			acount.setUser(user.clone());
		}
		return acount;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}
}
