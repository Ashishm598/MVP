package ui.search.core;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import pojo.search.SearchResponse;
import ui.search.SearchActivityMVP;

public class SearchActivityPresenter implements SearchActivityMVP.Presenter {

    private SearchActivityMVP.View view;
    private SearchActivityModel model;
    private Observable<SearchResponse> searchResponseObservable;
    private Disposable disposable;
    private static final String RECENT_RESULT = "recent";
    public static final String POPULAR_RESULT = "popular";


    public SearchActivityPresenter(SearchActivityMVP.View view, SearchActivityModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }


    private void onNext(SearchResponse result) {
        view.showSearchResult(result.statusesItems());
    }

    private void onError(Throwable error) {
        view.hideProgressBar();
        view.handelErrorOnSearch(error);
    }

    @Override
    public void searchText(String query) {
        if (model.isNetworkAvailable()) {

            view.showProgressBar();

            searchResponseObservable = model.getSearchedTweetsObservable(query, RECENT_RESULT);

            if (searchResponseObservable != null) {
                if (disposable != null)
                    disposable.dispose();

                disposable = searchResponseObservable.subscribe(this::onNext, this::onError);
            }
        } else {
            view.hideProgressBar();
            view.showNoNetworkSnackBarMessage();
        }
    }
}




