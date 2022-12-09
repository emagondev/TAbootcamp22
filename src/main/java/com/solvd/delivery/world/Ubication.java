package com.solvd.delivery.world;

public class Ubication {


    private double x;
    private double y;
    public Ubication(double x, double y) {
        // TODO Auto-generated constructor stub
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

    public double getDistance(double xDestination, double yDestination) {
        return Math.sqrt((xDestination-this.x)*(xDestination-this.x) + (yDestination-this.y)*(yDestination-this.y));
    }


}
