package com.example.eowemcn.myapplication.json;


import android.util.Log;

import com.example.eowemcn.myapplication.models.Room;
import com.example.eowemcn.myapplication.tasks.PutRoomStatusTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RoomToJSONConverter {
    private static final String TAG = RoomToJSONConverter.class.getName();

    public static JSONObject convertRoomToJSON(Room room) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", room.getId());
        jsonObject.put("name", room.getName());
        jsonObject.put("zone", String.valueOf(room.getZone().getIntValue()));
        jsonObject.put("capacity", room.getCapacity());
        jsonObject.put("available", room.isAvailable());

        Log.d(TAG, "Converted room: " + room.getName() + " to JSON: " + jsonObject.toString());

        return jsonObject;
    }

    public static JSONArray convertRoomsToJSON(List<Room> rooms) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for(Room r : rooms){
            JSONObject jsonRoom = convertRoomToJSON(r);
            jsonArray.put(jsonRoom);
        }

        return jsonArray;
    }
}
