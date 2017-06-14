package com.example.eowemcn.myapplication.models;

public class Room {
    private String name;
    private Zone zone;
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

    public String toString() {
        return this.name;
    }
}
