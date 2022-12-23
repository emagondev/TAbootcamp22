package com.solvd.delivery.interfaces;

public interface IPay {

    final int pricePerMeter = 20;

    float calculatePrice(double distance, int tier);

    //add weight TO-DO
    void getPaid(float cash);

    void pay(float cash);
}
