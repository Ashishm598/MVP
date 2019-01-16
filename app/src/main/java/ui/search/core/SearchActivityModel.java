package ui.search.core;

import ui.search.SearchActivityMVP;

public class SearchActivityModel implements SearchActivityMVP.Model {

    @Override
    public boolean isNetworkAvailable() {
        return false;
    }

}
