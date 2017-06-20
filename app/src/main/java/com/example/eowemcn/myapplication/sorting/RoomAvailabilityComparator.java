package com.example.eowemcn.myapplication.sorting;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.eowemcn.myapplication.models.Room;

import java.util.Comparator;

public class RoomAvailabilityComparator implements Comparator {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int compare(Object o1,Object o2){
        Room r1=(Room)o1;
        Room r2=(Room)o2;

        return Boolean.compare(r1.isAvailable(), r2.isAvailable());
    }
}
