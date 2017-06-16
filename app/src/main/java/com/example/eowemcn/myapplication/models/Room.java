package com.example.eowemcn.myapplication.models;

import android.support.annotation.NonNull;

import java.util.Comparator;

public class Room implements Comparable<Room>{
    private String name;
    private Zone zone;
    private Integer capacity;
    private boolean availability;

    public Room(String name){
        this.name = name;
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

    public Integer  getCapacity() { return this.capacity; }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public String toString() {
        return this.name;
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
