package application;

import android.app.Application;

import application.builder.AppComponent;
import application.builder.AppContextModule;
import application.builder.DaggerAppComponent;

public class App extends Application {


    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // AppComponent Dagger
        appComponent = DaggerAppComponent.builder()
                .appContextModule(new AppContextModule(this))
                .build();


    }


    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
