package ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.twittersearch.ashish.twittersearch.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import ui.search.SearchActivity;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenActivityMVP.View {


    long delayTime = 3500;

    Intent myIntent;

    @BindView(R.id.iv_splashLogo)
    ImageView ivSplashLogo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this); // butterKnife
        initView(); // view

        // Transparent Status Bar
        setStatusBarTransparent();


        ivSplashLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
        ivSplashLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                navigateToSearchActivity();
            }
        }, delayTime);

    }

    @Override
    public void navigateToSearchActivity() {
        myIntent = new Intent(SplashScreenActivity.this, SearchActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(SplashScreenActivity.this, ivSplashLogo, ViewCompat.getTransitionName(ivSplashLogo));
        startActivity(myIntent, options.toBundle());
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
