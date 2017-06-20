package com.example.eowemcn.myapplication.sorting;


import com.example.eowemcn.myapplication.models.Room;

import java.util.Comparator;

public class RoomCapacityComparator implements Comparator {

    @Override
    public int compare(Object o1,Object o2){
        Room r1=(Room)o1;
        Room r2=(Room)o2;

        if (r1.getCapacity()==r2.getCapacity()) {
            return 0;
        } else if (r1.getCapacity()>r2.getCapacity()) {
            return 1;
        } else {
            return -1;
        }
    }
}
