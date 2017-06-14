package com.example.eowemcn.myapplication.list;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eowemcn.myapplication.ExpandableListAdapter;
import com.example.eowemcn.myapplication.R;
import com.example.eowemcn.myapplication.models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends Activity {

    private boolean clicked;
    RoomListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Room>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Typeface myTypeFace4 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView4 = (TextView) findViewById(R.id.textview4);
        myTextView4.setTypeface(myTypeFace4);

        final TextView textviewclick = (TextView) findViewById(R.id.lblListItem);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing Oldlist data
        prepareListData();

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
                TextView textView = (TextView) parent.findViewById(R.id.lblListItem);

                textView.setTextColor(getResources().getColor(R.color.colorAccent));


 /*               Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                        */
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

        // Adding child data
        List<Room> zone1 = new ArrayList<>();
        String larsName = getString(R.string.LarsMagnus); // get the room name from res/values/strings.xml
        Room lars = new Room(larsName); // Create a room object with the name
        zone1.add(lars); // add the room to the list of rooms for zone1

        // add another room
        String rey = getString(R.string.Reykjavik); // get the room name from res/values/strings.xml
        Room reyk = new Room(rey); // Create a room object with the name
        zone1.add(reyk); // add the room to the list of rooms for zone1

        String nuu = getString(R.string.Nuuk); // get the room name from res/values/strings.xml
        Room nuuk = new Room(nuu); // Create a room object with the name
        zone1.add(nuuk); // add the room to the list of rooms for zone1

        String q1 = getString(R.string.Quiet_Room_1_16); // get the room name from res/values/strings.xml
        Room qu1 = new Room(q1); // Create a room object with the name
        zone1.add(qu1); // add the room to the list of rooms for zone1

        String q2 = getString(R.string.Quiet_Room_1_17); // get the room name from res/values/strings.xml
        Room qu2 = new Room(q2); // Create a room object with the name
        zone1.add(qu2); // add the room to the list of rooms for zone1

        String q3 = getString(R.string.Quiet_Room_1_20); // get the room name from res/values/strings.xml
        Room qu3 = new Room(q3); // Create a room object with the name
        zone1.add(qu3); // add the room to the list of rooms for zone1

        String q4 = getString(R.string.Quiet_Room_1_21); // get the room name from res/values/strings.xml
        Room qu4 = new Room(q4); // Create a room object with the name
        zone1.add(qu4); // add the room to the list of rooms for zone1

        String q5 = getString(R.string.Quiet_Room_1_28); // get the room name from res/values/strings.xml
        Room qu5 = new Room(q5); // Create a room object with the name
        zone1.add(qu5); // add the room to the list of rooms for zone1

        String q6 = getString(R.string.Quiet_Room_1_29); // get the room name from res/values/strings.xml
        Room qu6 = new Room(q6); // Create a room object with the name
        zone1.add(qu6); // add the room to the list of rooms for zone1

        List<Room> zone3 = new ArrayList<>();
        String Pa = getString(R.string.Paris); // get the room name from res/values/strings.xml
        Room Par = new Room(Pa); // Create a room object with the name
        zone3.add(Par); // add the room to the list of rooms for zone1

        String At = getString(R.string.Athlone_Conference_Room); // get the room name from res/values/strings.xml
        Room Ath = new Room(At); // Create a room object with the name
        zone3.add(Ath); // add the room to the list of rooms for zone1

        String Q336 = getString(R.string.Quiet_Room_3_36); // get the room name from res/values/strings.xml
        Room Qr336 = new Room(Q336); // Create a room object with the name
        zone3.add(Qr336); // add the room to the list of rooms for zone1

        String Q344  = getString(R.string.Quiet_Room_3_44); // get the room name from res/values/strings.xml
        Room Qr344 = new Room(Q344); // Create a room object with the name
        zone3.add(Qr344); // add the room to the list of rooms for zone1

        String Q345 = getString(R.string.Quiet_Room_3_45); // get the room name from res/values/strings.xml
        Room Qr345 = new Room(Q345); // Create a room object with the name
        zone3.add(Qr345); // add the room to the list of rooms for zone1

        List<Room> zone4 = new ArrayList<>();
        String De = getString(R.string.Demo_Room); // get the room name from res/values/strings.xml
        Room Dem = new Room(De); // Create a room object with the name
        zone4.add(Dem); // add the room to the list of rooms for zone1

        String Ku = getString(R.string.Kuala_Lumpur); // get the room name from res/values/strings.xml
        Room Kua = new Room(Ku); // Create a room object with the name
        zone4.add(Kua); // add the room to the list of rooms for zone1

        String Q401 = getString(R.string.Quiet_Room_4_01); // get the room name from res/values/strings.xml
        Room Qr401 = new Room(Q401); // Create a room object with the name
        zone4.add(Qr401); // add the room to the list of rooms for zone1

        String Q402 = getString(R.string.Quiet_Room_4_02); // get the room name from res/values/strings.xml
        Room Qr402 = new Room(Q402); // Create a room object with the name
        zone4.add(Qr402); // add the room to the list of rooms for zone1

        String Q427 = getString(R.string.Quiet_Room_4_27); // get the room name from res/values/strings.xml
        Room Qr427 = new Room(Q427); // Create a room object with the name
        zone4.add(Qr427); // add the room to the list of rooms for zone1

        String Q445 = getString(R.string.Quiet_Room_4_45); // get the room name from res/values/strings.xml
        Room Qr445 = new Room(Q445); // Create a room object with the name
        zone4.add(Qr445); // add the room to the list of rooms for zone1

        String Q455 = getString(R.string.Quiet_Room_4_55); // get the room name from res/values/strings.xml
        Room Qr455 = new Room(Q455); // Create a room object with the name
        zone4.add(Qr455); // add the room to the list of rooms for zone1

        String Q456 = getString(R.string.Quiet_Room_4_56); // get the room name from res/values/strings.xml
        Room Qr456 = new Room(Q456); // Create a room object with the name
        zone4.add(Qr456); // add the room to the list of rooms for zone1

        String Q457 = getString(R.string.Quiet_Room_4_57); // get the room name from res/values/strings.xml
        Room Qr457 = new Room(Q457); // Create a room object with the name
        zone4.add(Qr457); // add the room to the list of rooms for zone1

        List<Room> zone5 = new ArrayList<>();
        String S = getString(R.string.Stockholm); // get the room name from res/values/strings.xml
        Room St = new Room(S); // Create a room object with the name
        zone5.add(St); // add the room to the list of rooms for zone1

        String B = getString(R.string.Berlin); // get the room name from res/values/strings.xml
        Room Be = new Room(B); // Create a room object with the name
        zone5.add(Be); // add the room to the list of rooms for zone1

        String H = getString(R.string.Helsinki); // get the room name from res/values/strings.xml
        Room He = new Room(H); // Create a room object with the name
        zone5.add(He); // add the room to the list of rooms for zone1

        String Ro = getString(R.string.Rome); // get the room name from res/values/strings.xml
        Room Rom = new Room(Ro); // Create a room object with the name
        zone5.add(Rom); // add the room to the list of rooms for zone1

        String Q504 = getString(R.string.Quiet_Room_5_04); // get the room name from res/values/strings.xml
        Room Qr504 = new Room(Q504); // Create a room object with the name
        zone5.add(Qr504); // add the room to the list of rooms for zone1

        String Q510 = getString(R.string.Quiet_Room_5_10); // get the room name from res/values/strings.xml
        Room Qr510 = new Room(Q510); // Create a room object with the name
        zone5.add(Qr510); // add the room to the list of rooms for zone1

        List<Room> zone6 = new ArrayList<>();
        String W = getString(R.string.Wellington); // get the room name from res/values/strings.xml
        Room We = new Room(W); // Create a room object with the name
        zone6.add(We); // add the room to the list of rooms for zone1

        String C = getString(R.string.Canberra); // get the room name from res/values/strings.xml
        Room Ca = new Room(C); // Create a room object with the name
        zone6.add(Ca); // add the room to the list of rooms for zone1

        String T = getString(R.string.Tokyo); // get the room name from res/values/strings.xml
        Room To = new Room(T); // Create a room object with the name
        zone6.add(To); // add the room to the list of rooms for zone1

        String Wa = getString(R.string.Warsaw); // get the room name from res/values/strings.xml
        Room War = new Room(Wa); // Create a room object with the name
        zone6.add(War); // add the room to the list of rooms for zone1

        String K = getString(R.string.Kiev); // get the room name from res/values/strings.xml
        Room Ki = new Room(K); // Create a room object with the name
        zone6.add(Ki); // add the room to the list of rooms for zone1

        String M = getString(R.string.Moscow); // get the room name from res/values/strings.xml
        Room Mo = new Room(M); // Create a room object with the name
        zone6.add(Mo); // add the room to the list of rooms for zone1

        String Q601 = getString(R.string.Quiet_Room_6_01); // get the room name from res/values/strings.xml
        Room Qr601 = new Room(Q601); // Create a room object with the name
        zone6.add(Qr601); // add the room to the list of rooms for zone1

        String Q615 = getString(R.string.Quiet_Room_6_15); // get the room name from res/values/strings.xml
        Room Qr615 = new Room(Q615); // Create a room object with the name
        zone6.add(Qr615); // add the room to the list of rooms for zone1

        String Q616 = getString(R.string.Quiet_Room_6_16); // get the room name from res/values/strings.xml
        Room Qr616 = new Room(Q616); // Create a room object with the name
        zone6.add(Qr616); // add the room to the list of rooms for zone1

        String Q629 = getString(R.string.Quiet_Room_6_29); // get the room name from res/values/strings.xml
        Room Qr629 = new Room(Q629); // Create a room object with the name
        zone6.add(Qr629); // add the room to the list of rooms for zone1

        String Q630 = getString(R.string.Quiet_Room_6_30); // get the room name from res/values/strings.xml
        Room Qr630 = new Room(Q630); // Create a room object with the name
        zone6.add(Qr630); // add the room to the list of rooms for zone1

        String Q636 = getString(R.string.Quiet_Room_6_36); // get the room name from res/values/strings.xml
        Room Qr636 = new Room(Q636); // Create a room object with the name
        zone6.add(Qr636); // add the room to the list of rooms for zone1

        List<Room> zone7 = new ArrayList<>();
        String CA = getString(R.string.Cape_Town); // get the room name from res/values/strings.xml
        Room CAP = new Room(CA); // Create a room object with the name
        zone7.add(CAP); // add the room to the list of rooms for zone1

        String J = getString(R.string.Jakarta); // get the room name from res/values/strings.xml
        Room Ja = new Room(J); // Create a room object with the name
        zone7.add(Ja); // add the room to the list of rooms for zone1

        String Q708 = getString(R.string.Quiet_Room_708); // get the room name from res/values/strings.xml
        Room Qr708 = new Room(Q708); // Create a room object with the name
        zone7.add(Qr708); // add the room to the list of rooms for zone1

        String Q709 = getString(R.string.Quiet_Room_709); // get the room name from res/values/strings.xml
        Room Qr709 = new Room(Q709); // Create a room object with the name
        zone7.add(Qr709); // add the room to the list of rooms for zone1

        String Q711 = getString(R.string.Quiet_Room_711); // get the room name from res/values/strings.xml
        Room Qr711 = new Room(Q711); // Create a room object with the name
        zone7.add(Qr711); // add the room to the list of rooms for zone1

        String Q714 = getString(R.string.Quiet_Room_714); // get the room name from res/values/strings.xml
        Room Qr714 = new Room(Q714); // Create a room object with the name
        zone7.add(Qr714); // add the room to the list of rooms for zone1

        String Q719 = getString(R.string.Quiet_Room_719); // get the room name from res/values/strings.xml
        Room Qr719 = new Room(Q719); // Create a room object with the name
        zone7.add(Qr719); // add the room to the list of rooms for zone1
        String Q720 = getString(R.string.Quiet_Room_720); // get the room name from res/values/strings.xml
        Room Qr720 = new Room(Q720); // Create a room object with the name
        zone7.add(Qr720); // add the room to the list of rooms for zone1




        listDataChild.put(listDataHeader.get(0), zone1); // Header
                }
                }