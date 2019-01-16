package ui.splash.core;

import ui.splash.SplashScreenActivityMVP;

public class SplashScreenModel implements SplashScreenActivityMVP.Model {


    @Override
    public boolean isNetworkAvailable() {
        return false;
    }
}
