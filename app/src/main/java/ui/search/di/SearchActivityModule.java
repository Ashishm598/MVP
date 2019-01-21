package ui.search.di;

import api.API;
import dagger.Module;
import dagger.Provides;
import ui.search.SearchActivity;
import ui.search.core.SearchActivityModel;
import ui.search.core.SearchActivityPresenter;
import utils.Util;

@Module
public class SearchActivityModule {

    SearchActivity searchActivity;

    public SearchActivityModule(SearchActivity searchActivity) {
        this.searchActivity = searchActivity;
    }

    @SearchActivityScope
    @Provides
    SearchActivity provideContext() {
        return this.searchActivity;
    }


    @SearchActivityScope
    @Provides
    SearchActivityPresenter providePresenter(SearchActivityModel model) {
        return new SearchActivityPresenter(searchActivity, model);
    }


    @SearchActivityScope
    @Provides
    SearchActivityModel provideModel(API api, Util util) {
        return new SearchActivityModel(api, util);
    }


    @SearchActivityScope
    @Provides
    Util provideUtil() {
        return new Util(searchActivity);
    }


}
