package com.example.eowemcn.myapplication.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.json.JsonToRoomsConverter;
import com.example.eowemcn.myapplication.json.ReadJSONFromServer;
import com.example.eowemcn.myapplication.models.Room;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

public class RetrieveRoomsJSONTask extends AsyncTask<String, String, List<Room>> {
    private final Context context;
    private ProgressDialog pDialog;
    
        public RetrieveRoomsJSONTask(Context context){
            this.context = context;
        }
    
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected List<Room> doInBackground(String... args) {
            JSONArray jsonArray = null;
            List<Room> rooms = null;
            
            try {
                jsonArray = ReadJSONFromServer.getJSON(context.getResources().getString(R.string.URL));
                rooms = JsonToRoomsConverter.convertJSON(jsonArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return rooms;
        }

    @Override
    protected void onPostExecute(List<Room> rooms) {
        pDialog.dismiss();
        Log.e("response", String.valueOf(rooms));
        // refresh any list
    }
    }