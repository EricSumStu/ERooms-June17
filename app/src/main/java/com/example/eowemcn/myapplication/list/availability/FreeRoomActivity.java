package com.example.eowemcn.myapplication.list.availability;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.list.zone.RoomListAdapter;
import com.example.eowemcn.myapplication.models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FreeRoomActivity extends Activity {


    private boolean clicked1;
        RoomListAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<String> listDataHeader;
    HashMap<String, List<Room>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freerooms);

        /*Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.searchview1);
        myTextView4.setTypeface(myTypeFace4);*/

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.freeExp);

        // preparing Oldlist data
        Bundle extras = getIntent().getExtras();

        List<Room> rooms = (List<Room>)extras.getSerializable("allrooms");
        convertRoomsToHeadersAndChildren(rooms);


        listAdapter = new RoomListAdapter(this, listDataHeader, listDataChild);

        // setting Oldlist adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

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
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
               /* Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show(); */
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
               /* Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show(); */

            }
        });
        expandAll();
    }
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            expListView.expandGroup(i);
        }
    }

    private void convertRoomsToHeadersAndChildren(List<Room> allRooms) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();
        List<Room> freeRooms = new ArrayList<>();
        //List<Room> busyRooms = new ArrayList<>();

        // Add our Headers
        listDataHeader.add("Free Rooms");
      //  listDataHeader.add("Busy Rooms");

        for (Room r : allRooms) {
            if(r.isAvailable()){
               freeRooms.add(r);
            }else{
               // busyRooms.add(r);
            }
            // if room is free, add to freeRooms list
            // else it's busy and add to busyRooms list
        }

        // Put the lists under the headers
        listDataChild.put(listDataHeader.get(0), freeRooms); // should be freeRooms
       // listDataChild.put(listDataHeader.get(1), busyRooms); // should be busyRooms

    }
}
