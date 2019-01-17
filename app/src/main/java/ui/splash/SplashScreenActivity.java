package ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.twittersearch.ashish.twittersearch.R;

import java.util.Timer;
import java.util.TimerTask;

import ui.search.SearchActivity;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenActivityMVP.View {


    long delayTime = 3500;

    Intent myIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Transparent Status Bar
        setStatusBarTransparent();

        // Create a Timer
        Timer RunSplash = new Timer();
        // Task to do when the timer ends
        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {
                navigateToSearchActivity();
            }
        };

        // Start the timer
        RunSplash.schedule(ShowSplash, delayTime);
    }


    @Override
    public void navigateToSearchActivity() {
        myIntent = new Intent(SplashScreenActivity.this, SearchActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(myIntent);
        SplashScreenActivity.this.finish();
    }

    @Override
    public void setStatusBarTransparent() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void initView() {

    }

    @Override
    public void injectDependency() {

    }

}
