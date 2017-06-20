package com.example.eowemcn.myapplication.zonelist;

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
import com.example.eowemcn.myapplication.zonelist.RoomListAdapter;
import com.example.eowemcn.myapplication.models.Room;
import com.example.eowemcn.myapplication.models.Zone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZoneListActivity extends Activity {

    private boolean clicked;
    RoomListAdapter listAdapter;
    ExpandableListView expListView;
    ArrayList<String> listDataHeader;
    HashMap<String, List<Room>> listDataChild;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        /*Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.searchview1);
        myTextView4.setTypeface(myTypeFace4);*/

        final TextView textviewclick = (TextView) findViewById(R.id.lblListItem);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing Oldlist data
        Bundle extras = getIntent().getExtras();
        // TODO: Needs to be removed
        listDataHeader = extras.getStringArrayList("header");
        listDataChild = (HashMap<String,  List<Room>>)getIntent().getSerializableExtra("children");
        // TODO: use this new list of rooms
        List<Room> rooms = (List<Room>)extras.getSerializable("allrooms");


        listAdapter = new RoomListAdapter(this, listDataHeader, listDataChild);

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




                if(!clicked){
                    textViewColor.setTextColor(getResources().getColor(R.color.drawer_color));
                    // set the default color
                    clicked = true;
                }else{
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

    private void convertRoomsToHeadersAndChildren(List<Room> allRooms){
        listDataHeader = new ArrayList<String>();
        int i = 0;
        for (Zone z : Zone.values()) {
            listDataHeader.add("Zone " + z.getIntValue());
            List<Room> zoneRooms = new ArrayList<>();
            for(Room r : allRooms){
                if(r.getZone() == z){
                    zoneRooms.add(r);
                }
            }
            listDataChild.put(listDataHeader.get(i), zoneRooms);
            i++;
        }
    }
}
