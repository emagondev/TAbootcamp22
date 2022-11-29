package com.delivery.persons;

import java.util.Objects;

public class Person {

	private String firstName;
	private String lastName;
	private long phone;
	private float wallet;

	public Person() {

	}

	public Person(String firstName, String lastName, long phone, float wallet) {
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

	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return String.format(this.firstName, this.lastName, this.phone, this.wallet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, phone, wallet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& phone == other.phone && Float.floatToIntBits(wallet) == Float.floatToIntBits(other.wallet);
	}

}
