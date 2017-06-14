package com.example.eowemcn.myapplication.models;

public enum Zone {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private int zone;

    Zone(int zone) {
        this.zone = zone;
    }

    public int getRank() {
        return zone;
    }
}
