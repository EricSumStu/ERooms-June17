package com.example.eowemcn.myapplication.list.features;
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

import com.example.eowemcn.myapplication.list.FeatureAdapter;
import com.example.eowemcn.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeatureListActivity extends Activity {


    FeatureAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.features);

        Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.textviewf);
        myTextView4.setTypeface(myTypeFace4);



        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.fExp);

        // preparing Oldlist data
        prepareListData();
        Bundle extras = getIntent().getExtras();
        listDataHeader = extras.getStringArrayList("header");
        listDataChild = (HashMap<String, List<String>>) getIntent().getSerializableExtra("children");
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
        listDataHeader.add("Lars Magnus");
        listDataHeader.add("Reykjavik");
        listDataHeader.add("Nuuk");
        listDataHeader.add("Paris");
        listDataHeader.add("Athlone Tele Prescence");
        listDataHeader.add("Demo Room");
        listDataHeader.add("Kuala Lumpur");
        listDataHeader.add("Stockholm");
        listDataHeader.add("Berlin");
        listDataHeader.add("Helsinki");
        listDataHeader.add("Rome");
        listDataHeader.add("Wellington");
        listDataHeader.add("Canberra");
        listDataHeader.add("Tokyo");
        listDataHeader.add("Warsaw");
        listDataHeader.add("Kiev");
        listDataHeader.add("Moscow");
        listDataHeader.add("Cape Town");
        listDataHeader.add("Jakarta");
        listDataHeader.add("Honolulu");
        listDataHeader.add("Ottowa");
        listDataHeader.add("Anchorage");
        listDataHeader.add("Buenos Aires");
        listDataHeader.add("Brasilia");
        listDataHeader.add("Washington");
        listDataHeader.add("V.A Lab");

        // Adding child data
        List<String> lars_magnus = new ArrayList<>();
        lars_magnus.add("4 T.V's");
        lars_magnus.add("4 Whiteboards");
        lars_magnus.add("1 Projector");
        lars_magnus.add("Capacity:28");

        List<String> reykjavik = new ArrayList<>();
        reykjavik.add("2 T.V's");
        reykjavik.add("2 Whiteboards");
        reykjavik.add("1 Projector");
        reykjavik.add("Capacity:10");

        List<String> nuuk = new  ArrayList<>();
        nuuk.add("2 Whiteboards");
        nuuk.add("1 Projector");
        nuuk.add("8 Desks");
        nuuk.add("1 Table");

        List<String> paris = new  ArrayList<>();
        paris.add("1 Whiteboard");
        paris.add("1 T.V");

        List<String> athloneteleprescence =  new  ArrayList<>();
        athloneteleprescence.add("");
        athloneteleprescence.add("");
        athloneteleprescence.add("");

        List<String> demoroom =  new ArrayList<>();
        demoroom.add("");
        demoroom.add("");
        demoroom.add("");
        demoroom.add("");
        demoroom.add("");


        List<String> kuala_lumpur = new  ArrayList<>();
        kuala_lumpur.add("1 Whiteboard");
        kuala_lumpur.add("1 T.V");
        kuala_lumpur.add("");

        List<String> stockholm = new  ArrayList<>();
        stockholm.add("1 Whiteboard");
        stockholm.add("1 T.V");
        stockholm.add("Camera");
        stockholm.add("");

        List<String> berlin = new ArrayList<>();
        berlin.add("");
        berlin.add("");
        berlin.add("");
        berlin.add("");
        berlin.add("");

        List<String> helsinki = new ArrayList<>();
        helsinki.add("1 Whiteboard");
        helsinki.add("1 T.V");
        helsinki.add("");

        List<String> rome = new ArrayList<>();
        rome.add("1 Whiteboard");
        rome.add("1 T.V");
        rome.add("");

        List<String> wellington = new ArrayList<>();
        wellington.add("1 Whiteboard");
        wellington.add("1 T.V");
        wellington.add("Capacity:10");

        List<String> canberra = new ArrayList<>();
        canberra.add("1 Whiteboard");
        canberra.add("1 T.V");
        canberra.add("Capacity:10");

        List<String> tokyo = new ArrayList<>();
        tokyo.add("1 Whiteboard");
        tokyo.add("2 T.V's");
        tokyo.add("Speakers");
        tokyo.add("Camera");
        tokyo.add("");

        List<String> warsaw = new ArrayList<>();
        warsaw.add("1 Whiteboard");
        warsaw.add("1 T.V");
        warsaw.add("Capacity:10");

          List<String> kiev = new ArrayList<>();
        kiev.add("3 Whiteboards");
        kiev.add("1 T.V");
        kiev.add("Capacity:10");

        List<String> moscow = new ArrayList<>();
        moscow.add("1 Whiteboard");
        moscow.add("1 T.V");
        moscow.add("Capacity:9");

        List<String> cape_town = new ArrayList<>();
        cape_town.add("1 Whiteboard");
        cape_town.add("1 T.V");
        cape_town.add("Capacity:13");

        List<String> jakarta = new ArrayList<>();
        jakarta.add("2 Whiteboards");
        jakarta.add("1 T.V");
        jakarta.add("");

        List<String> honolulu = new ArrayList<>();
        honolulu.add("2 Whiteboards");
        honolulu.add("1 T.V");
        honolulu.add("1 Flipboard");
        honolulu.add("Capacity:9");

        List<String> ottowa = new ArrayList<>();
        ottowa.add("1 Whiteboard");
        ottowa.add("1 T.v");
        ottowa.add("Capacity:11");

        List<String> anchorage = new ArrayList<>();
        anchorage.add("1 Whiteboard");
        anchorage.add("3 T.V's");
        anchorage.add("1 Flipboard");
        anchorage.add("Camera");
        anchorage.add("Tablet");
        anchorage.add("Capacity:11+");

        List<String> buenos_aires = new ArrayList<>();
        buenos_aires.add("1 Whiteboard");
        buenos_aires.add("1 T.V");
        buenos_aires.add("Capacity:9");

        List<String> brasilla = new ArrayList<>();
        brasilla.add("1 Whiteboard");
        brasilla.add("1 T.V");
        brasilla.add("");

        List<String> washington_d_c = new ArrayList<>();
        washington_d_c.add("1 Whiteboard");
        washington_d_c.add("1 T.V");
        washington_d_c.add("Capacity:10");

        List<String> v_a_lab = new ArrayList<>();
        v_a_lab.add("3 Whiteboards");
        v_a_lab.add("1 Projector");
        v_a_lab.add("6 Computer Screens");
        v_a_lab.add("Capacity:11");

        listDataChild.put(listDataHeader.get(0), lars_magnus); // Header,
        listDataChild.put(listDataHeader.get(1), reykjavik);
        listDataChild.put(listDataHeader.get(2), nuuk);
        listDataChild.put(listDataHeader.get(3), paris);
        listDataChild.put(listDataHeader.get(4), athloneteleprescence);
        listDataChild.put(listDataHeader.get(5), demoroom);
        listDataChild.put(listDataHeader.get(6), kuala_lumpur);
        listDataChild.put(listDataHeader.get(7), stockholm);
        listDataChild.put(listDataHeader.get(8), helsinki);
        listDataChild.put(listDataHeader.get(9), rome);
        listDataChild.put(listDataHeader.get(10), wellington);
        listDataChild.put(listDataHeader.get(11), canberra);
        listDataChild.put(listDataHeader.get(12), tokyo);
        listDataChild.put(listDataHeader.get(13), warsaw);
        listDataChild.put(listDataHeader.get(14), kiev);
        listDataChild.put(listDataHeader.get(15), moscow);
        listDataChild.put(listDataHeader.get(16), cape_town);
        listDataChild.put(listDataHeader.get(17), jakarta);
        listDataChild.put(listDataHeader.get(18), honolulu);
        listDataChild.put(listDataHeader.get(19), ottowa);
        listDataChild.put(listDataHeader.get(20), anchorage);
        listDataChild.put(listDataHeader.get(21), buenos_aires);
        listDataChild.put(listDataHeader.get(22), washington_d_c);
        listDataChild.put(listDataHeader.get(23), v_a_lab);
    }
}