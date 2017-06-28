package com.example.eowemcn.myapplication.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Comparable<Room>, Serializable{
    private int id;
    private String name;
    private Zone zone;
    private int capacity;
    private boolean availability;
    private List<Feature> features = new ArrayList<>();

    public Room(int id, String name, Zone zone, int capacity, boolean availability, List<Feature> features){
        this.id = id;
        this.name = name;
        this.zone = zone;
        this.capacity = capacity;
        this.availability = availability;
        this.features = features;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isAvailable(){
        return this.availability;
    }

    public void setAvailablity(boolean availability){
        this.availability = availability;
    }

    public Zone getZone(){
        return this.zone;
    }

    public void setZone(Zone zone){
        this.zone = zone;
    }

    public int  getCapacity() { return this.capacity; }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return this.name;
    }



    public void addFeature(Feature f){
        features.add(f);
    }

    public List<Feature> getFeatures(){
        return features;
    }



    @Override
    public int compareTo(@NonNull Room o) {
        int capacity1 = this.getCapacity();
        int capacity2 = o.getCapacity();

        if (capacity1 == capacity2) {
            System.out.println(this.name + " has same capacity as " + o.getName());
            return 0;
        } else if (capacity1 > capacity2) {
            System.out.println(this.name + " has more capacity than " + o.getName());
            return -1;
        } else {
            System.out.println(this.name + " has less capacity than " + o.getName());
            return 1;
        }
    }



}
