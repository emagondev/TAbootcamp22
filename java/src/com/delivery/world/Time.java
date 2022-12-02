package com.delivery.world;

public class Time {
	private static int hoursminute;

	public Time(int hoursminute) {
		// Ttime in minutes
		Time.hoursminute = hoursminute;
	}

	public int getHoursminute() {
		return hoursminute;
	}

	public void setHoursminute(int hoursminute) {
		if ((Time.hoursminute + hoursminute) > 1140) {
			Time.hoursminute = hoursminute - 1140;
			Time.hoursminute += hoursminute;
		} else {
			Time.hoursminute += hoursminute;
		}
	}

	public void whatTime() {
		System.out.print((Time.hoursminute / 60) + " hs: ");
	}

}
