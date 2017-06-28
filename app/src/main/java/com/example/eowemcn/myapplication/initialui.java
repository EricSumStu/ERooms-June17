package com.example.eowemcn.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eowemcn.myapplication.json.JsonToRoomsConverter;
import com.example.eowemcn.myapplication.json.ReadFileToJSON;
import com.example.eowemcn.myapplication.json.ReadJSONFromServer;
import com.example.eowemcn.myapplication.list.availability.FreeRoomActivity;
import com.example.eowemcn.myapplication.list.features.FeatureListActivity;
import com.example.eowemcn.myapplication.list.zone.ZoneListActivity;
import com.example.eowemcn.myapplication.map.Maps;
import com.example.eowemcn.myapplication.models.Room;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class initialui extends Activity {

    public Button textview2;
    ArrayList<String> listDataHeader;
    HashMap<String, List<Room>> listDataChild;
    public Button textview4;
    List<Room> rooms;

    public void init4() {
        textview4 = (Button) findViewById(R.id.textview4);
        textview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newscreen4 = new Intent(initialui.this, FreeRoomActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("allrooms",(Serializable) rooms);
                newscreen4.putExtras(bundle);

                startActivity(newscreen4);
            }
        });
    }
    public void init2() {
        textview2 = (Button) findViewById(R.id.textview2);
        textview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newscreen2 = new Intent(initialui.this, Maps.class);

                startActivity(newscreen2);
            }
        });
    }

    public Button textview1;

    public void init() {
        textview1 = (Button) findViewById(R.id.textview1);
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newscreen = new Intent(initialui.this, ZoneListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("allrooms",(Serializable) rooms);
                newscreen.putExtras(bundle);

                startActivity(newscreen);

            }
        });
    }

    public Button textview3;

    public void init3() {
        textview3 = (Button) findViewById(R.id.textview3);
        textview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newscreen3 = new Intent(initialui.this, FeatureListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("allrooms",(Serializable) rooms);
                newscreen3.putExtras(bundle);
    //            newscreen3.putExtra("header",  listDataHeader);
      //          newscreen3.putExtra("children", listDataChild);

                startActivity(newscreen3);
            }
        });
    }





    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.initialui);

        // Execute Background Task to get JSON
        new JSONParse().execute();

        Typeface myTypeFace1 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView1 = (TextView) findViewById(R.id.textview1);
        myTextView1.setTypeface(myTypeFace1);
        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView2 = (TextView) findViewById(R.id.textview2);
        myTextView2.setTypeface(myTypeFace2);
        Typeface myTypeFace3 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView3 = (TextView) findViewById(R.id.textview3);
        myTextView3.setTypeface(myTypeFace3);
        Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.textview4);
        myTextView4.setTypeface(myTypeFace4);

        ImageView myImageView = (ImageView) findViewById(R.id.imageView1);
        myImageView.setImageResource(R.drawable.logo);


        init();
        init2();
        init3();
        init4();
    }

    private class JSONParse extends AsyncTask<String, String, JSONArray> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(initialui.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected JSONArray doInBackground(String... args) {
            JSONArray jsonArray = null;

            try {
                // TODO: Get server running and put URL here
                //jsonArray = ReadJSONFromServer.getJSON("http://myserver.com");
                jsonArray = ReadFileToJSON.readFile(getResources(), R.raw.rooms);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }

            return jsonArray;
        }
        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            pDialog.dismiss();
            try {
                // Getting JSON Array
                rooms = JsonToRoomsConverter.convertJSON(jsonArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
