package com.example.eowemcn.myapplication.sorting;


import com.example.eowemcn.myapplication.models.Room;

import java.util.Comparator;

public class RoomZoneComparator implements Comparator {

    @Override
    public int compare(Object o1,Object o2){
        Room room1 = (Room)o1;
        Room room2 = (Room)o2;
        int r1 = room1.getZone().getIntValue();
        int r2 = room2.getZone().getIntValue();

        if (r1==r2) {
            return 0;
        } else if (r1>r2) {
            return 1;
        } else {
            return -1;
        }
    }
}
