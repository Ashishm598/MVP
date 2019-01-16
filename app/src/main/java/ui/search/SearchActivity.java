package ui.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.twittersearch.ashish.twittersearch.R;

public class SearchActivity extends AppCompatActivity implements SearchActivityMVP.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }


    @Override
    public void initView() {

    }

    @Override
    public void injectDependency() {

    }
}
