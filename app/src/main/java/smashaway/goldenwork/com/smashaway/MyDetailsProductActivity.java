package smashaway.goldenwork.com.smashaway;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.iconics.view.IconicsImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import smashaway.goldenwork.com.smashaway.Adapters.NavAdapter;
import smashaway.goldenwork.com.smashaway.BClass.PoolItem;
import smashaway.goldenwork.com.smashaway.helpers.CircleTransform;

public class MyDetailsProductActivity extends AppCompatActivity
        implements ExpandableListView.OnChildClickListener  {

    SharedPreferences sm_pref;
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
    String user = "";
    String user_pic ="";
    ImageView profile_icon;
    TextView title, lblListHeader60;
    LinearLayout head6, sub6, head5, sub50, sub51;
    IconicsImageView house_icon6, house_icon5;
    boolean open6= false, open5= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = "UserName";
        user_pic = "http://events.gartner.com/globalimages/global/speakers/2/speaker-751864.png";
        title = (TextView)findViewById(R.id.title);
        profile_icon = (ImageView)findViewById(R.id.profile_icon);

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

//init content
        head6 = (LinearLayout)findViewById(R.id.head6);
        sub6 = (LinearLayout)findViewById(R.id.sub6);
        lblListHeader60 = (TextView)findViewById(R.id.lblListHeader60);
        house_icon6 = (IconicsImageView)findViewById(R.id.house_icon6);
        house_icon5 = (IconicsImageView)findViewById(R.id.house_icon5);
        sub6.setVisibility(View.GONE);
        head5 = (LinearLayout)findViewById(R.id.head5);
        sub50 = (LinearLayout)findViewById(R.id.sub50);
        sub51 = (LinearLayout)findViewById(R.id.sub51);
        sub50.setVisibility(View.GONE);
        sub51.setVisibility(View.GONE);
        head6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open6){
                    sub6.setVisibility(View.GONE);
                    house_icon6.setColorRes(R.color.colorBlack);
                    open6 = false;
                } else{
                    sub6.setVisibility(View.VISIBLE);
                    open6 = true;
                    house_icon6.setColorRes(R.color.colorAccent);
                }
            }
        });
        head5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open5){
                    sub50.setVisibility(View.GONE);
                    sub51.setVisibility(View.GONE);
                    house_icon5.setColorRes(R.color.colorBlack);
                    open5 = false;
                } else{
                    sub50.setVisibility(View.VISIBLE);
                    sub51.setVisibility(View.VISIBLE);
                    open5 = true;
                    house_icon5.setColorRes(R.color.colorAccent);
                }
            }
        });


        initDashbord();
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
        getMenuInflater().inflate(R.menu.my_details_product, menu);
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
        title.setText(user);
        Picasso.with(this)
                .load(user_pic)
                .placeholder(R.drawable.account_circle)
                .error(R.drawable.account_circle)
                .transform(new CircleTransform())
                .into(profile_icon );
        String mytext = "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. \n";
        mytext += "\u2022 Bullet"+"Contrary to popular belief, Lorem Ipsum is not simply random text. \n";
        lblListHeader60.setText(mytext);


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
        Intent intent = new Intent(this, CurrentProjectsActivity.class);
        startActivity(intent);
    }
    public void gotoSuggestionActivity(){

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
        Intent intent = new Intent(this, SubmitClaimActivity.class);
        startActivity(intent);
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
        Intent intent = new Intent(this, ReportFraudsterActivity.class);
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
