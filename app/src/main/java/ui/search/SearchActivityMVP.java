package ui.search;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import global.GlobalModel;
import global.GlobalPresenter;
import global.GlobalView;
import io.reactivex.Observable;
import pojo.search.SearchResponse;
import pojo.search.StatusesItem;

public interface SearchActivityMVP {

    interface Model extends GlobalModel {
        Observable<SearchResponse> getSearchedTweetsObservable(String query, String result_type);

    }

    interface View extends GlobalView {
        void showNoNetworkSnackBarMessage();

        void showSearchResult(List<StatusesItem> result);

        void initRecyclerView(RecyclerView recyclerView);

        void handelErrorOnSearch(Throwable throwable);

        void showProgressBar();

        void hideProgressBar();

        void sortData();

    }

    interface Presenter extends GlobalPresenter {

        void onNext(SearchResponse statuses);

        void onError(Throwable error);

        void searchText(String query);

    }

}
