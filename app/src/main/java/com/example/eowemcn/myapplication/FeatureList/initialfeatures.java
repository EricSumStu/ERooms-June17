package com.example.eowemcn.myapplication.FeatureList;
import android.app.Activity;
import android.graphics.Typeface;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class initialfeatures extends Activity {


    ExpandableListAdapter2 listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.textview4);
        myTextView4.setTypeface(myTypeFace4);



        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing Oldlist data
        prepareListData();

        listAdapter = new ExpandableListAdapter2(this, listDataHeader, listDataChild);

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
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }



    /*
     * Preparing the Oldlist data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Zone 1");
        listDataHeader.add("Zone 3");
        listDataHeader.add("Zone 4");
        listDataHeader.add("Zone 5");
        listDataHeader.add("Zone 6");
        listDataHeader.add("Zone 7");
        listDataHeader.add("Zone 8");
        listDataHeader.add("Zone 9");


        // Adding child data
        List<String> zone1 = new ArrayList<>();
        zone1.add("Lars Magnus");
        zone1.add("Reykjavik");
        zone1.add("Nuuk");
        zone1.add("Quiet Room 1-16");
        zone1.add("Quiet Room 1-17");
        zone1.add("Quiet Room 1-20");
        zone1.add("Quiet Room 1-21");
        zone1.add("Quiet Room 1-28");
        zone1.add("Quiet Room 1-29");


        List<String> zone3 = new ArrayList<>();
        zone3.add("Paris");
        zone3.add("Athlone- Conference Room");
        zone3.add("Quiet Room 3-36");
        zone3.add("Quiet Room 3-44");
        zone3.add("Quiet Room 3-45");


        List<String> zone4 = new  ArrayList<>();
        zone4.add("Demo Room");
        zone4.add("Kuala Lumpur");
        zone4.add("Quiet Room 4-01");
        zone4.add("Quiet Room 4-02");
        zone4.add("Quiet Room 4-27");
        zone4.add("Quiet Room 4-45");
        zone4.add("Quiet Room 4-55");
        zone4.add("Quiet Room 4-56");
        zone4.add("Quiet Room 4-57");

        List<String> zone5 = new  ArrayList<>();
        zone5.add("Stockholm");
        zone5.add("Berlin");
        zone5.add("Helsinki");
        zone5.add("Rome");
        zone5.add("Quiet Room 5-04");
        zone5.add("Quiet Room 5-10");

        List<String> zone6 =  new  ArrayList<>();
        zone6.add("Wellington");
        zone6.add("Canberra");
        zone6.add("Tokyo");
        zone6.add("Warsaw");
        zone6.add("Kiev");
        zone6.add("Moscow");
        zone6.add("Quiet Room 6-01");
        zone6.add("Quiet Room 6-15");
        zone6.add("Quiet Room 6-16");
        zone6.add("Quiet Room 6-29");
        zone6.add("Quiet Room 6-30");
        zone6.add("Quiet Room 6-36");


        List<String> zone7 =  new ArrayList<>();
        zone7.add("Cape Town");
        zone7.add("Jakarta");
        zone7.add("Quiet Room 7-08");
        zone7.add("Quiet Room 7-09");
        zone7.add("Quiet Room 7-11");
        zone7.add("Quiet Room 7-14");
        zone7.add("Quiet Room 7-19");
        zone7.add("Quiet Room 7-20");

        List<String> zone8 = new  ArrayList<>();
        zone8.add("Honolulu");
        zone8.add("Ottowa");
        zone8.add("Anchorage");
        zone8.add("Quiet Room 8-12");
        zone8.add("Quiet Room 8-18");
        zone8.add("Quiet Room 8-23");
        zone8.add("Quiet Room 8-28");
        zone8.add("Quiet Room 8-29");
        zone8.add("Quiet Room 8-30");
        zone8.add("Quiet Room 8-34");
        zone8.add("Quiet Room 8-35");

        List<String> zone9 = new  ArrayList<>();
        zone9.add("Buenos Aires");
        zone9.add("Brasilla");
        zone9.add("Washington DC");
        zone9.add("V.A Lab");
        zone9.add("Quiet Room 9-06");
        zone9.add("Quiet Room 9-17");
        zone9.add("Quiet Room 9-25");
        zone9.add("Quiet Room 9-27");
        zone9.add("Quiet Room 9-39");
        zone9.add("Quiet Room 9-41");
        zone9.add("Quiet Room 9-48");


        listDataChild.put(listDataHeader.get(0), zone1); // Header,
        listDataChild.put(listDataHeader.get(1), zone3);
        listDataChild.put(listDataHeader.get(2), zone4);
        listDataChild.put(listDataHeader.get(3), zone5);
        listDataChild.put(listDataHeader.get(4), zone6);
        listDataChild.put(listDataHeader.get(5), zone7);
        listDataChild.put(listDataHeader.get(6), zone8);
        listDataChild.put(listDataHeader.get(7), zone9);

    }
}