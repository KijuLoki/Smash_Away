package smashaway.goldenwork.com.smashaway;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class LoadingActivity extends AppCompatActivity {

    public ProgressBar progressBar;
    String TAG = "LOADING 1 ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(4);
        countTime();
    }

    private void countTime(){
        CountDownTimer ct = new CountDownTimer(5000,1000){
            @Override
            public void onTick(long l) {
                //mCircleView.setValue(0);
                //mCircleView.spin();
                int val = Integer.valueOf((int) (5000-l)/1000);
                progressBar.setProgress(val);
                Log.e(TAG, String.valueOf(val));
            }

            @Override
            public void onFinish() {
                gotoCN();
            }
        }.start();
    }
    private void gotoCN() {
        Intent intent = new Intent(this, LoadingNIActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loading, menu);
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
}
