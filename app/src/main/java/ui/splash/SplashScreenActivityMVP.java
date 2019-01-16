package ui.splash;

import global.GlobalModel;
import global.GlobalPresenter;
import global.GlobalView;

public interface SplashScreenActivityMVP {

    interface Model extends GlobalModel {

    }

    interface View  extends GlobalView {
        void navigateToSearchActivity();
        void setStatusBarTransparent();
    }

    interface Presenter extends GlobalPresenter {


    }

}
