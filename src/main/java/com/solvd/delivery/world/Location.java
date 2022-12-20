package com.solvd.delivery.world;

public class Location {
    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Location l) {
        return Math.sqrt(Math.pow(l.getX() - x, 2) + Math.pow(l.getY() - y, 2));
    }
}
