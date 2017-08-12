package smashaway.goldenwork.com.smashaway;

import android.content.ClipData;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import smashaway.goldenwork.com.smashaway.Adapters.DashboardAdapter;
import smashaway.goldenwork.com.smashaway.Adapters.NavAdapter;
import smashaway.goldenwork.com.smashaway.BClass.PoolItem;

import static android.R.id.list;
import static smashaway.goldenwork.com.smashaway.R.id.toolbar;

public class DashboardActivity extends AppCompatActivity
        implements ExpandableListView.OnChildClickListener {

    LineChart chart;
    DashboardAdapter myAdapter;
    List<PoolItem> pitemList;
    RecyclerView recyclerview;
    private String TAG = "DBOARD";
    Toolbar toolbar;
    private DrawerLayout drawer;
    private ExpandableListView drawerList;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        chart = (LineChart) findViewById(R.id.chart);

        //initialize recyclerview
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);

        pitemList = new ArrayList<>();
        myAdapter = new DashboardAdapter(pitemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(myAdapter);
        initDashbord();
        initDrawer();
    }

    private void initDashbord() {
        //initialize Chart
        List<String> listMonths = new ArrayList<>();
        List<Integer> listvalues = new ArrayList<>();
        List<Entry> entries = new ArrayList<Entry>();
        for (int i =0; i<12;i++){
            entries.add(new Entry((float)(i), (float)(i*100)));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();

        //set fake data for recyclerView
        //(int id, String name, String ustensile, String type, String dateclaim, String urlprofile)
        PoolItem p = new PoolItem(0,"Theresa","Audi Q5 (accident)", "car", "6 June 2017","");
        pitemList.add(p);
        p = new PoolItem(1,"Christo","iPhone (theft)", "heart", "22 May 2017","");
        pitemList.add(p);
        p = new PoolItem(2,"Christo","Guitar (theft)", "heart", "22 May 2017","");
        pitemList.add(p);
        p = new PoolItem(3,"John","Geyser (damage)", "house", "16 March 2017","");
        pitemList.add(p);
        p = new PoolItem(4,"Dieter","Various items (break-in)", "house", "28 February 2017","");
        pitemList.add(p);
        Log.e(TAG, String.valueOf(pitemList.size()));
        myAdapter.notifyDataSetChanged();

        initDrawer();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void initDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerList = (ExpandableListView) findViewById(R.id.left_drawer);

        // preparing list data
        prepareListData();

        drawerList.setAdapter(new NavAdapter(this, listDataHeader, listDataChild));

        drawerList.setOnChildClickListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open , R.string.drawer_close ){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we don't want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we don't want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
       * Preparing the list data
       */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding headers
        Resources res = getResources();
        String[] headers = res.getStringArray(R.array.nav_drawer_labels);
        listDataHeader = Arrays.asList(headers);

        //Adding child data

//        //Dynamic method
//        for (int i =0; i<listDataHeader.size(); i++){
//
//            //Save data in array
//            String[] childData = res.getStringArray(R.array.elements_home);
//
//            //Put data in List
//            List<String> listChild;
//            listChild = Arrays.asList(childData);
//
//            //Add to hashMap
//            listDataChild.put(listDataHeader.get(i),listChild);
//        }

        // Static method
        List<String> home,community,helpinout, mypolicy, claims,legalStuff;
        String[] shome,scommunity,shelpout, smypolicy, sclaims,slegalStuff;

        shome = res.getStringArray(R.array.elements_home);
        home = Arrays.asList(shome);

        scommunity = res.getStringArray(R.array.elements_myCommunity);
        community = Arrays.asList(scommunity);

        shelpout = res.getStringArray(R.array.elements_helpingOut);
        helpinout = Arrays.asList(shelpout);

        smypolicy = res.getStringArray(R.array.elements_myPolicy);
        mypolicy = Arrays.asList(smypolicy);

        sclaims = res.getStringArray(R.array.elements_claims);
        claims = Arrays.asList(sclaims);

        slegalStuff = res.getStringArray(R.array.elements_legalStuff);
        legalStuff = Arrays.asList(slegalStuff);

        // Add to hashMap
        listDataChild.put(listDataHeader.get(0), home); // Header, Child data
        listDataChild.put(listDataHeader.get(1), community);
        listDataChild.put(listDataHeader.get(2), helpinout);
        listDataChild.put(listDataHeader.get(3), mypolicy); // Header, Child data
        listDataChild.put(listDataHeader.get(4), claims);
        listDataChild.put(listDataHeader.get(5), legalStuff);
    }
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
}
