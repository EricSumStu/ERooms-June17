package com.example.eowemcn.myapplication.sorting;

import com.example.eowemcn.myapplication.models.Room;

import java.util.Comparator;

public class RoomNameComparator implements Comparator {

    @Override
    public int compare(Object o1,Object o2){
        Room room1 = (Room)o1;
        Room room2 = (Room)o2;

        return room1.getName().compareTo(room2.getName());
    }
}
