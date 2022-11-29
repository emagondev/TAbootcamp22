package com.delivery.world;

public class Time {
	private int hoursminute;

	public Time(int hoursminute) {
		// Ttime in minutes
		this.hoursminute = hoursminute;
	}

	public int getHoursminute() {
		return hoursminute;
	}

	public void setHoursminute(int hoursminute) {
		if ((this.hoursminute + hoursminute) > 1140) {
			this.hoursminute = hoursminute - 1140;
			this.hoursminute += hoursminute;
		} else {
			this.hoursminute += hoursminute;
		}
	}

	public void whatTime() {
		System.out.print((this.hoursminute / 60) + " hs: ");
	}

}
