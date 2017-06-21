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

    public static List<Room> convertJSON(JSONObject jObject) throws JSONException {
        // Create a new list of Rooms (to fill)
        List<Room> rooms = new ArrayList<>();
        // Get rooms array from file
        JSONArray jsonRooms = jObject.getJSONArray("rooms");

        // Go through all the rooms in the JSONArray
        for (int i=0; i < jsonRooms.length(); i++) {
            // Get the Individual JSON room
            JSONObject jsonRoom = jsonRooms.getJSONObject(i);
            Log.d("JSON Processing", "Processing room: " + jsonRoom.getString("name"));

            String name = jsonRoom.getString("name"); // Get the room name
            Zone zone = Zone.getZone(jsonRoom.getInt("zone"));
            int capacity = jsonRoom.getInt("capacity");
            boolean available = jsonRoom.getBoolean("available");

            List<Feature> features = new ArrayList<>();
            try {
                JSONArray jsonFeatures = jsonRoom.getJSONArray("features");
                for (int x = 0; x < jsonFeatures.length()-1; x++) {
                    JSONObject featureObj = jsonFeatures.getJSONObject(x);
                    Feature feature = Feature.getFeature(featureObj.getString("type"));
                    int count = featureObj.getInt("number");
                    for (int y = 0; y < count; y++) {
                        features.add(feature);
                    }
                }
            }catch (JSONException e){
                Log.d("JSON Processing", "No Features for room: " + name);
            }
            Room room = new Room(name, zone, capacity, available, features); // Create a new Room
            rooms.add(room);
        }
        return rooms;
    }

}
