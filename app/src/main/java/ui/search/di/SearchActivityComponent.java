package ui.search.di;

import application.builder.AppComponent;
import dagger.Component;
import ui.search.SearchActivity;

@SearchActivityScope
@Component(dependencies = {AppComponent.class}, modules = {SearchActivityModule.class})
public interface SearchActivityComponent {
    void inject(SearchActivity searchActivity);
}
