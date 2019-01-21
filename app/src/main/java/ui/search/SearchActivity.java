package ui.search;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.twittersearch.ashish.twittersearch.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import application.App;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pojo.search.StatusesItem;
import timber.log.Timber;
import ui.search.adapter.TweetsListAdapter;
import ui.search.core.SearchActivityPresenter;
import ui.search.di.DaggerSearchActivityComponent;
import ui.search.di.SearchActivityModule;
import utils.Util;

public class SearchActivity extends AppCompatActivity implements SearchActivityMVP.View {

    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;

    @BindView(R.id.searchView)
    SearchView searchView;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.tv_response)
    TextView tvResponse;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.iv_sortBtn)
    ImageView ivSortBtn;

    @Inject
    SearchActivityPresenter presenter;

    @Inject
    Util util;

    TweetsListAdapter tweetsListAdapter;
    List<StatusesItem> statusesItems;

    ConstraintSet mConstraintSet1 = new ConstraintSet(); // create a Constraint Set
    ConstraintSet mConstraintSet2 = new ConstraintSet(); // create a Constraint Set


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        injectDependency(); // Dagger
        ButterKnife.bind(this); // ButterKnife
        initView(); // view init

        mConstraintSet1.clone(constraintLayout); // get constraints from ConstraintSet
        mConstraintSet2.clone(this, R.layout.activity_search_final); // get constraints from final

        //setup RecyclerView
        initRecyclerView(recyclerView);

        // onFocus of searchView animate the constraints
        searchView.setOnQueryTextFocusChangeListener(onFocusChangeListener);

        // onTextChangeListener
        searchView.setOnQueryTextListener(mOnQueryTextListener);

    }


    @Override
    public void initView() {

    }

    @Override
    public void injectDependency() {
        DaggerSearchActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .searchActivityModule(new SearchActivityModule(this))
                .build()
                .inject(this);
    }


    @Override
    public void onBackPressed() {
        if (searchView.isIconified()) {
            searchView.setIconified(false);
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to exit?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, (DialogInterface.OnClickListener) (dialog, which) -> finish()).create().show();
        }
    }

    @Override
    public void showNoNetworkSnackBarMessage() {
        util.displayNoInternetSnackBar(this, findViewById(android.R.id.content));
    }


    @Override
    public void showSearchResult(List<StatusesItem> response) {
        if (response != null && response.size() > 0) {
            tweetsListAdapter.setSearchedData(response);
            hideProgressBar();
        } else {
            hideProgressBar();
        }
    }

    @Override
    public void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        statusesItems = new ArrayList<>();
        tweetsListAdapter = new TweetsListAdapter(this, statusesItems);
        recyclerView.setAdapter(tweetsListAdapter);
    }

    @Override
    public void handelErrorOnSearch(Throwable throwable) {
        Timber.tag("search_error").e(throwable.getCause());
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void sortData() {
        //TODO SORT ALGORITHM
    }


    View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            TransitionManager.beginDelayedTransition(constraintLayout);
            mConstraintSet2.applyTo(constraintLayout); // set new constraints
        }
    };


    SearchView.OnQueryTextListener mOnQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String string) {
            presenter.searchText(string);
            return true;
        }

        @Override
        public boolean onQueryTextChange(String string) {
            presenter.searchText(string);
            return true;
        }
    };

    @OnClick(R.id.iv_sortBtn)
    public void onViewClicked() {
        sortData();
    }
}
