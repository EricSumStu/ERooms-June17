package com.example.eowemcn.myapplication.models;

/**
 * Created by ezgleeo on 19/06/2017.
 */

public enum Feature {
    TV("Television"),
    Projector("Projector"),
    WB("Whiteboard");


    private String featureName;

    Feature(String featureName) {
        this.featureName = featureName;
    }

    public String toString() {
        return featureName;
    }
}


