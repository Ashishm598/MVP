package ui.search;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.twittersearch.ashish.twittersearch.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements SearchActivityMVP.View {

    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;

    @BindView(R.id.searchView)
    SearchView searchView;

    ConstraintSet mConstraintSet1 = new ConstraintSet(); // create a Constraint Set
    ConstraintSet mConstraintSet2 = new ConstraintSet(); // create a Constraint Set


    View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            TransitionManager.beginDelayedTransition(constraintLayout);
            mConstraintSet2.applyTo(constraintLayout); // set new constraints
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        injectDependency(); // Dagger
        ButterKnife.bind(this); // ButterKnife
        initView(); // view init

        mConstraintSet1.clone(constraintLayout); // get constraints from ConstraintSet
        mConstraintSet2.clone(this, R.layout.activity_search_final); // get constraints from final

        // onFocus of searchView animate the constraints
        searchView.setOnQueryTextFocusChangeListener(onFocusChangeListener);


    }


    @Override
    public void initView() {

    }

    @Override
    public void injectDependency() {

    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
