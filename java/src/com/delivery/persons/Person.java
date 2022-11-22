package com.delivery.persons;

public class Person {

	private String firstName;
	private String lastName;
	private long phone;
	private long wallet;

	public Person() {

	}

	public Person(String firstName, String lastName, long phone, long wallet) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.wallet = wallet;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getWallet() {
		return wallet;
	}

	public void setWallet(long wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return String.format(this.firstName, this.lastName, this.phone, this.wallet);
	}

}
