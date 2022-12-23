package com.solvd.delivery.world;

public class Location {
    private double coordinateX;
    private double coordinateY;

    public Location() {
        coordinateX = 0;
        coordinateY = 0;
    }

    public Location(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double distance(Location l) {
        return Math.sqrt(Math.pow(l.getCoordinateX() - coordinateX, 2) + Math.pow(l.getCoordinateY() - coordinateY, 2));
    }

    @Override
    public String toString() {
        return "Location{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }
}
