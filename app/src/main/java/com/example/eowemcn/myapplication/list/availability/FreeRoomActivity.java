package com.example.eowemcn.myapplication.list.availability;

import android.app.Activity;
import android.os.Bundle;

import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.models.Room;

import java.util.List;

public class FreeRoomActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freerooms);

        Bundle extras = getIntent().getExtras();

        List<Room> rooms = (List<Room>) extras.getSerializable("allrooms");
    }
}