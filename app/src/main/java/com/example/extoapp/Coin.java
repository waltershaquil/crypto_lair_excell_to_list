package com.example.extoapp;

public class Coin {
    String name;
    double amount;
    double value;

    public Coin(String name, double amount, double value) {
        this.name = name;
        this.amount = amount;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
