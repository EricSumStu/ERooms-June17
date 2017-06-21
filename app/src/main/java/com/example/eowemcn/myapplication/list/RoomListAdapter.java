package com.example.eowemcn.myapplication.list;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.models.Room;
import com.example.eowemcn.myapplication.models.Zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RoomListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    private List<String> originalListDataHeader = new ArrayList<>(); // header titles
    // child data in format of header title, child title
    private HashMap<String, List<Room>> _listDataChild;
    private HashMap<String, List<Room>> originalListDataChild; // header titles

    public RoomListAdapter(Context context, List<String> listDataHeader,
                           HashMap<String, List<Room>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.originalListDataHeader.addAll(_listDataHeader);
        this.originalListDataChild  = new HashMap<>(this._listDataChild);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition).toString();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){
        Log.v("SearchQuery", "Query is: " + query);
        // Clear the list as we know the search is called
        _listDataHeader.clear();
        _listDataChild.clear();

        if(query.isEmpty() || query == null){

            _listDataHeader.addAll(originalListDataHeader);
            _listDataChild.putAll(originalListDataChild);
        }
        else {

            for(String header : originalListDataHeader){ // get all headers, represents a zone
                List<Room> rooms = originalListDataChild.get(header); // get list of rooms under header (zone)

                List<Room> roomsToShow = new ArrayList<>(); // list we will fill with rooms that match

                for (Room room : rooms) { // for every room in zone
                    if(room.getName().toLowerCase().contains(query)){ // see if room name matches
                        roomsToShow.add(room);
                    }
                }
                if(roomsToShow.size()>0){ // if we added any rooms, put them on result
                    _listDataChild.put(header, roomsToShow);
                    _listDataHeader.add(header);
                }




            }

        }

        notifyDataSetChanged();
    }


}