package smashaway.goldenwork.com.smashaway;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class LoadingNIActivity extends AppCompatActivity {

    ImageView loadnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_ni);
        loadnext = (ImageView)findViewById(R.id.loadnext);
        loadnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCN();
            }
        });
    }
    private void gotoCN() {
        Intent intent = new Intent(this, LoadingOTPActivity.class);
        startActivity(intent);
    }
}
