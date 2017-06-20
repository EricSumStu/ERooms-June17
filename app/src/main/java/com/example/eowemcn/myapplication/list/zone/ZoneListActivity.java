package com.example.eowemcn.myapplication.list.zone;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.list.RoomListAdapter;
import com.example.eowemcn.myapplication.models.Room;
import com.example.eowemcn.myapplication.models.Zone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZoneListActivity extends Activity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener{

    private boolean clicked;
    private SearchView search;
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

        List<Room> rooms = (List<Room>)extras.getSerializable("allrooms");
        convertRoomsToHeadersAndChildren(rooms);


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

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView) findViewById(R.id.searchview1);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);

        //expand all Groups
        expandAll();
    }

    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            expListView.expandGroup(i);
        }
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }

    private void convertRoomsToHeadersAndChildren(List<Room> allRooms){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();
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
