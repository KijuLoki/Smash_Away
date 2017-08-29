package smashaway.goldenwork.com.smashaway;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mikepenz.iconics.view.IconicsImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import smashaway.goldenwork.com.smashaway.Adapters.NavAdapter;
import smashaway.goldenwork.com.smashaway.BClass.PoolItem;

public class CurrentProjectsActivity extends AppCompatActivity
        implements ExpandableListView.OnChildClickListener {

    private ExpandableListView drawerList;
    private DrawerLayout drawer;
    Toolbar toolbar;
    private String TAG = "COMMUNITY";
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private ActionBarDrawerToggle actionBarDrawerToggleCom;
    List<PoolItem> pitemList;
    RelativeLayout openAlertRel;
    IconicsImageView menu_icon,notif_icon;
    LinearLayout head0, head1, sub10, sub11, sub12, sub120,sub121,sub122, sub1220;
    IconicsImageView house_icon0, house_icon1,house_icon_sub11,house_icon_sub12, house_icon_sub121, house_icon_sub122;
    boolean open0= false, open1=false, open11 =false, open12=false, open121=false, open122=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_projects);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // alert button
        openAlertRel = (RelativeLayout)toolbar.findViewById(R.id.openAlert);
        openAlertRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAlertsActivity();
            }
        });
        //Toolbar
        menu_icon = (IconicsImageView)toolbar.findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(view);
            }
        });
        notif_icon = (IconicsImageView)toolbar.findViewById(R.id.notif_icon);
        notif_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAlertsActivity();
            }
        });
        house_icon0 = (IconicsImageView)findViewById(R.id.house_icon0);
        house_icon1 = (IconicsImageView)findViewById(R.id.house_icon1);
        house_icon_sub11 = (IconicsImageView)findViewById(R.id.house_icon_sub11);
        house_icon_sub12 = (IconicsImageView)findViewById(R.id.house_icon_sub12);
        house_icon_sub121 = (IconicsImageView)findViewById(R.id.house_icon_sub121);
        house_icon_sub122 = (IconicsImageView)findViewById(R.id.house_icon_sub122);

        head0 = (LinearLayout)findViewById(R.id.head0);
        head1 = (LinearLayout)findViewById(R.id.head1);
        sub10 = (LinearLayout)findViewById(R.id.sub10);
        sub10.setVisibility(View.GONE);
        sub11 = (LinearLayout)findViewById(R.id.sub11);
        sub11.setVisibility(View.GONE);
        sub12 = (LinearLayout)findViewById(R.id.sub12);
        sub12.setVisibility(View.GONE);
        sub120 = (LinearLayout)findViewById(R.id.sub120);
        sub120.setVisibility(View.GONE);
        sub121 = (LinearLayout)findViewById(R.id.sub121);
        sub121.setVisibility(View.GONE);
        sub122 = (LinearLayout)findViewById(R.id.sub122);
        sub122.setVisibility(View.GONE);
        sub1220 = (LinearLayout)findViewById(R.id.sub1220);
        sub1220.setVisibility(View.GONE);

        head1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open1){
                    hideView1(sub10,sub11,sub12);
                } else{
                    showView1(sub10,sub11,sub12);
                }

            }
        });
        sub12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open12){
                    hideView12(sub120,sub121,sub122);
                } else{
                    showView12(sub120,sub121,sub122);
                }

            }
        });
        sub122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open122){
                    hideView122(sub1220);
                } else{
                    showView122(sub1220);
                }

            }
        });
        initDashbord();
        initDrawer();
    }

    private void showView1(LinearLayout sub10, LinearLayout sub11, LinearLayout sub12) {
        sub10.setVisibility(View.VISIBLE);
        sub11.setVisibility(View.VISIBLE);
        sub12.setVisibility(View.VISIBLE);
        house_icon1.setColorRes(R.color.colorAccent);
        open1 = true;
    }
    private void hideView1(LinearLayout sub10, LinearLayout sub11, LinearLayout sub12) {
        sub10.setVisibility(View.GONE);
        sub11.setVisibility(View.GONE);
        sub12.setVisibility(View.GONE);
        sub120.setVisibility(View.GONE);
        sub121.setVisibility(View.GONE);
        sub122.setVisibility(View.GONE);
        sub1220.setVisibility(View.GONE);
        house_icon1.setColorRes(R.color.colorBlack);
        house_icon_sub12.setColorRes(R.color.colorBlack);
        house_icon_sub122.setColorRes(R.color.colorBlack);
        open122 = false;
        open12=false;
        open1=false;
    }


    private void showView12(LinearLayout sub10, LinearLayout sub11, LinearLayout sub12) {
        sub10.setVisibility(View.VISIBLE);
        sub11.setVisibility(View.VISIBLE);
        sub12.setVisibility(View.VISIBLE);
        house_icon_sub12.setColorRes(R.color.colorAccent);
        open12 = true;
    }
    private void hideView12(LinearLayout sub10, LinearLayout sub11, LinearLayout sub12) {
        sub10.setVisibility(View.GONE);
        sub11.setVisibility(View.GONE);
        sub12.setVisibility(View.GONE);
        sub1220.setVisibility(View.GONE);
        house_icon_sub12.setColorRes(R.color.colorBlack);
        house_icon_sub122.setColorRes(R.color.colorBlack);
        open122 = false;
        open12=false;
    }

    private void showView122(LinearLayout sub1220) {
        sub1220.setVisibility(View.VISIBLE);
        house_icon_sub122.setColorRes(R.color.colorAccent);
        open122 = true;
    }
    private void hideView122(LinearLayout sub1220) {
        sub1220.setVisibility(View.GONE);
        house_icon_sub122.setColorRes(R.color.colorBlack);
        open122 = false;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.current_projects, menu);
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


    private void initDashbord() {
        //set fake data for recyclerView




        initDrawer();
    }
    private void initDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerList = (ExpandableListView) findViewById(R.id.left_drawer);
        // preparing list data
        prepareListData();
        //drawerList.setGroupIndicator(null);
        drawerList.setAdapter(new NavAdapter(this, listDataHeader, listDataChild));

        drawerList.setOnChildClickListener(this);
        drawerList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {

            }
        });

        actionBarDrawerToggleCom = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open , R.string.drawer_close ){

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
        actionBarDrawerToggleCom.setDrawerIndicatorEnabled(false);
        actionBarDrawerToggleCom.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawer.isDrawerOpen(GravityCompat.START)){
                    drawer.closeDrawer(GravityCompat.START); Log.e(TAG,"opened");
                } else{
                    drawer.openDrawer(GravityCompat.START);Log.e(TAG,"closed");
                }

            }
        });
        actionBarDrawerToggleCom.setHomeAsUpIndicator(R.drawable.menu);
        actionBarDrawerToggleCom.setDrawerSlideAnimationEnabled(true);
        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggleCom);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggleCom.syncState();
        setGroupIndicatorToRight();
    }

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
        List<String> community,helpinout, mypolicy, claims,legalStuff;
        String[] scommunity,shelpout, smypolicy, sclaims,slegalStuff;

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
        listDataChild.put(listDataHeader.get(0), community);
        listDataChild.put(listDataHeader.get(1), helpinout);
        listDataChild.put(listDataHeader.get(2), mypolicy); // Header, Child data
        listDataChild.put(listDataHeader.get(3), claims);
        listDataChild.put(listDataHeader.get(4), legalStuff);
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
        if(groupPosition == 0){
            if(childPosition == 0){
                gotoCommunityActivity();
            }
            if(childPosition == 1){
                gotoInviteActivity();
            }
            if(childPosition == 2){
                gotoPledgePoolActivity();
            }
        }
        if(groupPosition == 1){
            if(childPosition == 0){
                gotoCurrentProjectActivity();
            }
            if(childPosition == 2){
                gotoSuggestionActivity();
            }
            if(childPosition == 3){
                gotoCommunityQAActivity();
            }
        }
        if(groupPosition == 2){
            if(childPosition == 0){
                gotoMydetailsActivity();
            }
            if(childPosition == 1){
                gotoAddRemoveActivity();
            }
            if(childPosition == 2){
                gotoTodoActivity();
            }
            if(childPosition == 4){
                gotoCorrespondenceActivity();
            }
        }
        if(groupPosition == 3){
            if(childPosition == 0){
                gotoSubmitNewClaimsActivity();
            }
            if(childPosition == 1){
                gotoTrackMyClaimsActivity();
            }
            if(childPosition == 2){
                gotoClaimsInMyPoolActivity();
            }
            if(childPosition == 4){
                gotoReportafraudsterActivity();
            }
        }
        return false;
    }



    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggleCom.syncState();
    }
    private void setGroupIndicatorToRight() {
    /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        drawerList.setIndicatorBounds(width - getDipsFromPixel(35), width - getDipsFromPixel(5));
    }
    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 100.0f);
    }
    public void openAlerts(View view) {
        Intent intent = new Intent(this, AlertsActivity.class);
        startActivity(intent);
    }
    public void gotoAlertsActivity(){
        Intent intent = new Intent(this, AlertsActivity.class);
        startActivity(intent);
    }
    public void gotoCommunityActivity(){
        Intent intent = new Intent(this, CommunityActivity.class);
        startActivity(intent);
    }
    public void gotoDashboard(){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
    public void gotoInviteActivity(){
        Intent intent = new Intent(this, InviteActivity.class);
        startActivity(intent);
    }
    public void gotoPledgePoolActivity(){
        Intent intent = new Intent(this, PledgePoolActivity.class);
        startActivity(intent);
    }
    public void openHome(View view) {
        gotoDashboard();
    }

    public void gotoCurrentProjectActivity(){

    }
    public void gotoSuggestionActivity(){
        Intent intent = new Intent(this, SuggestionActivity.class);
        startActivity(intent);
    }
    public void gotoCommunityQAActivity(){
        Intent intent = new Intent(this, CommunityQAActivity.class);
        startActivity(intent);
    }
    public void gotoAddRemoveActivity(){
        Intent intent = new Intent(this, AddRemoveCoverActivity.class);
        startActivity(intent);
    }
    public void gotoMydetailsActivity(){
        Intent intent = new Intent(this, MyDetailsActivity.class);
        startActivity(intent);
    }
    public void gotoTodoActivity(){

    }
    public void gotoCorrespondenceActivity(){

    }
    public void gotoSubmitNewClaimsActivity(){

    }
    public void gotoTrackMyClaimsActivity(){
        Intent intent = new Intent(this, TrackMyClaimsActivity.class);
        startActivity(intent);
    }
    public void gotoClaimsInMyPoolActivity(){
        Intent intent = new Intent(this, MyPoolClaimActivity.class);
        startActivity(intent);
    }
    public void gotoReportafraudsterActivity(){

    }
    public void openDrawer(View view) {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START); Log.e(TAG,"opened");
        } else{
            drawer.openDrawer(GravityCompat.START);Log.e(TAG,"closed");
        }
    }
}
