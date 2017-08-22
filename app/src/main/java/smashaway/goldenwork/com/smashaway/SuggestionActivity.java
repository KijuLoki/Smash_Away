package smashaway.goldenwork.com.smashaway;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.iconics.view.IconicsImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import smashaway.goldenwork.com.smashaway.Adapters.NavAdapter;
import smashaway.goldenwork.com.smashaway.Adapters.PledgePoolAdapter;
import smashaway.goldenwork.com.smashaway.BClass.PoolItem;

public class SuggestionActivity extends AppCompatActivity
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
    LinearLayout head0, head1,head2,head3, sub00, sub10, sub20, sub21, sub22, sub30,  sub200,sub210,sub220, choice, input0;
    IconicsImageView house_icon0, house_icon1,house_icon2, house_icon3, house_icon20, house_icon21, house_icon22;
    boolean open0= false, open1=false, open2 =false, open3=false,open20=false, open21=false, open22=false;
    TextView lblListHeaderchoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
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
        house_icon2 = (IconicsImageView)findViewById(R.id.house_icon2);
        house_icon3 = (IconicsImageView)findViewById(R.id.house_icon3);
        house_icon20 = (IconicsImageView)findViewById(R.id.house_icon20);
        house_icon21 = (IconicsImageView)findViewById(R.id.house_icon21);
        house_icon22 = (IconicsImageView)findViewById(R.id.house_icon22);
        lblListHeaderchoice = (TextView)findViewById(R.id.lblListHeaderchoice);

        head0 = (LinearLayout)findViewById(R.id.head0);
        sub00 = (LinearLayout)findViewById(R.id.sub00);
        sub00.setVisibility(View.GONE);
        head1 = (LinearLayout)findViewById(R.id.head1);
        sub10 = (LinearLayout)findViewById(R.id.sub10);
        sub10.setVisibility(View.GONE);
        head2 = (LinearLayout)findViewById(R.id.head2);
        sub20 = (LinearLayout)findViewById(R.id.sub20);
        sub20.setVisibility(View.GONE);
        sub200 = (LinearLayout)findViewById(R.id.sub200);
        sub200.setVisibility(View.GONE);
        sub21 = (LinearLayout)findViewById(R.id.sub21);
        sub21.setVisibility(View.GONE);
        sub210 = (LinearLayout)findViewById(R.id.sub210);
        sub210.setVisibility(View.GONE);
        sub22 = (LinearLayout)findViewById(R.id.sub22);
        sub22.setVisibility(View.GONE);
        sub220 = (LinearLayout)findViewById(R.id.sub220);
        sub220.setVisibility(View.GONE);
        head3 = (LinearLayout)findViewById(R.id.head3);
        sub30 = (LinearLayout)findViewById(R.id.sub30);
        sub30.setVisibility(View.GONE);
        choice = (LinearLayout)findViewById(R.id.choice);
        choice.setVisibility(View.GONE);
        input0 = (LinearLayout)findViewById(R.id.input0);
        input0.setVisibility(View.GONE);
        head0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open0){
                    hideView0(sub00);
                } else{
                    showView0(sub00);
                }

            }
        });
        head1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open1){
                    hideView1(sub10);
                } else{
                    showView1(sub10);
                }

            }
        });
        head3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open3){
                    hideView3(sub30);
                } else{
                    showView3(sub30);
                }

            }
        });
        head2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open2){
                    hideView2(sub20, sub21, sub22);Log.e(TAG, "head2 clicked");
                } else{
                    showView2(sub20, sub21, sub22);Log.e(TAG, "head2 clicked closed");
                }

            }
        });
        sub20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open20){
                    sub200.setVisibility(View.GONE);
                    open20 = false;
                    house_icon20.setColorRes(R.color.colorBlack);
                } else{
                    sub200.setVisibility(View.VISIBLE);
                    open20 = true;
                    house_icon20.setColorRes(R.color.colorAccent);
                }

            }
        });
        sub21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open21){
                    sub210.setVisibility(View.GONE);
                    open21 = false;
                    house_icon21.setColorRes(R.color.colorBlack);
                } else{
                    sub210.setVisibility(View.VISIBLE);
                    open21 = true;
                    house_icon21.setColorRes(R.color.colorAccent);
                }

            }
        });
        sub22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open22){
                    sub220.setVisibility(View.GONE);
                    open22 = false;
                    house_icon22.setColorRes(R.color.colorBlack);
                } else{
                    sub220.setVisibility(View.VISIBLE);
                    open22 = true;
                    house_icon22.setColorRes(R.color.colorAccent);
                }

            }
        });
        sub00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViews("Processes");
            }
        });
        sub10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViews("Website");
            }
        });
        sub200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViews("Mobile Application - User friendliness");
            }
        });
        sub210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViews("Mobile Application - Performance");
            }
        });
        sub220.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViews("Mobile Application - Features");
            }
        });
        sub30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViews("Other");
            }
        });
        initDashbord();
        initDrawer();
    }

    private void openViews(String other) {
        choice.setVisibility(View.VISIBLE);
        input0.setVisibility(View.VISIBLE);
        lblListHeaderchoice.setText(other);
        hideView0(sub00);
        hideView1(sub10);
        hideView2(sub20, sub21, sub22);Log.e(TAG, "head2 clicked");
        hideView3(sub30);
    }
    private void hideViews(){
        choice.setVisibility(View.GONE);
        input0.setVisibility(View.GONE);
    }

    private void showView2(LinearLayout sub20, LinearLayout sub21, LinearLayout sub22) {
        sub20.setVisibility(View.VISIBLE);
        sub21.setVisibility(View.VISIBLE);
        sub22.setVisibility(View.VISIBLE);
        house_icon2.setColorRes(R.color.colorAccent);
        open2 = true;
        hideViews();
    }
    private void hideView2(LinearLayout sub20, LinearLayout sub21, LinearLayout sub22) {
        sub20.setVisibility(View.GONE);
        sub21.setVisibility(View.GONE);
        sub22.setVisibility(View.GONE);
        sub200.setVisibility(View.GONE);
        sub210.setVisibility(View.GONE);
        sub220.setVisibility(View.GONE);
        house_icon2.setColorRes(R.color.colorBlack);
        house_icon20.setColorRes(R.color.colorBlack);
        house_icon21.setColorRes(R.color.colorBlack);
        house_icon22.setColorRes(R.color.colorBlack);
        open20 = false;
        open21=false;
        open22=false;
        open2=false;
    }
    private void showView0(LinearLayout sub00) {
        sub00.setVisibility(View.VISIBLE);
        house_icon0.setColorRes(R.color.colorAccent);
        open0 = true;
        hideViews();
    }
    private void hideView0(LinearLayout sub00) {
        sub00.setVisibility(View.GONE);
        house_icon0.setColorRes(R.color.colorBlack);
        open0=false;
    }

    private void showView1(LinearLayout sub10) {
        sub10.setVisibility(View.VISIBLE);
        house_icon1.setColorRes(R.color.colorAccent);
        open1 = true;
        hideViews();
    }
    private void hideView1(LinearLayout sub10) {
        sub10.setVisibility(View.GONE);
        house_icon1.setColorRes(R.color.colorBlack);
        open1=false;
    }

    private void showView3(LinearLayout sub30) {
        sub30.setVisibility(View.VISIBLE);
        house_icon3.setColorRes(R.color.colorAccent);
        open3 = true;
        hideViews();
    }
    private void hideView3(LinearLayout sub30) {
        sub30.setVisibility(View.GONE);
        house_icon3.setColorRes(R.color.colorBlack);
        open3=false;
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
        getMenuInflater().inflate(R.menu.suggestion, menu);
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
            }            if(childPosition == 3){
                gotoCommunityQAActivity();
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
        Intent intent = new Intent(this, CurrentProjectsActivity.class);
        startActivity(intent);
    }
    public void gotoSuggestionActivity(){

    }
    public void gotoCommunityQAActivity(){
        Intent intent = new Intent(this, CommunityQAActivity.class);
        startActivity(intent);
    }
    public void openDrawer(View view) {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START); Log.e(TAG,"opened");
        } else{
            drawer.openDrawer(GravityCompat.START);Log.e(TAG,"closed");
        }
    }
}
