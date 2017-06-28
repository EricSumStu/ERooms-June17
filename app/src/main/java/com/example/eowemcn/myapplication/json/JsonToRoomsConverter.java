package com.example.eowemcn.myapplication.json;

import android.util.Log;

import com.example.eowemcn.myapplication.models.Feature;
import com.example.eowemcn.myapplication.models.Room;
import com.example.eowemcn.myapplication.models.Zone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonToRoomsConverter {

    public static List<Room> convertJSON(JSONArray jsonRooms) throws JSONException {
        // Create a new list of Rooms (to fill)
        List<Room> rooms = new ArrayList<>();

        // Go through all the rooms in the JSONArray
        for (int i=0; i < jsonRooms.length(); i++) {
            // Get the Individual JSON room
            JSONObject jsonRoom = jsonRooms.getJSONObject(i);
            Log.d("JSON Processing", "Processing room: " + jsonRoom.toString());
            Room room;
            try {
                int id = jsonRoom.getInt("id"); // Get the room name
                String name = jsonRoom.getString("name"); // Get the room name
                Zone zone = Zone.getZone(jsonRoom.getInt("zone"));
                int capacity = jsonRoom.getInt("capacity");
                boolean available = jsonRoom.getBoolean("available");

                // Features
                List<Feature> features = new ArrayList<>();
                convertStringToFeature(name, jsonRoom.getString("features1"), features);
                convertStringToFeature(name, jsonRoom.getString("features2"), features);
                convertStringToFeature(name, jsonRoom.getString("features3"), features);

                room = new Room(id, name, zone, capacity, available, features); // Create a new Room
                rooms.add(room);
            }catch (JSONException e){
                Log.e("JSON Processing", "Error for room: " + jsonRoom.toString());
            }
        }
        return rooms;
    }

    private static void convertStringToFeature(String name, String feature, List<Feature> list){
        if(feature != null && !feature.isEmpty()){
            try{
                Feature f = Feature.getFeature(feature);
                list.add(Feature.getFeature(feature));
            }catch(IllegalArgumentException e){
                Log.e("JSON Processing", "Cannot convert: " + feature + " to a feature for room: " + name);
            }
        }
    }

}
