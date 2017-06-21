package com.example.eowemcn.myapplication.list.features;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.list.FeatureAdapter;
import com.example.eowemcn.myapplication.models.Feature;
import com.example.eowemcn.myapplication.models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeatureListActivity extends Activity {


    private boolean clicked;
    FeatureAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<String> listDataHeader;
    HashMap<String, List<Feature>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.features);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.fExp);

        // preparing Oldlist data
        Bundle extras = getIntent().getExtras();

        List<Room> rooms = (List<Room>) extras.getSerializable("allrooms");
        convertRoomsFeaturesToHeadersAndChildren(rooms);


        listAdapter = new FeatureAdapter(this, listDataHeader, listDataChild);

        // setting Oldlist adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                TextView textViewColor = (TextView) v.findViewById(R.id.lblListItem);


                if (!clicked) {
                    textViewColor.setTextColor(getResources().getColor(R.color.drawer_color));
                    // set the default color
                    clicked = true;
                } else {
                    textViewColor.setTextColor(getResources().getColor(R.color.colorGreen));
                    //set secondary color
                    clicked = false;
                }


          /*      Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show(); */
                return false;
            }
        });
    }


    private void convertRoomsFeaturesToHeadersAndChildren(List<Room> allRooms) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();
        int i = 0;
        for (Room r : allRooms) {
            listDataHeader.add(r.toString());
            List<String> features = new ArrayList<>();
            List<Feature> feat = r.getFeatures();
            listDataChild.put(listDataHeader.get(i), feat);
            i++;
        }
    }
}
