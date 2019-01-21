package ui.search.core;

import java.util.concurrent.TimeUnit;

import api.API;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pojo.search.SearchResponse;
import ui.search.SearchActivityMVP;
import utils.Util;

public class SearchActivityModel implements SearchActivityMVP.Model {

    private API api;
    private Util util;
    private Observable<SearchResponse> searchResponseObservable;

    public SearchActivityModel(API api, Util util) {
        this.api = api;
        this.util = util;
    }

    @Override
    public boolean isNetworkAvailable() {
        return util.isNetworkAvailable();
    }

    @Override
    public Observable<SearchResponse> getSearchedTweetsObservable(String query, String result_type) {
        return api.getTweetsByQuery(query, result_type)
                .debounce(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
